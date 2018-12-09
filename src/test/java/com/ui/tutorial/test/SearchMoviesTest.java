package com.ui.tutorial.test;

import org.testng.annotations.Test;
import ui.SearchMovie;

public class SearchMoviesTest {


    SearchMovie searchMovie = new SearchMovie();


    @Test
    public void getMovies()
    {
//      searchMovie.readTheTestData();
      searchMovie.setBroswer();
      searchMovie.setBrowserConfig();
      searchMovie.runTest();
    }
}
