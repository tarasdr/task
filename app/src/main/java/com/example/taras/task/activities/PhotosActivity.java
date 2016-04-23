package com.example.taras.task.activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.taras.task.R;
import com.example.taras.task.adapters.PhotosAdapter;
import com.example.taras.task.models.Photo;

import java.util.ArrayList;

public class PhotosActivity extends AppCompatActivity {

    private ArrayList<Photo> _photos = new ArrayList<Photo>();
    private Drawable _image;
    private static final int CAMERA_REQUEST = 1888;

    private PhotosAdapter _photosAdapter;
    private RecyclerView _photosList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photos);

        _photosList = (RecyclerView) findViewById(R.id.photos_list);
        _photosList.setHasFixedSize(true);

        _photosAdapter = new PhotosAdapter(_photos);
        _photosList.setAdapter(_photosAdapter);
        _photosList.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        Button addButton = (Button) findViewById((R.id.add_item));
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST);
            }
        });

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAMERA_REQUEST && resultCode == RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            _image = new BitmapDrawable(getResources(), photo);

            _photos.add(_photos.size(), new Photo(_image));
            _photosAdapter.notifyItemInserted(_photos.size());

            _photosList.scrollToPosition(_photosAdapter.getItemCount() - 1);
        }
    }
}
