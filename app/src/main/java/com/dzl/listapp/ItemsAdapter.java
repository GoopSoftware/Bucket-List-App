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

    public ItemsAdapter(Item[] items) {
        this.items = items;
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
        holder.bind(items[position]);
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {

        ImageView itemImage;
        TextView itemTitle;
        TextView itemDescription;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            itemImage = itemView.findViewById(R.id.image_view_item_icon);
            itemTitle = itemView.findViewById(R.id.text_view_title);
            itemDescription = itemView.findViewById(R.id.text_view_description);
        }

        public void bind(Item item) {
            itemTitle.setText(item.name);
            itemDescription.setText(item.description);
            itemImage.setImageResource(item.image);
        }
    }

}
