package com.example.githubmvp.services;




import java.io.IOException;
import java.lang.annotation.Annotation;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Response;

/**
 * Created by Franco on 02/08/2017.
 */

public class ErrorUtils {
   /* public static MessageResponse parseError(Response<?> response) {
        Converter<ResponseBody, MessageResponse> converter =
                BaseServices.retrofit()
                        .responseBodyConverter(MessageResponse.class, new Annotation[0]);
        MessageResponse error;
        try {
            error = converter.convert(response.errorBody());
        } catch (IOException e) {
            return new MessageResponse(ErrorCodes.INTERNET_ERROR,"");
        }
        return error;
    }*/

    public interface ErrorCodes {
        String PAGE_ERROR = "PAGE_ERROR";
        String INTERNET_ERROR = "ERROR_CONNECTION_INTERNET";
    }

}
