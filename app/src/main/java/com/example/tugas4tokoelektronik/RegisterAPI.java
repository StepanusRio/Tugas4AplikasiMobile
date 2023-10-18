package com.example.tugas4tokoelektronik;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RegisterAPI {
    @GET("index.php")
    Call<Value> get();
}
