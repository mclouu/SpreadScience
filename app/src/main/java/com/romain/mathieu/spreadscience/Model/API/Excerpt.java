package com.romain.mathieu.spreadscience.Model.API;


import com.google.gson.annotations.SerializedName;


public class Excerpt{

	@SerializedName("rendered")
	private String rendered;

	@SerializedName("protected")
	private boolean jsonMemberProtected;

	public String getRendered(){
		return rendered;
	}

	public boolean isJsonMemberProtected(){
		return jsonMemberProtected;
	}

	@Override
 	public String toString(){
		return 
			"Excerpt{" + 
			"rendered = '" + rendered + '\'' + 
			",protected = '" + jsonMemberProtected + '\'' + 
			"}";
		}
}