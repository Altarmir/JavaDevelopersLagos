package com.example.android.javadeveloperslagos;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {


    public static final String KEY_NAME = "name";
    public static final String KEY_IMAGE = "image";
    public static final String KEY_URL = "url";

    private List<ListItem> listItems;
    private Context context;

    public MyAdapter(List<ListItem> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final ListItem listItem = listItems.get(position);

        holder.textViewHead.setText(listItem.getHead());

        //  use the picasso

        Picasso.with(context)
                .load(listItem.getImageUrl())
                .resize(100, 100)
                .centerCrop()
                .into(holder.imageView);
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ListItem developersList1 = listItems.get(position);

                Intent skipIntent = new Intent(v.getContext(), ProfileActivity.class);
                skipIntent.putExtra(KEY_NAME, developersList1.getHead());
                skipIntent.putExtra(KEY_URL, developersList1.getAbout());
                skipIntent.putExtra(KEY_IMAGE, developersList1.getImageUrl());
                v.getContext().startActivity(skipIntent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView textViewHead;
        private ImageView imageView;
        private LinearLayout linearLayout;

        public ViewHolder(View itemView) {

            super(itemView);

            textViewHead = (TextView) itemView.findViewById(R.id.textViewHead);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.card);
        }
    }

}