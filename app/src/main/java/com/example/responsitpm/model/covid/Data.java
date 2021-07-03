package com.example.responsitpm.model.covid;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Data{

	@SerializedName("metadata")
	private Metadata metadata;

	@SerializedName("content")
	private ArrayList<CovidDataItem> content;

	public Metadata getMetadata(){
		return metadata;
	}

	public List<CovidDataItem> getContent(){
		return content;
	}
}