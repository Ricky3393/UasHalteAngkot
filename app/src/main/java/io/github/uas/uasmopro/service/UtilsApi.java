package io.github.uas.uasmopro.service;

public class UtilsApi {

    public static final String BASE_URL_API = "http://halteangkotbandung.000webhostapp.com/";

    // Mendeklarasikan Interface BaseApiService
    public static EndPoints getAPIService(){
        return RetrofitClient.getClient(BASE_URL_API).create(EndPoints.class);
    }

}