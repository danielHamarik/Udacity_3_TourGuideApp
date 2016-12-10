package com.example.android.udacity_3_tourguideapp;


import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ListArrayAdapter extends ArrayAdapter<Destination>{

    private Context context;

    public ListArrayAdapter(Context context) {
        super(context,R.layout.list_item);
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        ViewHolder holder;
        if(view == null){
            view =  LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
            holder = new ViewHolder();
            holder.image = (ImageView) view.findViewById(R.id.list_image);
            holder.title = (TextView) view.findViewById(R.id.list_title);
            holder.location = (TextView) view.findViewById(R.id.list_location);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }

        Destination dest = getItem(position);
        holder.image.setImageResource(dest.getImageSrc());
        holder.title.setText(dest.getTitle());
        holder.location.setText(dest.getLocation());

        return view;
    }

    private class ViewHolder{
        ImageView image;
        TextView title;
        TextView location;
    }
}
