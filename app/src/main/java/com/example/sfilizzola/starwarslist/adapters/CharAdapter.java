package com.example.sfilizzola.starwarslist.adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sfilizzola.starwarslist.R;
import com.example.sfilizzola.starwarslist.model.Character;
import com.example.sfilizzola.starwarslist.viewholder.CharViewHolder;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by sfilizzola on 16/06/17.
 */

public class CharAdapter extends RecyclerView.Adapter<CharViewHolder> {

    List<Character> currentList;
    Context context;

    public CharAdapter(List<Character> currentList, Context context) {
        this.currentList = currentList;
        this.context = context;
    }

    @Override
    public CharViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row, null);

        return new CharViewHolder(v);
    }

    @Override
    public void onBindViewHolder(CharViewHolder holder, int position) {
        Character current = currentList.get(position);

        Picasso.with(context)
                .load(getResourceByPosition(position))
                .into(holder.charPhoto);

        holder.charName.setText(current.getName());
        holder.charBirth.setText(current.getBirth_year());
        holder.charGender.setText(current.getGender());
    }


    public int getResourceByPosition(int position){

        int resourceId;

        switch(position){

            case 0:
                resourceId = R.drawable.luke_skywalker;
                break;
            case 1:
                resourceId = R.drawable.c3po;
                break;
            case 2:
                resourceId = R.drawable.r2d2;
                break;
            case 3:
                resourceId = R.drawable.darth_vader;
                break;
            case 4:
                resourceId = R.drawable.leia_organa;
                break;
            case 5:
                resourceId = R.drawable.owen_lars;
                break;
            case 6:
                resourceId = R.drawable.beru_lars;
                break;
            case 7:
                resourceId = R.drawable.r5d4;
                break;
            case 8:
                resourceId = R.drawable.biggs;
                break;
            case 9:
                resourceId = R.drawable.obi_wan;
                break;
            default:
                resourceId = R.drawable.luke_skywalker;
                break;
        }

        return resourceId;

    }

    @Override
    public int getItemCount() {
        return currentList.size();
    }
}
