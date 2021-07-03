package com.example.responsitpm.service;

import com.example.responsitpm.model.rujukan.RujukanResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RujukanRepository {
    @GET("sebaran_v2/jabar/faskes")
    Call<RujukanResponse> getRujukan();
}
