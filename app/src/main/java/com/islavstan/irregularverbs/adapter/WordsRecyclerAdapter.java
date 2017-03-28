package com.islavstan.irregularverbs.adapter;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.islavstan.irregularverbs.R;
import com.islavstan.irregularverbs.model.Words;

import java.util.List;

public class WordsRecyclerAdapter extends RecyclerView.Adapter<WordsRecyclerAdapter.CustomViewHolder> {
    private List<Words> wordsList;


    public WordsRecyclerAdapter(List<Words> wordsList) {
        this.wordsList = wordsList;

    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_words, parent, false);

        return new WordsRecyclerAdapter.CustomViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        Words words = wordsList.get(position);
        holder.infinitive.setText(words.getInfinitive());
        holder.pastSimple.setText(words.getPastSimple());
        holder.pastParticiple.setText(words.getPastParticiple());
        holder.translate.setText(words.getTranslate());
    }

    @Override
    public int getItemCount() {
        return wordsList.size();
    }


    class CustomViewHolder extends RecyclerView.ViewHolder {
        TextView infinitive;
        TextView pastSimple;
        TextView pastParticiple;
        TextView translate;

        public CustomViewHolder(View itemView) {
            super(itemView);

            infinitive = (TextView) itemView.findViewById(R.id.infinitive);
            pastSimple = (TextView) itemView.findViewById(R.id.pastSimple);
            pastParticiple = (TextView) itemView.findViewById(R.id.pastParticiple);
            translate = (TextView) itemView.findViewById(R.id.translate);


        }

    }
}
