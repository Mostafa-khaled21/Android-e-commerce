package com.example.e_com.Retrofit;

import java.util.List;
import com.example.e_com.Data.RemoteData.ProductModel;
import com.example.e_com.Data.RemoteData.Users;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MyAPI {
//   String BASE_URL="https://fakestoreapi.com/";
String BASE_URL="https://dummyjson.com/";

    @GET("products")
    Call<ProductModel> getProducts();
    @GET("users")
    Call<Users> getusers();


}
