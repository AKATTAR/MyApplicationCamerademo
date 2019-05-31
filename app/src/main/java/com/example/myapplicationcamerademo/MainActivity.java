package com.example.myapplicationcamerademo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {
Button btn;
ImageButton img;
ImageView imgv;
Bitmap bitmp;
Intent icam;
final static int picbuyc=10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
  img=findViewById(R.id.imageButton);
  btn=findViewById(R.id.button3);
  imgv=findViewById(R.id.imageView);
        InputStream is=getResources().openRawResource(R.raw.app);
        bitmp= BitmapFactory.decodeStream(is);

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                icam=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(icam,picbuyc);


            }
        });

btn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        try {
            getApplicationContext().setWallpaper(bitmp);
        }
        catch (IOException e){
            e.printStackTrace();

        }

    }
});


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==RESULT_OK){
            Bundle extras=data.getExtras();
            bitmp=(Bitmap)extras.get("data");
            img.setImageBitmap(bitmp);
        }
    }
}




