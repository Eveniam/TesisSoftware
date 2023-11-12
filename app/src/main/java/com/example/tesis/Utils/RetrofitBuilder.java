package com.example.tesis.Utils;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitBuilder {
    public static Retrofit build() {
        return new Retrofit.Builder()
                .baseUrl("https://655016347d203ab6626d8e41.mockapi.io/user/") // revisar
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
