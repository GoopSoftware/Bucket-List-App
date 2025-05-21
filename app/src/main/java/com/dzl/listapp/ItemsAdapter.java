package com.dzl.listapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ItemViewHolder> {

    public interface OnItemClickListener {
        void onItemClick(Item item);
    }

    private Item[] items;
    private OnItemClickListener listener;

    public ItemsAdapter(Item[] items, OnItemClickListener listener) {
        this.items = items;
        this.listener = listener;
    }

    @Override
    public int getItemCount() {
        return items.length;
    }

    @NonNull
    @Override
    public ItemsAdapter.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new ItemViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ItemsAdapter.ItemViewHolder holder, int position) {
        holder.bind(items[position], listener);
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

        public void bind(Item item, OnItemClickListener listener) {
            itemTitle.setText(item.name);
            itemDescription.setText(item.description);
            itemImage.setImageResource(item.image);

            rootLayout.setOnClickListener(v -> {listener.onItemClick(item);});
        }
    }

}
