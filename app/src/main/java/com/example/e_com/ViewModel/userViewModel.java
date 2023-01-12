package com.example.e_com.ViewModel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.e_com.Data.RemoteData.Users;
import com.example.e_com.Retrofit.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class userViewModel extends ViewModel {
    private MutableLiveData<Users> userlist;
    public  LiveData<Users> getUsers(){
        if (userlist == null){
            userlist =new MutableLiveData<Users>();
            loaduser();
        }
        return userlist;
    }

    private void loaduser() {
        Call<Users> call= RetrofitClient.getInstance().getMyAPI().getusers();
        call.enqueue(new Callback<Users>() {
            @Override
            public void onResponse(Call<Users> call, Response<Users> response) {
                if (!response.isSuccessful()){
                    Log.d("answer","res");

                }
                userlist.setValue(response.body());
                Log.d("answer","done");
            }

            @Override
            public void onFailure(Call<Users> call, Throwable t) {
                Log.d("answer","fail");
                Log.d("answer",""+t.getMessage());
            }
        });
    }
}
