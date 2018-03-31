package com.romain.mathieu.spreadscience.Model.API;


import com.google.gson.annotations.SerializedName;


public class VersionHistoryItem{

	@SerializedName("href")
	private String href;

	public String getHref(){
		return href;
	}

	@Override
 	public String toString(){
		return 
			"VersionHistoryItem{" + 
			"href = '" + href + '\'' + 
			"}";
		}
}