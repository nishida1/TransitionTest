package com.example.nishida.transitiontest;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ImageArrayAdapter extends ArrayAdapter<ListImageViewItem> {

    private int resourceId;
    private List<ListImageViewItem> items;
    private LayoutInflater inflater;

    public ImageArrayAdapter(Context context, int resourceId, List<ListImageViewItem> items) {
        super(context, resourceId, items);

        this.resourceId = resourceId;
        this.items = items;
        this.inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        if (convertView != null) {
            view = convertView;
        } else {
            view = this.inflater.inflate(this.resourceId, null);
        }

        ListImageViewItem item = this.items.get(position);

        TextView appInfoText = (TextView)view.findViewById(R.id.item_text);
        appInfoText.setText(item.getText());

        ImageView appInfoImage = (ImageView)view.findViewById(R.id.item_image);
        appInfoImage.setImageBitmap(item.getBitmap());

        return view;
    }
}
