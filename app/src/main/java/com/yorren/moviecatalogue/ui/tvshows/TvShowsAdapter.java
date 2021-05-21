package com.yorren.moviecatalogue.ui.tvshows;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.yorren.moviecatalogue.R;
import com.yorren.moviecatalogue.data.Movies;
import com.yorren.moviecatalogue.data.TvShows;
import com.yorren.moviecatalogue.databinding.ItemsBinding;
import com.yorren.moviecatalogue.ui.detail.DetailContentActivity;

import java.util.ArrayList;
import java.util.List;

public class TvShowsAdapter extends RecyclerView.Adapter<TvShowsAdapter.TvShowsHolder> {
    private final List<TvShows> listTvShows = new ArrayList<>();

    void setListTvShows(List<TvShows> listTvShows) {
        if (listTvShows == null) return;
        this.listTvShows.clear();
        this.listTvShows.addAll(listTvShows);
    }

    @NonNull
    @Override
    public TvShowsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemsBinding binding = ItemsBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new TvShowsHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull TvShowsHolder holder, int position) {
        TvShows tvShows = listTvShows.get(position);
        holder.bind(tvShows);
    }

    @Override
    public int getItemCount() {
        return listTvShows.size();
    }

    public class TvShowsHolder extends RecyclerView.ViewHolder {
        private final ItemsBinding binding;

        public TvShowsHolder(@NonNull ItemsBinding binding) {
            super(binding.getRoot());

            this.binding = binding;
        }

        void bind(TvShows tvShows){
            binding.tvItemTitle.setText(tvShows.getTitle());
            binding.tvItemDate.setText(tvShows.getReleaseDate());
            binding.tvItemDesc.setText(tvShows.getStoryline());

            itemView.setOnClickListener(v -> {
                Intent intent = new Intent(itemView.getContext(), DetailContentActivity.class);
                intent.putExtra(DetailContentActivity.EXTRA_CONTENT, tvShows.getTvId());
                itemView.getContext().startActivity(intent);
            });

            Glide.with(itemView.getContext())
                    .load(tvShows.getImagePath())
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
                    .centerCrop()
                    .into(binding.imgPoster);
        }
    }
}
