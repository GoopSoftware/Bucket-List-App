package com.dzl.listapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;

public class ItemsActivity extends AppCompatActivity {

    private static final int ADD_ITEM_REQUEST = 2;


    private ArrayList<Item> items;
    private ItemsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);


        RecyclerView list = findViewById(R.id.recycler_view_list);

        setupList();


        adapter = new ItemsAdapter(items, new ItemsAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Item item, int position) {
                Intent intent = new Intent(ItemsActivity.this, DetailActivity.class);
                intent.putExtra("title", item.name);
                intent.putExtra("description", item.description);
                intent.putExtra("image", item.image);
                intent.putExtra("position", position);
                startActivityForResult(intent, 1);
            }
        });

        list.setAdapter(adapter);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == RESULT_OK) {
            int position = data.getIntExtra("position", -1);
            if (position != -1) {
                items.remove(position);
                adapter.notifyItemRemoved(position);

            }
        }

        if (requestCode == ADD_ITEM_REQUEST) {
            String title = data.getStringExtra("title");
            String description = data.getStringExtra("description");

            if (title != null && description != null) {
                Item newItem = new Item(title, description, R.drawable.bucket);
                items.add(newItem);
                adapter.notifyItemInserted(items.size() - 1);
            }
        }
    }

    private void setupList() {

        items = new ArrayList<>(Arrays.asList(
                new Item("High-Five a Dolphin", "Find a dolphin in the wild and casually give it a high-five.", R.drawable.bucket),
                new Item("Zoom CEO Prank", "Join a random Zoom meeting and pretend you're the new CEO.", R.drawable.bucket),
                new Item("Reverse Marathon", "Train to run a full marathon backward. Bonus points for moonwalking.", R.drawable.bucket),
                new Item("Mail a Potato", "Send a raw potato to a random address. No explanation. No return address.", R.drawable.bucket),
                new Item("Squirrel Accountant", "Train a squirrel to do basic accounting. Consider starting a business.", R.drawable.bucket),
                new Item("Emoji Declaration", "Translate the entire Declaration of Independence into emojis.", R.drawable.bucket),
                new Item("Unicycle Drive-Thru", "Order food from a drive-thru while riding a unicycle.", R.drawable.bucket),
                new Item("Paint Dry Documentary", "Watch a full 8-hour documentary on paint drying and review it on YouTube.", R.drawable.bucket),
                new Item("Whisper Podcast", "Create a podcast where you only whisper and speak in riddles.", R.drawable.bucket),
                new Item("Banana Gala", "Crash a black-tie event in a full banana costume. Act like it’s normal.", R.drawable.bucket),
                new Item("Library Enthusiast", "Get banned from a library for being too excited about the Dewey Decimal System.", R.drawable.bucket),
                new Item("Gnome Conspiracy", "Write a book exposing the global garden gnome conspiracy.", R.drawable.bucket),
                new Item("Time Traveler Prank", "Convince a stranger you’re from the 1800s. Speak only in ye olde English.", R.drawable.bucket),
                new Item("Pirate Yoga", "Lead a yoga class using only pirate slang. 'Downward peg-leg, me hearties!'", R.drawable.bucket),
                new Item("TV Sitcom Day", "Live one full day as if you're in a 90s sitcom. Add your own laugh track.", R.drawable.bucket),
                new Item("Mascot Cult", "Form a spiritual movement around breakfast cereal mascots.", R.drawable.bucket),
                new Item("Random Job Interview", "Apply for a job you have zero qualifications for, just to see what happens.", R.drawable.bucket),
                new Item("Mystery Press Conference", "Hold a press conference for an event that never happened.", R.drawable.bucket),
                new Item("Fake Language Fluency", "Become fluent in a language that doesn’t exist. Use it in serious situations.", R.drawable.bucket)
        ));



    }

}