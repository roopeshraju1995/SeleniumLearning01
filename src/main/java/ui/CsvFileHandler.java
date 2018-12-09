package ui;


import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class CsvFileHandler {

    private static final char FILE_SEPARATOR = ',';
    private static final char QUOTE = '"';
    private static final String CSV_FILE_TYPE = ".csv";

    public static <T> List<T> loadCsvFromFile(File file, Class<T> clazz) throws Exception {

        if (!file.getName().toLowerCase().endsWith(CSV_FILE_TYPE)) {
            throw new Exception(
                "File " + file.getName() + "is not a valid csv file. Please upload a .csv format file. ");
        }
        try(FileInputStream fis = new FileInputStream(file))  {
            List<T> allRows = getRows(clazz, fis);
            return allRows;
        }
    }

    private static <T> List<T> getRows(Class<T> clazz, InputStream fis) throws Exception {
        CSVReader reader = new CSVReader(new InputStreamReader(fis),
            FILE_SEPARATOR, QUOTE, 0);
        HeaderColumnNameMappingStrategy<T> beanStrategy = new HeaderColumnNameMappingStrategy<>();
        beanStrategy.setType(clazz);
        CsvToBean<T> csvToBean = new CsvToBean<>();
        List<T> allRows = csvToBean.parse(beanStrategy, reader);
        return allRows;
    }
}

