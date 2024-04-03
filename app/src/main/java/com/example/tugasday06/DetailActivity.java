package com.example.tugasday06;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener {
    private String name, price, specific;
    private int image;
    private ImageView imgDetail;
    private TextView txtDetailName, txtDetailPrice, txtDetailSpecific;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        imgDetail = findViewById(R.id.imgDetail);
        txtDetailName = findViewById(R.id.txtDetailName);
        txtDetailPrice = findViewById(R.id.txtDetailPrice);
        txtDetailSpecific = findViewById(R.id.txtDetailSpecific);

        name = getIntent().getStringExtra("name");
        price = getIntent().getStringExtra("price");
        specific = getIntent().getStringExtra("specific");
        image = getIntent().getIntExtra("image", 0);

        txtDetailName.setText(name);
        txtDetailPrice.setText(price);
        txtDetailSpecific.setText(specific);
        imgDetail.setImageResource(image);

        Button btnShare = findViewById(R.id.btnShare);
        btnShare.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnShare) {
            shareItem();
        }
    }

    private void shareItem() {
        BitmapDrawable drawable = (BitmapDrawable) imgDetail.getDrawable();
        Bitmap bitmap = drawable.getBitmap();

        try {
            Context context = getApplicationContext();
            File cachePath = new File(context.getCacheDir(), "images");
            cachePath.mkdirs();
            FileOutputStream stream = new FileOutputStream(cachePath + "/image.png"); // overwrites this image every time
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        File imagePath = new File(getApplicationContext().getCacheDir(), "images");
        File newFile = new File(imagePath, "image.png");
        Uri contentUri = FileProvider.getUriForFile(getApplicationContext(), "com.example.tugasday6.fileprovider", newFile);

        if (contentUri != null) {
            Intent shareIntent = new Intent();
            shareIntent.setAction(Intent.ACTION_SEND);
            shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            shareIntent.setDataAndType(contentUri, getContentResolver().getType(contentUri));

            String shareText = "Check out this product: " + name + "\nPrice: " + price + "\nDescription: " + specific;
            shareIntent.putExtra(Intent.EXTRA_TEXT, shareText);

            shareIntent.putExtra(Intent.EXTRA_STREAM, contentUri);
            shareIntent.setType("image/png");
            startActivity(Intent.createChooser(shareIntent, "Choose an app"));
        }
    }
}
