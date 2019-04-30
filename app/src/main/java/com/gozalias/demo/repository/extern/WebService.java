package com.gozalias.demo.repository.extern;

import com.gozalias.demo.user.UserResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface WebService {

    @GET("/api/users/{user}")
    Call<UserResponse> getUser(@Path("user") String userId);
}
