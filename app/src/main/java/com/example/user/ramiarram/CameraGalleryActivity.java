package com.example.user.ramiarram;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CameraGalleryActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int CAMERA_REQUEST = 0;
    Button btCameraGallery, btGallery;
    ImageView imageView;

    private static final int SELECT_IMAGE = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_gallery);

        btCameraGallery = (Button) findViewById(R.id.btCameraGalleryACtivity);
        btCameraGallery.setOnClickListener(this);
        imageView = (ImageView) findViewById(R.id.imageView);


        btGallery = (Button) findViewById(R.id.btGallery);
        btGallery.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if (v == btCameraGallery) {
            Intent i = new Intent((MediaStore.ACTION_IMAGE_CAPTURE));
            startActivityForResult(i, CAMERA_REQUEST);
        } else {
            Intent i = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(i, SELECT_IMAGE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == CAMERA_REQUEST && resultCode == Activity.RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(photo);
            saveImage(photo);
        } else if (requestCode == SELECT_IMAGE && resultCode == Activity.RESULT_OK) {
            Uri targetUri = data.getData();
            try {
                Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(targetUri));
                imageView.setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

    }


    public String saveImage(Bitmap bitmap) {
        File root = Environment.getExternalStorageDirectory();

        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

        String filePath = root.getAbsolutePath() + "/DCIM/Camera/IMG_" + timeStamp + ".jpg";
        //Creating the object of type file.

        File file = new File(filePath);
        //detrmining the type of the file and its place.

        try {
            file.createNewFile();//create new file to save image
            FileOutputStream ostream = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, ostream);
            ostream.close();//close
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "Failed to save image", Toast.LENGTH_SHORT).show();
        }

        return filePath;
    }
}
