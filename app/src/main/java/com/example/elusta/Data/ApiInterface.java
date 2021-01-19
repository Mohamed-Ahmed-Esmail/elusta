package com.example.elusta.Data;

import com.example.elusta.Model.LoginPojoModel;
import com.example.elusta.Model.ServicesPojoModel;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {

    @POST("api/users/Login")
    @FormUrlEncoded
    Observable<LoginPojoModel> loginUser(@Query("type") int type,
                                         @Field("username") String name,
                                         @Field("password") String pass,
                                         @Field("grant_type") String gType);


    @GET("api/Services/GETAllServices")
    Observable<ServicesPojoModel>Services(@Query("lang")String lang);

}
