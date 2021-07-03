package com.example.responsitpm.view.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.responsitpm.model.covid.CovidDataItem;
import com.example.responsitpm.model.covid.CovidResponse;
import com.example.responsitpm.service.ApiMain;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CovidViewModel extends ViewModel {
    private ApiMain apiMain;

    private MutableLiveData<ArrayList<CovidDataItem>> listCovid = new MutableLiveData<>();

    public void setCovid(){
        if (this.apiMain == null){
            apiMain = new ApiMain();
        }
        apiMain.getApiCovid().getCovid().enqueue(new Callback<CovidResponse>() {
            @Override
            public void onResponse(Call<CovidResponse> call, Response<CovidResponse> response) {
                CovidResponse responseCovid = response.body();
                if (responseCovid != null && responseCovid != null) {
                    ArrayList<CovidDataItem> covidItems = (ArrayList<CovidDataItem>) responseCovid.getData().getContent();
                    listCovid.postValue(covidItems);
                }
            }

            @Override
            public void onFailure(Call<CovidResponse> call, Throwable t) {

            }
        });
    }

    public LiveData<ArrayList<CovidDataItem>> getCovid() {

        return listCovid;
    }
}
