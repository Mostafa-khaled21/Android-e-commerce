package com.example.e_com.ViewModel;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.e_com.Data.RemoteData.ProductModel;
import com.example.e_com.Retrofit.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class viewMo extends ViewModel {
    private MutableLiveData<ProductModel> prodList;

    Context context;
    public LiveData<ProductModel> getProduct(){
        Log.d("Answer","getProduct1");

        if(prodList == null ){
            prodList =new MutableLiveData<ProductModel>();
            Log.d("Answer","getProduct2");

            loadProd();
            Log.d("Answer","getProduct3");

        }
        return prodList;

    }

    private void loadProd() {
        Call<ProductModel> call = RetrofitClient.getInstance().getMyAPI().getProducts();
        call.enqueue(new Callback<ProductModel>() {
            @Override
            public void onResponse(Call<ProductModel> call, Response<ProductModel> response) {
                if (!response.isSuccessful()){
                    Log.d("Answer","ON nSUC");

                }
                Log.d("Answer","ON Res");
                prodList.setValue(response.body());
                Log.d("Answer",response.toString());

            }

            @Override
            public void onFailure(Call<ProductModel> call, Throwable t) {
                Log.d("Answer",t.getMessage());
                //     Toast.makeText(context, " error : "+t.getMessage(), Toast.LENGTH_LONG).show();


            }
        });
    }
}
