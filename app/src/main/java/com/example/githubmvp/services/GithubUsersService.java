package com.example.githubmvp.services;

import com.example.githubmvp.services.response.SearchUsersResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Federico Torres on 4/8/17.
 */

public class GithubUsersService extends BaseServices {


    private  ApiClientInterface mApiClient;




    public  ApiClientInterface getServiceClient(){
        if(mApiClient == null){
            mApiClient = createService(ApiClientInterface.class);
        }

        return mApiClient;
    }


    public interface ApiClientInterface{


        @GET("search/users")
        Observable<SearchUsersResponse> searchUsers(@Query("q") String query);

    }

}
