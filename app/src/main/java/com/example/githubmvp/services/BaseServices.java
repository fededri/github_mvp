package com.example.githubmvp.services;


import android.support.annotation.NonNull;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public abstract class BaseServices {
    protected  Retrofit sRestAdapter;


    protected  String  API_URL = "https://api.github.com";



    public  <S> S createService(Class<S> serviceClass) {
         HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient.Builder client = new OkHttpClient.Builder()
                    .addInterceptor(interceptor);
            sRestAdapter = new Retrofit.Builder()
                    .baseUrl(API_URL)
                    .client(client.build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
            return sRestAdapter.create(serviceClass);
    }

    /**
     * or Error Handing when non-OK response is received from Server
     */
    @NonNull
    public  Retrofit retrofit() {
        return sRestAdapter;

    }

}
