package com.example.sfilizzola.starwarslist.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sfilizzola.starwarslist.R;

/**
 * Created by sfilizzola on 16/06/17.
 */

public class CharViewHolder extends RecyclerView.ViewHolder{

    public ImageView charPhoto;
    public TextView charName;
    public TextView charBirth;
    public TextView charGender;

    public CharViewHolder(View itemView) {
        super(itemView);
        this.charPhoto = (ImageView) itemView.findViewById(R.id.img_portrait);
        this.charName = (TextView) itemView.findViewById(R.id.name_item);
        this.charBirth = (TextView) itemView.findViewById(R.id.birthday_item);
        this.charGender = (TextView) itemView.findViewById(R.id.gender_item);
    }
}
