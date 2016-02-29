package com.example.todd.baseui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Ray on 2/26/2016.
 */
public class DevicesListAdapter extends ArrayAdapter<String>{

    private Context context;
    String devices[];
    int[] images;
    String descriptions[];
    LayoutInflater layoutInflater;

    public DevicesListAdapter(Context c, String[] dev, int[] imgs, String desc[])
    {
        super(c, R.layout.devices_row_model, dev);

        context = c;
        devices = dev;
        images = imgs;
        descriptions = desc;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null)
        {
            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.devices_row_model, null);
        }

        TextView device = (TextView) convertView.findViewById(R.id.header_txt);
        ImageView image = (ImageView ) convertView.findViewById(R.id.device_icon);
        TextView description = (TextView) convertView.findViewById(R.id.subheader_txt);

        device.setText(devices[position]);
        image.setImageResource(images[position]);
        description.setText(descriptions[position]);

        return convertView;
    }
}
