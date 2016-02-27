package com.example.todd.baseui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class DevicesFragment extends Fragment {
    public final static String URL = "http://ecs.utdallas.edu";
    ListView listView;
    String[] deviceNames = {
            "Humpus Wumpus",
            "Cool Guy",
            "Radiated Guy",
            "Crome guy"};
    String[] descriptions = {
            "http://utdallas.edu",
            "http://google.com",
            "http://yahoo.com",
            "http://ecs.utdallas.edu"};
    int[] imageIds = {R.drawable.ie_icon,
            R.drawable.cool_icon,
            R.drawable.rad_icon,
            R.drawable.chrome_icon};

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.devices_tab,
                container, false);
        listView = (ListView) rootView.findViewById(R.id.list);

        ImageListAdapter imgListAdapter =
                new ImageListAdapter(getActivity(), deviceNames, imageIds, descriptions);
        listView.setAdapter(imgListAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast toast = Toast.makeText(getActivity(), deviceNames[position], Toast.LENGTH_SHORT);
                //toast.show();
                Intent intent = new Intent(getContext(), BrowserActivity.class);
                intent.putExtra(URL, descriptions[position]);
                startActivity(intent);
            }
        });

        return rootView;
    }
}
