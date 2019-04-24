package com.example.javabridgemonitoring.network;

import com.example.javabridgemonitoring.model.Sistem;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.Call;

public interface GetDataService {
    @GET("/sistem")
    Call<List<Sistem>> getAllSistem();
}
