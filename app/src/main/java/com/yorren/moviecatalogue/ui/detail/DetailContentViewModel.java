package com.yorren.moviecatalogue.ui.detail;

import androidx.lifecycle.ViewModel;

import com.yorren.moviecatalogue.data.Movies;
import com.yorren.moviecatalogue.data.TvShows;
import com.yorren.moviecatalogue.utils.DataDummy;

import java.util.ArrayList;

public class DetailContentViewModel extends ViewModel {
    private String moviesId;
    private String tvShowsId;

    public void setSelectedMovies(String moviesId) {
        this.moviesId = moviesId;
    }

    public void setSelectedTvShows(String tvShowsId) {
        this.tvShowsId = tvShowsId;
    }

    public Movies getMovies() {
        Movies movies = null;
        ArrayList<Movies> listMovies = DataDummy.generateDummyMovies();
        for (Movies movie : listMovies) {
            if (movie.getMovieId().equals(moviesId)) {
                movies = movie;
            }
        }
        return movies;
    }

    public TvShows getTvShows() {
        TvShows tvShows = null;
        ArrayList<TvShows> listTvShows = DataDummy.generateDummyTvShows();
        for (TvShows tvShow : listTvShows) {
            if (tvShow.getTvId().equals(tvShowsId)) {
                tvShows = tvShow;
            }
        }
        return tvShows;
    }
}
