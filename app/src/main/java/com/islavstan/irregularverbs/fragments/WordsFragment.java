package com.islavstan.irregularverbs.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.islavstan.irregularverbs.R;
import com.islavstan.irregularverbs.adapter.WordsRecyclerAdapter;
import com.islavstan.irregularverbs.model.Words;

import java.util.ArrayList;
import java.util.List;


public class WordsFragment extends Fragment {
    WordsRecyclerAdapter adapter;
    RecyclerView recyclerView;
    LinearLayoutManager mLayoutManager;
    List<Words> wordsList = new ArrayList<>();
    private DatabaseReference mDatabase;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_words, container, false);

        recyclerView = (RecyclerView) v.findViewById(R.id.recycler);
        adapter = new WordsRecyclerAdapter(wordsList);
        mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        mDatabase = FirebaseDatabase.getInstance().getReference().child("words");
        ValueEventListener listener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot templateSnapshot : dataSnapshot.getChildren()) {
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
        return v;
    }
}
