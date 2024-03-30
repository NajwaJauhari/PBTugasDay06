package com.example.tugasday06;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.ByteArrayOutputStream;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView imgDetail;
    private TextView txtDetail;
    private Button btnShare;
    public static final String KEY_DATA = "key_data";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        imgDetail = findViewById(R.id.imgDetail);
        txtDetail = findViewById(R.id.txtDetail);
        btnShare = findViewById(R.id.btnShare);

        Detail detail = getIntent().getParcelableExtra(KEY_DATA);

        String sourceImage = detail.getImage();
        int sourceImageID = getResources().getIdentifier(sourceImage, "drawable", getPackageName());
        imgDetail.setImageResource(sourceImageID);

        String specific = detail.getSpecific();
        String price = detail.getPrice();

        String gabungan = specific + price;

        txtDetail.setText(gabungan);
        btnShare.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnShare) {
            shareDetailAndImage();
        }
    }

    private void shareDetailAndImage() {
        BitmapDrawable bitmapDrawable = (BitmapDrawable) imgDetail.getDrawable();
        Bitmap bitmap = bitmapDrawable.getBitmap();

        Uri uri = saveImage(bitmap);

        String detailText = txtDetail.getText().toString();
        String shareText = detailText;
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("image/*");
        shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
        shareIntent.putExtra(Intent.EXTRA_TEXT, shareText);

        startActivity(Intent.createChooser(shareIntent, "Share Detail via"));
    }

    private Uri saveImage(Bitmap bitmap) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
        String path = MediaStore.Images.Media.insertImage(getContentResolver(), bitmap, "DetailImage", null);
        return Uri.parse(path);
    }
}
