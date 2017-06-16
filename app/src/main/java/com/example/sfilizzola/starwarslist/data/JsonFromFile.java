package com.example.sfilizzola.starwarslist.data;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import com.example.sfilizzola.starwarslist.model.JsonResult;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * Created by sfilizzola on 14/06/17.
 */

public class JsonFromFile {

    private static Context context;

    public JsonFromFile(Context context) {
        this.context = context;
    }

    public static JsonResult getResult(Context currentContext){
        try {
            context = currentContext;
            InputStream in = context.getAssets().open("swapi_people_sample.json");
            Gson gson = new Gson();
            Reader reader = new InputStreamReader(in);
            JsonResult result = gson.fromJson(reader, JsonResult.class);
            return result;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
