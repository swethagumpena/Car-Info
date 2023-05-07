package edu.uic.swethag.cs478.project2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ImageAdapter extends BaseAdapter {
    private int mResource;
    private Context mContext;  // This is passed to the ImageView
    private List<Integer> mCars;   // Adapter must store AdapterView's items
    private String[] mCarNames;

    // Save the list of image IDs, context, resource and names
    public ImageAdapter(Context c, int resource, List<Integer> ids, String[] car_names) {
        mContext = c;
        this.mResource = resource;
        this.mCars = ids;
        this.mCarNames = car_names;
    }

    // Methods inherited from abstract superclass BaseAdapter

    // Return the number of items in the Adapter
    @Override
    public int getCount() {
        return mCars.size();
    }

    // Return the data item at position
    @Override
    public Object getItem(int position) {
        return mCars.get(position);
    }

    // Will get called to provide the ID that is passed to OnItemClickListener.onItemClick()
    @Override
    public long getItemId(int position) {
        return mCars.get(position);
    }

    // Return an ImageView and textView for each item referenced by the Adapter
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        if (inflater == null) {
            inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if (convertView == null) {
            convertView = inflater.inflate(mResource, parent, false);
        }

        ImageView imageView = convertView.findViewById(R.id.grid_image);
        TextView textView = convertView.findViewById(R.id.item_name);

        // Put data (actual image reference) in imageView + text to display the name + return it
        imageView.setImageResource(mCars.get(position));
        textView.setText(mCarNames[position]);

        return convertView;
    }
}

