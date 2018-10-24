package com.example.user.ramiarram;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class CameraGalleryActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int CAMERA_REQUEST=0;
    Button btCameraGallery, btGallery;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_gallery);

        btCameraGallery = (Button) findViewById(R.id.btCameraGalleryACtivity);
        btCameraGallery.setOnClickListener(this);
        imageView= (ImageView) findViewById(R.id.imageView);


        btGallery = (Button) findViewById(R.id.btGallery);
        btGallery.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if(v == btCameraGallery){
            Intent i = new Intent((MediaStore.ACTION_IMAGE_CAPTURE));
            startActivityForResult(i, CAMERA_REQUEST);
        } else{
            //later
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == CAMERA_REQUEST && resultCode == Activity.RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(photo);
        }
    }
}
