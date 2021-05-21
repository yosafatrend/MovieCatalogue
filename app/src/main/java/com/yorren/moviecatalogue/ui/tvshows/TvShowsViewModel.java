package com.yorren.moviecatalogue.ui.tvshows;

import androidx.lifecycle.ViewModel;

import com.yorren.moviecatalogue.data.TvShows;
import com.yorren.moviecatalogue.utils.DataDummy;

import java.util.List;

public class TvShowsViewModel extends ViewModel {
    public List<TvShows> getTvShows(){
        return DataDummy.generateDummyTvShows();
    }
}
