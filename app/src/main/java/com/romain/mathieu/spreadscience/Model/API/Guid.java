package com.romain.mathieu.spreadscience.Model.API;


import com.google.gson.annotations.SerializedName;


public class Guid{

	@SerializedName("rendered")
	private String rendered;

	public String getRendered(){
		return rendered;
	}

	@Override
 	public String toString(){
		return 
			"Guid{" + 
			"rendered = '" + rendered + '\'' + 
			"}";
		}
}