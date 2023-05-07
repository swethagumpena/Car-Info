package edu.uic.swethag.cs478.project2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Arrays;

public class ImageViewActivity extends AppCompatActivity {
    private ArrayList<Integer> mCars = new ArrayList<>(
            Arrays.asList(R.drawable.image1, R.drawable.image2,
                    R.drawable.image3, R.drawable.image4, R.drawable.image5,
                    R.drawable.image6, R.drawable.image7, R.drawable.image8));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);

        // Get the Intent used to start this Activity
        Intent intent = getIntent();

        // Example of programmatic layout definition: make a new ImageView
        ImageView imageView = new ImageView(getApplicationContext());

        // Get the position of the image to access the array element
        final int pos = intent.getIntExtra(MainActivity.IMAGE_POS, 0);

        // Get the ID of the image to display from the intent and set it as the image for this ImageView
        imageView.setImageResource(mCars.get(pos));

        // Define the content of this activity programmatically
        setContentView(imageView);

        // Intent to open the browser
        Intent openBrowserIntent = new Intent(Intent.ACTION_VIEW);

        imageView.setOnClickListener(v -> {
            openBrowserIntent.setData(Uri.parse(getResources().getStringArray(R.array.manufacturerLinks)[pos]));
            startActivity(openBrowserIntent);
        });
    }
}