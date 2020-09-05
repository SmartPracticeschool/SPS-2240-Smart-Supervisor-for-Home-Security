package com.varun.homesecure;

import androidx.appcompat.app.AppCompatActivity;

import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;

import static android.provider.Contacts.SettingsColumns.KEY;

public class ImageView extends AppCompatActivity {
    private android.widget.ImageView imageView;
    private String URL ="https://sendpic.s3.ap-south-1.amazonaws.com/capture.jpg";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);
        imageView= findViewById(R.id.viewImage);
        LoadImg loadImg = new LoadImg(imageView);
        loadImg.execute(URL);
    }
    private class LoadImg extends AsyncTask<String,Void,Bitmap> {
        android.widget.ImageView im;
        public LoadImg(android.widget.ImageView res){
            this.im = res;
        }

        @Override
        protected Bitmap doInBackground(String... strings) {
            Bitmap b= null;
            try{
                InputStream inputStream = new java.net.URL(strings[0]).openStream();
                b = BitmapFactory.decodeStream(inputStream);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return b;
        }
        @Override
        protected void onPostExecute(Bitmap bitmap){
            im.setImageBitmap(bitmap);
        }
    }

}