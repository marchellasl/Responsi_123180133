package com.example.responsitpm.model.rujukan;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.SerializedName;

public class RujukanResponse{

	@SerializedName("status_code")
	private int statusCode;

	@SerializedName("data")
	private ArrayList<RujukanDataItem> data;

	public void setStatusCode(int statusCode){
		this.statusCode = statusCode;
	}

	public int getStatusCode(){
		return statusCode;
	}

	public void setData(ArrayList<RujukanDataItem> data){
		this.data = data;
	}

	public ArrayList<RujukanDataItem> getData(){
		return data;
	}
}