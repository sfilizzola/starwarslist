package com.example.sfilizzola.starwarslist;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.sfilizzola.starwarslist.adapters.CharAdapter;
import com.example.sfilizzola.starwarslist.data.JsonFromFile;
import com.example.sfilizzola.starwarslist.model.Character;
import com.example.sfilizzola.starwarslist.model.JsonResult;

import java.util.List;

/**
 * Created by sfilizzola on 14/06/17.
 */

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        initList();
    }

    private void initList() {

        mRecyclerView = (RecyclerView) findViewById(R.id.list_characters);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));


        JsonResult result = JsonFromFile.getResult(this);

        if (result != null){
            List<Character> currentChars = result.getResults();

            CharAdapter adapter = new CharAdapter(currentChars, this);

            mRecyclerView.setAdapter(adapter);

        }

    }
}
