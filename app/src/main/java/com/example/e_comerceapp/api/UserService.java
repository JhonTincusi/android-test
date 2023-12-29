package com.example.e_comerceapp.api;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserService {

    @POST("api/authentication/")
    Call<LoginResponse> userLogin(@Body LoginRequest loginRequest);

}