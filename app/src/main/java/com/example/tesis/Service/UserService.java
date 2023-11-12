package com.example.tesis.Service;

import com.example.tesis.Entities.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface UserService {

    @GET("User")
    Call<List<User>> getAllUser(@Query("nombre") String name, @Query("limit") int limit, @Query("page") int page);

    @GET("User/{id}")
    Call<User> getUser(@Path("id") int id);

    @POST("User")
    Call<User> create(@Body User user);

    @PUT("User/{id}")
    Call<User> update(@Path("id") int id, @Body User user);

    @DELETE("User/{id}")
    Call<Void> delete(@Path("id") int id);
}
