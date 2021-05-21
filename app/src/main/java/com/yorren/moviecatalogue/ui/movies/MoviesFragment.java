package com.yorren.moviecatalogue.ui.movies;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ShareCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yorren.moviecatalogue.R;
import com.yorren.moviecatalogue.data.Movies;
import com.yorren.moviecatalogue.databinding.FragmentMoviesBinding;

import java.util.List;

public class MoviesFragment extends Fragment implements MoviesFragmentCallback {
    private FragmentMoviesBinding fragmentMoviesBinding;

    public MoviesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentMoviesBinding = FragmentMoviesBinding.inflate(inflater, container, false);
        return fragmentMoviesBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getActivity() != null) {
            MoviesViewModel viewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(MoviesViewModel.class);
            List<Movies> movies = viewModel.getMovies();

            MoviesAdapter adapter = new MoviesAdapter(this);
            adapter.setListMovies(movies);

            fragmentMoviesBinding.rvMovies.setLayoutManager(new LinearLayoutManager(getContext()));
            fragmentMoviesBinding.rvMovies.setHasFixedSize(true);
            fragmentMoviesBinding.rvMovies.setAdapter(adapter);
        }
    }

    @Override
    public void onShareClick(Movies movies) {
        if (getActivity() != null){
            String mimeType = "text/plain";
            ShareCompat.IntentBuilder
                    .from(getActivity())
                    .setType(mimeType)
                    .setChooserTitle("Bagikan aplikasi ini sekarang.")
                    .setText(getResources().getString(R.string.share_text, movies.getTitle()))
                    .startChooser();
        }
    }
}