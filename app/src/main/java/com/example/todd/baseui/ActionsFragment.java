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

public class ActionsFragment extends Fragment {
    ListView listView;
    String[] actions = {
            "Not Home",
            "Movie Time",
            "Spring Season",
            "Babysitting Crystal's Cat",
            "Dinner Date with Bae"};
    int[] icons = {
            R.mipmap.ic_security_shield,
            R.mipmap.ic_movie,
            R.mipmap.ic_flower,
            R.mipmap.ic_pets,
            R.mipmap.ic_sofa};

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.actions_tab,
                container, false);
        listView = (ListView) view.findViewById(R.id.actions_list);

        ActionsListAdapter actionsListAdapter =
                new ActionsListAdapter(getActivity(), actions, icons);
        listView.setAdapter(actionsListAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast toast = Toast.makeText(getActivity(), actions[position], Toast.LENGTH_SHORT);
                toast.show();
            }
        });

        return view;
    }
}
