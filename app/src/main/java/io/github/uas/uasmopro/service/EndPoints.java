package io.github.uas.uasmopro.service;

import io.github.uas.uasmopro.model.AngkotResponse;
import retrofit2.Call;
import retrofit2.http.GET;

public interface EndPoints {
    @GET("halte/")
    Call<AngkotResponse> getAllPertandingan();
}
