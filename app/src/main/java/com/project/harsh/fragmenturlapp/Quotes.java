package com.project.harsh.fragmenturlapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ShareActionProvider;
import android.widget.TextView;

/**
 * Created by harsh on 19/2/17.
 */
public class Quotes extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.expandlist1, container, false);
        TextView txt = (TextView) view.findViewById(R.id.quotetxt);
        String quotes = getArguments().getString("quotePos");

        txt.setText(quotes);
        return view;
    }
//    code not found for share button on actionbar using fragment
}