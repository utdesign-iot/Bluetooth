package com.example.todd.baseui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ActionsListAdapter extends ArrayAdapter<String>{

    private Context context;
    String actions[];
    int[] icons;
    LayoutInflater layoutInflater;

    public ActionsListAdapter(Context context, String[] actions, int[] icons)
    {
        super(context, R.layout.actions_row_model, actions);
        this.context = context;
        this.actions = actions;
        this.icons = icons;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        if(view == null)
        {
            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.actions_row_model, null);
        }

        TextView actionView = (TextView) view.findViewById(R.id.action_title);
        ImageView iconView = (ImageView) view.findViewById(R.id.action_icon_list);

        actionView.setText(actions[position]);
        iconView.setImageResource(icons[position]);

        return view;
    }
}
