package com.example.taras.task.adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.taras.task.R;
import com.example.taras.task.models.Photo;

import java.util.List;

/**
 * Created by taras on 22.04.2016.
 */
public class PhotosAdapter extends RecyclerView.Adapter<PhotosAdapter.ViewHolder> {

    @Override
    public PhotosAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View contactView = inflater.inflate(R.layout.item_photo, parent, false);

        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(PhotosAdapter.ViewHolder holder, int position) {
        if (_photos == null) {
            return;
        }
        Photo photo = _photos.get(position);

        TextView imageAndDate = holder.imageAndDateTextView;

        imageAndDate.setText(photo.getDate());
        Drawable drawablePhoto = photo.getImage();
        drawablePhoto.setBounds(0, 0, 100, 100);
        imageAndDate.setCompoundDrawables(drawablePhoto, null, null, null);
    }

    @Override
    public int getItemCount() {
        if (_photos == null){
            return  0;
        }
        return _photos.size();
    }

    private List<Photo> _photos;

    public PhotosAdapter(List<Photo> photos) {
        _photos = photos;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView imageAndDateTextView;

        public ViewHolder(View itemView) {
            super(itemView);

            imageAndDateTextView = (TextView) itemView.findViewById(R.id.photo_and_date);
        }
    }
}
