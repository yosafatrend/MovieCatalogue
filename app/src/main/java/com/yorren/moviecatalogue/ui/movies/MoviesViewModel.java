package com.yorren.moviecatalogue.ui.movies;

import androidx.lifecycle.ViewModel;

import com.yorren.moviecatalogue.data.Movies;
import com.yorren.moviecatalogue.utils.DataDummy;

import java.util.List;

public class MoviesViewModel extends ViewModel {
    public List<Movies> getMovies(){
        return DataDummy.generateDummyMovies();
    }
}
