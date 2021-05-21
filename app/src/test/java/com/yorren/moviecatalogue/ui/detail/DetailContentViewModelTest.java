package com.yorren.moviecatalogue.ui.detail;

import com.yorren.moviecatalogue.data.Movies;
import com.yorren.moviecatalogue.data.TvShows;
import com.yorren.moviecatalogue.utils.DataDummy;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DetailContentViewModelTest {
    private DetailContentViewModel viewModel;
    private Movies dummyMovies = DataDummy.generateDummyMovies().get(0);
    private TvShows dummyTvShows = DataDummy.generateDummyTvShows().get(0);
    private String moviesId = dummyMovies.getMovieId();
    private String tvshowsId = dummyTvShows.getTvId();

    @Before
    public void setUp() {
        viewModel = new DetailContentViewModel();
        viewModel.setSelectedMovies(moviesId);
        viewModel.setSelectedTvShows(tvshowsId);
    }

    @Test
    public void getMovies() {
        viewModel.setSelectedMovies(dummyMovies.getMovieId());
        Movies movies = viewModel.getMovies();
        assertNotNull(movies);
        assertEquals(dummyMovies.getMovieId(), movies.getMovieId());
        assertEquals(dummyMovies.getTitle(), movies.getTitle());
        assertEquals(dummyMovies.getDirector(), movies.getDirector());
        assertEquals(dummyMovies.getReleaseDate(), movies.getReleaseDate());
        assertEquals(dummyMovies.getDuration(), movies.getDuration());
        assertEquals(dummyMovies.getGenre(), movies.getGenre());
        assertEquals(dummyMovies.getStoryline(), movies.getStoryline());
        assertEquals(dummyMovies.getImagePath(), movies.getImagePath());
    }

    @Test
    public void getTvShows() {
        viewModel.setSelectedMovies(dummyTvShows.getTvId());
        TvShows tvShows = viewModel.getTvShows();
        assertNotNull(tvShows);
        assertEquals(dummyTvShows.getTvId(), tvShows.getTvId());
        assertEquals(dummyTvShows.getTitle(), tvShows.getTitle());
        assertEquals(dummyTvShows.getDirector(), tvShows.getDirector());
        assertEquals(dummyTvShows.getReleaseDate(), tvShows.getReleaseDate());
        assertEquals(dummyTvShows.getEpisodes(), tvShows.getEpisodes());
        assertEquals(dummyTvShows.getGenre(), tvShows.getGenre());
        assertEquals(dummyTvShows.getStoryline(), tvShows.getStoryline());
        assertEquals(dummyTvShows.getImagePath(), tvShows.getImagePath());
    }
}