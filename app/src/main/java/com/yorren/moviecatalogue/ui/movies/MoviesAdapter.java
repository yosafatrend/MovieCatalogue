package com.yorren.moviecatalogue.ui.movies;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.yorren.moviecatalogue.R;
import com.yorren.moviecatalogue.data.Movies;
import com.yorren.moviecatalogue.databinding.ItemsBinding;
import com.yorren.moviecatalogue.ui.detail.DetailContentActivity;

import java.util.ArrayList;
import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder> {
    private final List<Movies> listMovies = new ArrayList<>();
    private final MoviesFragmentCallback callback;

    MoviesAdapter(MoviesFragmentCallback callback){
        this.callback = callback;
    }

    void setListMovies(List<Movies> listMovies) {
        if (listMovies == null) return;
        this.listMovies.clear();
        this.listMovies.addAll(listMovies);
    }

    @NonNull
    @Override
    public MoviesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemsBinding binding = ItemsBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new MoviesViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MoviesViewHolder holder, int position) {
        Movies movies = listMovies.get(position);
        holder.bind(movies);
    }

    @Override
    public int getItemCount() {
        return listMovies.size();
    }

    public class MoviesViewHolder extends RecyclerView.ViewHolder {
        private final ItemsBinding binding;

        public MoviesViewHolder(ItemsBinding binding) {
            super(binding.getRoot());

            this.binding = binding;
        }

        void bind(Movies movies) {
            binding.tvItemTitle.setText(movies.getTitle());
            binding.tvItemDate.setText(movies.getReleaseDate());
            binding.tvItemDesc.setText(movies.getStoryline());
            itemView.setOnClickListener(v -> {
                Intent intent = new Intent(itemView.getContext(), DetailContentActivity.class);
                intent.putExtra(DetailContentActivity.EXTRA_CONTENT, movies.getMovieId());
                itemView.getContext().startActivity(intent);
            });
            Glide.with(itemView.getContext())
                    .load(movies.getImagePath())
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
                    .centerCrop()
                    .into(binding.imgPoster);
            binding.imgShare.setOnClickListener(v -> callback.onShareClick(movies));
        }
    }
}
