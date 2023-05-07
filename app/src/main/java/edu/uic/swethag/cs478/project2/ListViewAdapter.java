package edu.uic.swethag.cs478.project2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ListViewAdapter extends BaseAdapter {
    Context context;
    String[] dealerNames;
    String[] dealerAddresses;
    LayoutInflater inflater;

    //    Save the context. dealer names and dealer addresses
    public ListViewAdapter(Context context, String[] dealerNames, String[] dealerAddresses) {
        this.context = context;
        this.dealerNames = dealerNames;
        this.dealerAddresses = dealerAddresses;
    }

    @Override
    public int getCount() {
        return dealerNames.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    // Return textViews for each item referenced by the Adapter
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null) {
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_item, null);
        }

        TextView dealerName = convertView.findViewById(R.id.dealer_name);
        TextView dealerAddress = convertView.findViewById(R.id.dealer_address);

        dealerName.setText(dealerNames[position]);
        dealerAddress.setText(dealerAddresses[position]);

        return convertView;
    }
}

