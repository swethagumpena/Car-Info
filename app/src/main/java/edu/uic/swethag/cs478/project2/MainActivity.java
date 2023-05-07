package edu.uic.swethag.cs478.project2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    protected static final String EXTRA_RES_ID = "ID";
    protected static final String IMAGE_POS = "POS";

    private ArrayList<Integer> mCars_thumbnails = new ArrayList<>(
            Arrays.asList(R.drawable.image1_thumb, R.drawable.image2_thumb,
                    R.drawable.image3_thumb, R.drawable.image4_thumb, R.drawable.image5_thumb,
                    R.drawable.image6_thumb, R.drawable.image7_thumb, R.drawable.image8_thumb));


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Inflate the main layout (from the res folder)
        setContentView(R.layout.activity_main);

        // Retrieve GridView declared in layout file
        GridView gridview = findViewById(R.id.gridview);

        // Create a new ImageAdapter and set it as the Adapter for this GridView
        gridview.setAdapter(new ImageAdapter(this, R.layout.grid_item, mCars_thumbnails, getResources().getStringArray(R.array.carNames)));

        // Set an setOnItemClickListener on the GridView
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                //Create an Intent to start the ImageViewActivity
                Intent intent = new Intent(MainActivity.this, ImageViewActivity.class);

                // Add the ID and position of the thumbnail to display as Intent Extras
                intent.putExtra(EXTRA_RES_ID, (int) id);
                intent.putExtra(IMAGE_POS, position);

                // Start the ImageViewActivity
                startActivity(intent);
            }
        });
        registerForContextMenu(gridview);
    }

    // create context menu
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);
    }

    // options shown on click of context menu
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()) {
            //  View the entire picture
            case R.id.view_picture:
                Intent viewPictureIntent = new Intent(MainActivity.this, ImageViewActivity.class);
                viewPictureIntent.putExtra(EXTRA_RES_ID, (int) info.id);
                viewPictureIntent.putExtra(IMAGE_POS, info.position);
                startActivity(viewPictureIntent);
                return true;
            //  Show the official web page of the car manufacturer in a new activity
            case R.id.manufacturer_details:
                Intent openBrowserIntent = new Intent(Intent.ACTION_VIEW);
                openBrowserIntent.setData(Uri.parse(getResources().getStringArray(R.array.manufacturerLinks)[info.position]));
                startActivity(openBrowserIntent);
                return true;
            //  List view containing the names and addresses of at least two car dealers for the selected manufacturer in greater Chicago area
            case R.id.car_dealers:
                Intent openListViewIntent = new Intent(MainActivity.this, ListViewActivity.class);
                openListViewIntent.putExtra(IMAGE_POS, (int) info.position);
                startActivity(openListViewIntent);
                return true;
            default:
                return false;
        }
    }
}
