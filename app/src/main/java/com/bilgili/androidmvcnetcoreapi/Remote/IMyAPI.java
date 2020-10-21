package com.bilgili.androidmvcnetcoreapi.Remote;

import com.bilgili.androidmvcnetcoreapi.Model.Ogrenci;
import com.bilgili.androidmvcnetcoreapi.Model.tblUser;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface IMyAPI {
    //http://localhost:50653/api/login
    //http://localhost:56100/Login/login
    @POST("api/register")
    Observable<String> registerUser(@Body tblUser user);

    @POST("login")
    Observable<String> loginUser(@Body Ogrenci ogrenci);
}
