package com.example.todd.baseui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.ListView;

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

    ActionsListAdapter actionsListAdapter;

    public ActionsListAdapter getActionsListAdapter() {
        return actionsListAdapter;
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.actions_tab,
                container, false);
        listView = (ListView) view.findViewById(R.id.actions_list);

        actionsListAdapter =
                new ActionsListAdapter(getActivity(), actions, icons);
        listView.setAdapter(actionsListAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                CheckBox checkBox = (CheckBox) view.findViewById(R.id.action_checkbox);
                checkBox.setChecked(!checkBox.isChecked());
            }
        });

        return view;
    }
}
