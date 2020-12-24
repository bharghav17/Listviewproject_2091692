package com.example.Listviewproject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Listviewinterface {

    @GET("repositories")
    Call<List<Listview>> getRepoList();
}
