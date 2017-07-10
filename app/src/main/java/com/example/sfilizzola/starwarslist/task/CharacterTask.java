package com.example.sfilizzola.starwarslist.task;

/**
 * Created by sfilizzola on 10/07/17.
 */

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.example.sfilizzola.starwarslist.model.JsonResult;
import com.google.gson.Gson;

import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;


public class CharacterTask extends AsyncTask<Void, Void, JsonResult> {

    private static final String TAG = CharacterTask.class.getSimpleName();

    public static final String ENDPOINT_ADDRESS = "http://swapi.co/api/people/";
    private Context mContext = null;
    private ProgressDialog mDialog = null;
    private CharacterTaskCallback mCallback = null;
    private JsonResult mContent = null;

    public interface CharacterTaskCallback {
        void onFinishWithSuccess(JsonResult content);
        void onFinishWithError();
    }

    /**
     * Constructor
     *
     * @param context of the application
     */
    public CharacterTask(Context context, CharacterTaskCallback callback) {
        mContext = context;
        mCallback = callback;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected JsonResult doInBackground(Void... args) {

        JsonResult result;
        URL url = null;
        HttpURLConnection connection = null;

        try{
            url = new URL(ENDPOINT_ADDRESS);
            connection = (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(60000); //about one min.
            Gson gson = new Gson();
            Reader reader = new InputStreamReader(connection.getInputStream());
            result = gson.fromJson(reader, JsonResult.class);

        } catch (Exception e){
            Log.e(TAG, e.getMessage());
            result = null;
        }

        return result;
    }

    @Override
    protected void onPostExecute(JsonResult result) {
        super.onPostExecute(result);

        if(mDialog != null) {
            mDialog.dismiss();
        }

        if(result != null) {
            mCallback.onFinishWithSuccess(result);
        } else {
            mCallback.onFinishWithError();
        }
    }
}
