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
public class CustomlistAdapter extends BaseAdapter{
//    private LayoutInflater inflater;
    Context listcontext;
    ArrayList<Qlist> qlist;

    public CustomlistAdapter(Context listcontext, ArrayList<Qlist> qlist) {
//        inflater = LayoutInflater.from(listcontext);
        this.listcontext = listcontext;
        this.qlist = qlist;
    }

    @Override
    public int getCount() {
        return qlist.size();
    }

    @Override
    public Object getItem(int position) {
        return qlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    static class ViewListHolder {
        TextView Listquotes;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewListHolder listholder = new ViewListHolder();
        if (convertView == null){

            convertView = LayoutInflater.from(listcontext).inflate(R.layout.single_row,parent,false);
            listholder.Listquotes = (TextView)convertView.findViewById(R.id.single_text);

            convertView.setTag(listholder);
        }else

        {
            listholder = (ViewListHolder)convertView.getTag();
        }
        listholder.Listquotes.setText(qlist.get(position).getQuotes());

        listholder.Listquotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Quotes quotes = new Quotes();
//                FragmentManager fm1 = quotes.getChildFragmentManager();
                Bundle bundle = new Bundle();
//                FragmentTransaction ft = fm1.beginTransaction();
                bundle.putString("quotePos",qlist.get(position).getQuotes());
                quotes.setArguments(bundle);
//                ft.replace(R.id.activity_main, quotes);
//                ft.addToBackStack("");
//                ft.commitAllowingStateLoss();
                ((MainActivity) listcontext).getSupportFragmentManager()
                        .beginTransaction().replace(R.id.activity_main,quotes)
                        .addToBackStack("").commit();
            }
        });
        return convertView;
    }
}
