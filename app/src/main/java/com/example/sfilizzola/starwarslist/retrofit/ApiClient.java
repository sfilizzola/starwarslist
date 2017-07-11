package com.example.sfilizzola.starwarslist.retrofit;

import com.google.gson.Gson;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by sfilizzola on 11/07/17.
 */

public class ApiClient {

    private static final String BASE_URL = "http://swapi.co/api/";

    private static SWapiService swapiService;

    public static SWapiService getServices(){
        if (swapiService == null){
            buildServices();
        }
        return swapiService;
    }


    private static void buildServices(){

        swapiService = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(SWapiService.class);
    }
}
