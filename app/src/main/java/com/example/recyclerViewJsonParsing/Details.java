package com.example.recyclerViewJsonParsing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class Details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        StringBuilder stringBuilder = new StringBuilder();

        Intent intent = getIntent();
        String ImageUrl = intent.getStringExtra(MainActivity.EXTRA_URL);
        String creatorName = intent.getStringExtra(MainActivity.EXTRA_CREATOR);
        int likes = intent.getIntExtra(MainActivity.EXTRA_LIKES,0);

        ImageView imageView  = findViewById(R.id.CardViewImageId);
        TextView textViewCreatorName = findViewById(R.id.cardViewCreatorNameId);
        TextView textViewLikes = findViewById(R.id.cardViewLikesId);

        Picasso.with(this).load(ImageUrl).fit().centerInside().into(imageView);
        textViewCreatorName.setText(creatorName);
        textViewLikes.setText(stringBuilder.append("Likes: ").append(likes));
    }
}
