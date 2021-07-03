package com.example.responsitpm.service;

import com.example.responsitpm.model.covid.CovidResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CovidRepository {
    @GET("rekapitulasi_v2/jabar/harian")
    Call<CovidResponse> getCovid();

}
