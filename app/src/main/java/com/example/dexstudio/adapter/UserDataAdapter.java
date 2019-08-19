package com.example.dexstudio.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

import com.example.dexstudio.R;
import com.example.dexstudio.model.UserData;

public class UserDataAdapter extends RecyclerView.Adapter<UserDataAdapter.MovieViewHolder> {

    private List<UserData> userData;
    private int rowLayout;
    private Context context;


    public class MovieViewHolder extends RecyclerView.ViewHolder {
        private TextView txvTitle,txvDescription;
        private ImageView imgUserPhoto;

        public MovieViewHolder(View view) {
            super(view);
            txvTitle = (TextView) view.findViewById(R.id.txvTitle);
            txvDescription = (TextView) view.findViewById(R.id.txvDescription);
            imgUserPhoto = (ImageView) view.findViewById(R.id.imgUserAvatar);

        }
    }

    public UserDataAdapter(List<UserData> userData, int rowLayout, Context context) {
        this.userData = userData;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public UserDataAdapter.MovieViewHolder onCreateViewHolder(ViewGroup parent,
                                                              int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new MovieViewHolder(view);
    }


    @Override
    public void onBindViewHolder(MovieViewHolder holder, final int position) {
        System.out.println("imageurl:"+userData.get(position).imageHref);
        Glide.with(context)
                .load(userData.get(position).imageHref)
                .apply(new RequestOptions()
                        .error(R.drawable.star))
                .into(holder.imgUserPhoto);
        holder.txvTitle.setText(userData.get(position).title);
        holder.txvDescription.setText(userData.get(position).description);
    }

    @Override
    public int getItemCount() {
        return userData.size();
    }
}