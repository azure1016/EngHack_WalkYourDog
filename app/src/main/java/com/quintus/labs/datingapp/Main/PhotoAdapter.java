package com.quintus.labs.datingapp.Main;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.quintus.labs.datingapp.R;
import com.quintus.labs.datingapp.Models.Cards;

import java.util.List;

/**
 * Created by Quintus Labs on 19-Dec-2018.
 * www.quintuslabs.com
 */

public class PhotoAdapter extends ArrayAdapter<Cards> {
    Context mContext;


    public PhotoAdapter(@NonNull Context context, int resource, @NonNull List<Cards> objects) {
        super(context, resource, objects);
        this.mContext = context;
    }

    public View getView(final int position, View convertView, ViewGroup parent) {
        final Cards card_item = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item, parent, false);
        }

        TextView name = convertView.findViewById(R.id.name);
        ImageView image = convertView.findViewById(R.id.image);
        ImageButton btnInfo = convertView.findViewById(R.id.checkInfoBeforeMatched);

        name.setText(card_item.getName());
        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, ProfileCheckinMain.class);
                intent.putExtra("name", card_item.getName());
                intent.putExtra("img", card_item.getImg());
                intent.putExtra("rating", card_item.getRating());
                mContext.startActivity(intent);
            }
        });

        name.setText(card_item.getName());

        switch (card_item.getImg()) {
            case "defaultFemale":
                Glide.with(getContext()).load(R.drawable.default_woman).into(image);
                break;
            case "defaultMale":
                Glide.with(getContext()).load(R.drawable.default_man).into(image);
                break;
            default:
                Glide.with(getContext()).load(card_item.getImg()).into(image);
                break;
        }

        return convertView;
    }
}
