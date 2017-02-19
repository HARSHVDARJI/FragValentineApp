package com.project.harsh.fragmenturlapp;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by harsh on 19/2/17.
 */
public class CustomGridAdapter extends BaseAdapter{
    Context context;
    ArrayList<Post> posts;

    CustomGridAdapter(Context context, ArrayList<Post> posts){
        this.context = context;
        this.posts = posts;
    }

    @Override
    public int getCount() {
        return posts.size();
    }

    @Override
    public Object getItem(int position) {
        return posts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    static class ViewHolder{
        TextView name;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        ViewHolder holder = new ViewHolder();
        if (convertView == null){
                convertView = LayoutInflater.from(context).inflate
                        (R.layout.single_row_grid_view, parent,false);
            holder.name = (TextView)convertView.findViewById(R.id.grid_cat);
            convertView.setTag(holder);
        }else
        {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.name.setText(posts.get(position).getName());
        holder.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ListActivity lactivity = new ListActivity();
//                FragmentManager fm1 = lactivity.getFragmentManager();
                Bundle bundle = new Bundle();
//                FragmentTransaction ft = fm1.beginTransaction();
                bundle.putInt("listquotes",posts.get(position).getId());
                lactivity.setArguments(bundle);
//                ft.replace(R.id.activity_main, lactivity);
//                ft.addToBackStack("");
//                ft.commit();
                ((MainActivity) context).getSupportFragmentManager()
                        .beginTransaction().replace(R.id.activity_main,lactivity)
                        .addToBackStack("").commit();

            }
        });
        return convertView;
    }
}
