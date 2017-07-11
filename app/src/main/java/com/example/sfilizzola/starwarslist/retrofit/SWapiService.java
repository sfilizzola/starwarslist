package com.example.sfilizzola.starwarslist.retrofit;

import com.example.sfilizzola.starwarslist.model.JsonResult;

import retrofit2.Call;
import retrofit2.http.GET;


/**
 * Created by sfilizzola on 11/07/17.
 */

public interface SWapiService {

    @GET("people/")
    Call<JsonResult> characters();

}
