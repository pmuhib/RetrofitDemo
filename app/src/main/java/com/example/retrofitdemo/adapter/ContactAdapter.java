package com.example.retrofitdemo.adapter;

import android.content.ClipData;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.retrofitdemo.R;
import com.example.retrofitdemo.databinding.ContactrowBinding;
import com.example.retrofitdemo.model.Responses;
import java.util.List;

/**
 * Created by user on 3/20/2018.
 */

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder>{


    Context  context;
    List<Responses.ContactsBean> mcontactList;

    public ContactAdapter(Context context, List<Responses.ContactsBean> mcontactList) {
        this.context = context;
        this.mcontactList = mcontactList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ContactrowBinding contactRow=DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),R.layout.contactrow,parent,false);

      return new ViewHolder(contactRow);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mviewDataBinding.contactname.setText(mcontactList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return mcontactList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ContactrowBinding  mviewDataBinding;
        public ViewHolder(ContactrowBinding itemView) {
            super(itemView.getRoot());
            mviewDataBinding=itemView;
            mviewDataBinding.executePendingBindings();
        }

    }
}
