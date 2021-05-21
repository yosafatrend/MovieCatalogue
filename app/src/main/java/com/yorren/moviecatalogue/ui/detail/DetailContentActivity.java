package com.yorren.moviecatalogue.ui.detail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.yorren.moviecatalogue.R;
import com.yorren.moviecatalogue.data.Movies;
import com.yorren.moviecatalogue.data.TvShows;
import com.yorren.moviecatalogue.databinding.ActivityDetailContentBinding;
import com.yorren.moviecatalogue.databinding.ContentDetailBinding;

public class DetailContentActivity extends AppCompatActivity {
    public static final String EXTRA_CONTENT = "extra_content";
    private ContentDetailBinding contentDetailBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityDetailContentBinding activityDetailContentBinding = ActivityDetailContentBinding.inflate(getLayoutInflater());
        contentDetailBinding = activityDetailContentBinding.detailContent;

        setContentView(activityDetailContentBinding.getRoot());

        setSupportActionBar(activityDetailContentBinding.toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        DetailContentViewModel viewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(DetailContentViewModel.class);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String contentId = extras.getString(EXTRA_CONTENT);
            if (contentId != null && contentId.contains("m")) {
                viewModel.setSelectedMovies(contentId);
                populateMovies(viewModel.getMovies());
            }else if (contentId != null && contentId.contains("tv")){
                viewModel.setSelectedTvShows(contentId);
                populateTvShows(viewModel.getTvShows());
            }
        }

    }

    private void populateMovies(Movies movies) {
        contentDetailBinding.tvTitle.setText(movies.getTitle());
        contentDetailBinding.tvDirector.setText("Directed by : " +movies.getDirector());
        contentDetailBinding.tvDuration.setText("Duration : " +movies.getDuration());
        contentDetailBinding.tvReleaseDate.setText("Release date : " +movies.getReleaseDate());
        contentDetailBinding.tvSynopsis.setText(movies.getStoryline());
        contentDetailBinding.tvGenre.setText("Genre : " +movies.getGenre());

        Glide.with(this)
                .load(movies.getImagePath())
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
                .into(contentDetailBinding.imagePoster);
    }

    private void populateTvShows(TvShows tvShows) {
        contentDetailBinding.tvTitle.setText(tvShows.getTitle());
        contentDetailBinding.tvDirector.setText("Directed by : " +tvShows.getDirector());
        contentDetailBinding.tvDuration.setText("Episodes : " +tvShows.getEpisodes());
        contentDetailBinding.tvReleaseDate.setText("Release date : " +tvShows.getReleaseDate());
        contentDetailBinding.tvSynopsis.setText(tvShows.getStoryline());
        contentDetailBinding.tvGenre.setText("Genre : " +tvShows.getGenre());

        Glide.with(this)
                .load(tvShows.getImagePath())
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
                .into(contentDetailBinding.imagePoster);
    }
}