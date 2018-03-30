package com.example.retrofitdemo.presenter;

import android.content.Context;
import android.widget.Toast;

import com.example.retrofitdemo.model.Responses;
import com.example.retrofitdemo.retrofit.RetrofitApi;
import com.example.retrofitdemo.retrofit.RetrofitApiBuilder;
import com.example.retrofitdemo.view.ContactView;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by user on 3/20/2018.
 */

public class ContactPresenter {
    @Inject
    RetrofitApi retrofitApi;
   private ContactView contactView;

    public ContactPresenter(ContactView contactView) {
        this.contactView = contactView;
    }
    public void getContacts(final Context context)
    {

        Call<Responses> responsesCall=retrofitApi.contacts("");
        responsesCall.enqueue(new Callback<Responses>() {
            @Override
            public void onResponse(Call<Responses> call, Response<Responses> response) {
                if(response.body()!=null) {
                    List<Responses.ContactsBean> getcontacts = response.body().getContacts();
                    contactView.contactnames(getcontacts);
                }
            }

            @Override
            public void onFailure(Call<Responses> call, Throwable t) {
                Toast.makeText(context,"Error",Toast.LENGTH_LONG).show();
            }
        });

    }
}
