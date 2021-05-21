package com.yorren.moviecatalogue.ui.tvshows;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yorren.moviecatalogue.R;
import com.yorren.moviecatalogue.data.TvShows;
import com.yorren.moviecatalogue.databinding.FragmentMoviesBinding;
import com.yorren.moviecatalogue.databinding.FragmentTvShowsBinding;
import com.yorren.moviecatalogue.ui.movies.MoviesViewModel;

import java.util.List;

public class TvShowsFragment extends Fragment {
    private FragmentTvShowsBinding fragmentTvShowsBinding;

    public TvShowsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentTvShowsBinding = FragmentTvShowsBinding.inflate(inflater, container, false);
        return fragmentTvShowsBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getActivity() != null) {
            TvShowsViewModel viewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(TvShowsViewModel.class);
            List<TvShows> tvShows = viewModel.getTvShows();

            TvShowsAdapter tvShowsAdapter = new TvShowsAdapter();
            tvShowsAdapter.setListTvShows(tvShows);

            fragmentTvShowsBinding.rvTvshows.setLayoutManager(new LinearLayoutManager(getContext()));
            fragmentTvShowsBinding.rvTvshows.setHasFixedSize(true);
            fragmentTvShowsBinding.rvTvshows.setAdapter(tvShowsAdapter);
        }
    }
}