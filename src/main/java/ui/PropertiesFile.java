package ui;

import com.sun.imageio.spi.OutputStreamImageOutputStreamSpi;

import java.io.*;
import java.util.Properties;

public class PropertiesFile {


    Properties  pro = new Properties();


    public void readProperties()
    {
        try {
            InputStream input = new FileInputStream("/Users/coviam/Desktop/SeleniumLearning01/src/main/resources/config/config.properties");
            try {
                pro.load(input);
                pro.getProperty("browser");
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("Unable to load the properties file",e);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw  new RuntimeException("Unable to fetch the values from configuration properties file",e);
        }
    }


    public void writeProperties()
    {
        try {
            OutputStream output = new FileOutputStream("/Users/coviam/Desktop/SeleniumLearning01/src/main/resources/config/config.properties");
            pro.setProperty("result","pass");
            try {
                pro.store(output,null);
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("Unable to load values from configuration properties file",e);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Unable to write value from configuration properties file",e);
        }
    }
}
