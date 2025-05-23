package com.dzl.listapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ItemViewHolder> {

    private static final int TYPE_ITEM = 0;
    private static final int TYPE_ADD_BUTTON = 1;

    public interface OnItemClickListener {
        void onItemClick(Item item, int position);
    }

    private List<Item> itemList;
    private OnItemClickListener listener;

    public ItemsAdapter(List<Item> itemList, OnItemClickListener listener) {
        this.itemList = itemList;
        this.listener = listener;
    }

    @Override
    public int getItemCount() {
        return itemList.size() + 1;
    }

    @NonNull
    @Override
    public ItemsAdapter.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if (viewType == TYPE_ADD_BUTTON) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_add_button, parent, false);
        } else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);

        }
        return new ItemViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ItemsAdapter.ItemViewHolder holder, int position) {
        if (position == itemList.size()) {
            holder.bindAddButton();
        } else {
            holder.bind(itemList.get(position), listener, position);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == itemList.size()) {
            return TYPE_ADD_BUTTON;
        }
        return TYPE_ITEM;
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {

        ImageView itemImage;
        TextView itemTitle;
        TextView itemDescription;
        View rootLayout;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            itemImage = itemView.findViewById(R.id.image_view_item_icon);
            itemTitle = itemView.findViewById(R.id.text_view_title);
            itemDescription = itemView.findViewById(R.id.text_view_description);
            rootLayout = itemView.findViewById(R.id.relative_layout_item);
        }

        public void bind(Item item, OnItemClickListener listener, int position) {
            itemTitle.setText(item.name);
            itemDescription.setText(item.description);
            itemImage.setImageResource(item.image);

            rootLayout.setOnClickListener(v -> {
                int currentPosition = getAdapterPosition();
                if (currentPosition != RecyclerView.NO_POSITION) {
                    listener.onItemClick(item, currentPosition);
                }
            });
        }

        public void bindAddButton() {
            itemTitle.setText("+ Add New Item");
            itemDescription.setText("");
            itemImage.setImageResource(R.drawable.bucket);

            rootLayout.setOnClickListener(v -> {
                Context context = v.getContext();
                Intent intent = new Intent(context, AddItemActivity.class);
                ((Activity) context).startActivityForResult(intent, 2);
            });
        }
    }

}
