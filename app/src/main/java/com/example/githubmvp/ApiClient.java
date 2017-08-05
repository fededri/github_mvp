package com.example.githubmvp;

/**
 * Created by Federico Torres on 26/6/2017.
 */

import android.util.Log;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;


/**
 * Created by Federico Torres on 18/11/2016.
 */

public class ApiClient {


    private static final String API_URL = "https://api.github.com/search/";
    private static githubInterface mInterface;
    private static Retrofit restAdapter;

    public static githubInterface getServiceClient() {

        if (mInterface == null) {
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
                @Override
                public void log(String message) {
                    Log.i("ApiClient", message);
                }
            });


            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
            httpClientBuilder.writeTimeout(30, TimeUnit.SECONDS);
            httpClientBuilder.readTimeout(30, TimeUnit.SECONDS);
            httpClientBuilder.connectTimeout(30, TimeUnit.SECONDS);

            httpClientBuilder.addInterceptor(loggingInterceptor);

            restAdapter = new Retrofit.Builder()
                    .baseUrl(API_URL)
                    .addConverterFactory(buildGsonConverter())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(httpClientBuilder.build())
                    .build();


            mInterface = restAdapter.create(githubInterface.class);
        }

        return mInterface;
    }




    private static GsonConverterFactory buildGsonConverter() {

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setLenient();
        Gson myGson = gsonBuilder.create();

        return GsonConverterFactory.create(myGson);
    }

    public interface githubInterface {



    }
}

