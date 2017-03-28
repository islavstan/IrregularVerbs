package com.islavstan.irregularverbs;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.islavstan.irregularverbs.adapter.WordsRecyclerAdapter;
import com.islavstan.irregularverbs.model.Words;
import com.islavstan.irregularverbs.model.WordsList;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    WordsRecyclerAdapter adapter;
    RecyclerView recyclerView;
    LinearLayoutManager mLayoutManager;
    List<Words> wordsList = new ArrayList<>();
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        adapter = new WordsRecyclerAdapter(wordsList);
        mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        mDatabase = FirebaseDatabase.getInstance().getReference().child("words");

        ValueEventListener listener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot templateSnapshot : dataSnapshot.getChildren()){
                    Words words = templateSnapshot.getValue(Words.class);
                    Log.d("stas", words.toString());
                    wordsList.add(words);

                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };

        mDatabase.addValueEventListener(listener);

       /* TextView nameTV = (TextView)findViewById(R.id.name);
        TextView emailTV = (TextView)findViewById(R.id.email);
        ImageView image = (ImageView)findViewById(R.id.photo);


        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            String name = user.getDisplayName();
            String email = user.getEmail();
            Uri photoUrl = user.getPhotoUrl();
            nameTV.setText(name);
            emailTV.setText(email);
            Picasso.with(this).load(photoUrl).into(image);

        }*/


    }
}
