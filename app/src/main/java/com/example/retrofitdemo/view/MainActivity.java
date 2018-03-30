package com.example.retrofitdemo.view;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.retrofitdemo.R;
import com.example.retrofitdemo.adapter.ContactAdapter;
import com.example.retrofitdemo.databinding.ActivityMainBinding;
import com.example.retrofitdemo.model.Responses;
import com.example.retrofitdemo.presenter.ContactPresenter;

import java.util.List;

public class MainActivity extends AppCompatActivity implements ContactView{
    ActivityMainBinding activityMainBinding;
    private ContactPresenter mContactPresenter;
    ContactAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        activityMainBinding= DataBindingUtil.setContentView(this, R.layout.activity_main);

        mContactPresenter=new ContactPresenter(MainActivity.this);

        activityMainBinding.click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            mContactPresenter.getContacts(MainActivity.this);
            }
        });
    }

    @Override
    public void contactnames(List<Responses.ContactsBean> getcontacts) {
        for (int i = 0; i < getcontacts.size(); i++) {
       //     Toast.makeText(this, getcontacts.get(i).getName(), Toast.LENGTH_LONG).show();
        }
        adapter = new ContactAdapter(this, getcontacts);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this);
        activityMainBinding.rectext.setLayoutManager(layoutManager);
        activityMainBinding.rectext.setAdapter(adapter);
       // recyclerView.setLayoutManager(layoutManager );
        //recyclerView.setAdapter(adapter);

    }
}
