package com.example.retrofitdemo.view;

import com.example.retrofitdemo.model.Responses;

import java.util.List;

/**
 * Created by user on 3/20/2018.
 */

public interface ContactView {
    void  contactnames(List<Responses.ContactsBean> getcontacts);
}
