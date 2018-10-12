package com.example.user.ramiarram;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class SpotAdapter extends ArrayAdapter<Spot> {
        Context context;
        List<Spot> spotList;
        ImageView imageView;
        public SpotAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Spot> UserList) {
            super(context, resource, UserList);
            this.context=context;
            this.spotList=UserList;
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater layoutInflater = ((Activity) context).getLayoutInflater();
            View view = layoutInflater.inflate(R.layout.user_list, parent, false);
            Spot spot = spotList.get(position);

            TextView tvpUserName = (TextView) view.findViewById(R.id.tvSpotName);
       //     final ImageView imageView = (ImageView) view.findViewById(R.id.spotImage);

            return view;
        }
}
