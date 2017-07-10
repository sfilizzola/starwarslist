package com.example.sfilizzola.starwarslist;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.example.sfilizzola.starwarslist.adapters.CharAdapter;
import com.example.sfilizzola.starwarslist.model.Character;
import com.example.sfilizzola.starwarslist.model.JsonResult;
import com.example.sfilizzola.starwarslist.task.CharacterTask;

import java.util.List;

/**
 * Created by sfilizzola on 14/06/17.
 */

public class MainActivity extends AppCompatActivity implements CharacterTask.CharacterTaskCallback {

    private RecyclerView mRecyclerView;
    private ProgressBar mProgressBar;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        mRecyclerView = (RecyclerView) findViewById(R.id.list_characters);
        mProgressBar = (ProgressBar) findViewById(R.id.list_progress);

        startAsync();
    }

    private void startAsync() {
        showLoading(true);
        CharacterTask task = new CharacterTask(this, this);
        task.execute();
    }

    private void showLoading(boolean show) {
        mProgressBar.setVisibility(show ? View.VISIBLE : View.GONE);
        mRecyclerView.setVisibility(show ? View.GONE : View.VISIBLE);
    }

    private void initList(JsonResult result) {

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        if (result != null) {
            List<Character> currentChars = result.getResults();

            CharAdapter adapter = new CharAdapter(currentChars, this);

            mRecyclerView.setAdapter(adapter);

        }

    }

    @Override
    public void onFinishWithSuccess(JsonResult content) {
        showLoading(false);
        initList(content);
    }

    @Override
    public void onFinishWithError() {
        showLoading(false);
        Snackbar alert = Snackbar.make(findViewById(R.id.main_content), "Error from Network", Snackbar.LENGTH_INDEFINITE);

        alert.setAction("Retry", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAsync();
            }
        });
        alert.show();

    }
}
