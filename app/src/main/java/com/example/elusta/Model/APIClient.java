package com.example.elusta.Model;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {

    private String TAG = "ApiClient";
    private String BaseUrl = "https://elusta.com/";
    private Retrofit retrofit;
    private OkHttpClient okHttpClient;
    private int REQUEST_TIMEOUT = 60;


    public APIClient() {
    }

    public Retrofit getClient(String token) {

        if (okHttpClient == null) {
            initOkHttp(token);
        }

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BaseUrl)
                    .client(okHttpClient)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    /**
     * OkHttp is a third-party library developed by Square for sending and receive HTTP-based network requests.
     * It is built on top of the Okio library, which tries to be more efficient about reading and writing data
     * than the standard Java I/O libraries by creating a shared memory pool.
     * It is also the underlying library for Retrofit library that provides type safety for consuming REST-based APIs.
     * We will use it to
     * 1- catch server errors
     * 2- add token in header globally
     * 3- Logging
     * Logging too much information will blow up your Android monitor,
     * that’s why OkHttp’s logging interceptor has four log levels: NONE, BASIC, HEADERS, BODY.
     * We’ll walk you through each of the log levels and describe their output.
     *
     * @param token
     */
    private void initOkHttp(final String token) {

        OkHttpClient.Builder httpClient = new OkHttpClient().newBuilder()
                // .addInterceptor(new ChuckInterceptor(mContext))
                .connectTimeout(REQUEST_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(REQUEST_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(REQUEST_TIMEOUT, TimeUnit.SECONDS)
                .retryOnConnectionFailure(false);

        // While developing your app and for debugging purposes it’s nice to have a log feature integrated
        // to show request and response information. Since logging isn’t integrated by default anymore in Retrofit 2,
        // we need to add a logging interceptor for OkHttp.
        // Luckily OkHttp already ships with this interceptor and you only need to activate it for your OkHttpClient.
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        httpClient.addInterceptor(loggingInterceptor);

        // Catch Server Errors Globally with Response Interceptor
        //httpClient.addInterceptor(new ErrorInterceptor(mContext));

        // this interceptor for adding Authorization in request header

        /*httpClient.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {

                Request original = chain.request();

                Request.Builder requestBuilder = original.newBuilder()
                        .addHeader("Accept", "application/json")
                        .addHeader("Content-Type", "application/json");

                // Adding Authorization token (API Key)
                // Requests will be denied without API key

                requestBuilder.addHeader("Authorization", token);

                return chain.proceed(requestBuilder.build());

            }
        });*/

        okHttpClient = httpClient.build();

    }

}




