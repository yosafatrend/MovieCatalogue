package com.yorren.moviecatalogue.ui.tvshows;

import com.yorren.moviecatalogue.data.TvShows;
import com.yorren.moviecatalogue.ui.movies.MoviesViewModelTest;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TvShowsViewModelTest {
    private TvShowsViewModel viewModel;

    @Before
    public void setUp(){
        viewModel = new TvShowsViewModel();
    }

    @Test
    public void getTvShows() {
        List<TvShows> tvShows = viewModel.getTvShows();
        assertNotNull(tvShows);
        assertEquals(9, tvShows.size());
    }
}