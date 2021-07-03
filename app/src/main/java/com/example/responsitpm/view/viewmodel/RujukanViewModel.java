package com.example.responsitpm.view.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.responsitpm.model.rujukan.RujukanDataItem;
import com.example.responsitpm.model.rujukan.RujukanResponse;
import com.example.responsitpm.service.ApiMain;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RujukanViewModel extends ViewModel {

    private ApiMain apiMain;
    private MutableLiveData<ArrayList<RujukanDataItem>> listRujukan = new MutableLiveData<>();

    public void setRujukan() {
        if (this.apiMain == null) {
            apiMain = new ApiMain();
        }

        apiMain.getApiRujukan().getRujukan().enqueue(new Callback<RujukanResponse>() {
            @Override
            public void onResponse(Call<RujukanResponse> call, Response<RujukanResponse> response) {
                RujukanResponse responseRujukan = response.body();
                if (responseRujukan != null && responseRujukan.getData() != null ) {
                    ArrayList<RujukanDataItem> rujukanItems = (ArrayList<RujukanDataItem>) responseRujukan.getData();
                    listRujukan.postValue(rujukanItems);
                }
            }

            @Override
            public void onFailure(Call<RujukanResponse> call, Throwable t) {

            }
        });
    }

    public LiveData<ArrayList<RujukanDataItem>> getRujukan() {
        return listRujukan;
    }
}
