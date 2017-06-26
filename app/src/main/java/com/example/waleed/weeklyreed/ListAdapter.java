package com.example.waleed.weeklyreed;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Waleed on 20/06/17.
 */

public class ListAdapter extends ArrayAdapter {

    List<Pages> pagesList = new ArrayList<>();
    TextView bookTextView;
    TextView numberTextView;
    ImageView bookImageView;

    public ListAdapter(Context context, int resource, ArrayList objects) {
        super(context, resource, objects);
        pagesList = objects;
    }

    @Override
    public int getCount() {
        return pagesList.size();
    }


    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.pages_view,null);

        bookImageView = (ImageView) convertView.findViewById(R.id.bookImageView);
        bookTextView = (TextView) convertView.findViewById(R.id.bookTextView);
        numberTextView = (TextView) convertView.findViewById(R.id.pageNumberTextView);

        Bitmap bmp = BitmapFactory.decodeByteArray(pagesList.get(position).
                        getBookPicture(), 0 , pagesList.get(position).
                        getBookPicture().length );

        bookImageView.setImageBitmap(bmp);
        bookTextView.setText(pagesList.get(position).getBookTitle());
        numberTextView.setText(pagesList.get(position).getPagesNumber());
        return convertView;
    }
}
