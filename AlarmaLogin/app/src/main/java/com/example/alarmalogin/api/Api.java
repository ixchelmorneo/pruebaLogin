package com.example.alarmalogin.api;

import com.example.alarmalogin.models.DefaultResponse;
import com.example.alarmalogin.models.LoginResponse;
import com.example.alarmalogin.models.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface Api {

    /*@FormUrlEncoded
    @POST("signin/")
    Call<LoginResponse> userLogin(
            @Field("email") String email,
            @Field("password") String password
    );*/


    String API_ROUTER = "api/auth/signin";
    @Headers({

            "Content-type: application/json"

    })

    @POST(API_ROUTER)
    Call<LoginResponse> userLogin (@Body LoginResponse signin);

}
