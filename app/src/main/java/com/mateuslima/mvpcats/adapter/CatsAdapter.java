package com.mateuslima.mvpcats.adapter;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.mateuslima.mvpcats.R;
import com.mateuslima.mvpcats.data.network.result.CatResult;

import java.util.List;

public class CatsAdapter extends RecyclerView.Adapter<CatsAdapter.MyViewHolder> {

    private List<CatResult> catsList;

    public CatsAdapter(List<CatResult> catsList) {
        this.catsList = catsList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.container_cats, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {
        CatResult cat = catsList.get(position);
        holder.progressBar.setVisibility(View.VISIBLE);
        Glide.with(holder.itemView.getContext()).load(cat.getUrl())
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        holder.progressBar.setVisibility(View.INVISIBLE);
                        return false;
                    }
                })
                .into(holder.imageCat);
    }

    @Override
    public int getItemCount() {
        return catsList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        private ImageView imageCat;
        private ProgressBar progressBar;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imageCat = itemView.findViewById(R.id.imageCats);
            progressBar = itemView.findViewById(R.id.progressCats);
        }
    }
}
