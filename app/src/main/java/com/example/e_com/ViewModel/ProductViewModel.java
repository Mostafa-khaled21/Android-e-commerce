package com.example.e_com.ViewModel;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.e_com.Data.RemoteData.ProductModel;
import com.example.e_com.Retrofit.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductViewModel extends ViewModel {
   private MutableLiveData<ProductModel>prodlist;
   Context context;
   public LiveData<ProductModel> getProduct(){
       if (prodlist ==null){
           prodlist =new MutableLiveData<ProductModel>();

           loadProd();
       }
       return prodlist;
   }

    private void loadProd() {
       Call<ProductModel> call=RetrofitClient.getInstance().getMyAPI().getProducts();
       call.enqueue(new Callback<ProductModel>() {
           @Override
           public void onResponse(Call<ProductModel> call, Response<ProductModel> response) {
               if (!response.isSuccessful()){
                   Log.d("answer","res");

               }
               prodlist.setValue(response.body());
           }

           @Override
           public void onFailure(Call<ProductModel> call, Throwable t) {
               Log.d("answer","fail");

           }
       });
    }
}
