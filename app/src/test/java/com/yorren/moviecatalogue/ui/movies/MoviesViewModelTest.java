package com.yorren.moviecatalogue.ui.movies;

import com.yorren.moviecatalogue.data.Movies;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class MoviesViewModelTest {
    private MoviesViewModel viewModel;

    @Before
    public void setUp() {
        viewModel = new MoviesViewModel();
    }

    @Test
    public void getMovies() {
        List<Movies> movies = viewModel.getMovies();
        assertNotNull(movies);
        assertEquals(10, movies.size());
    }
}