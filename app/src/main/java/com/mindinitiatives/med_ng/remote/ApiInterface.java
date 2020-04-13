package com.mindinitiatives.med_ng.remote;

import com.mindinitiatives.med_ng.data.model.States;
import com.mindinitiatives.med_ng.data.model.TotalCases;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("api/states")
    Call<List<States>> getStates(@Query("states") String states);

    @GET("api/confirmed")
    Call<List<TotalCases>> getTotal();


}
