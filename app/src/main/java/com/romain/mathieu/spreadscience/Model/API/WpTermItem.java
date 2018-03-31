package com.romain.mathieu.spreadscience.Model.API;


import com.google.gson.annotations.SerializedName;


public class WpTermItem{

	@SerializedName("taxonomy")
	private String taxonomy;

	@SerializedName("href")
	private String href;

	@SerializedName("embeddable")
	private boolean embeddable;

	public String getTaxonomy(){
		return taxonomy;
	}

	public String getHref(){
		return href;
	}

	public boolean isEmbeddable(){
		return embeddable;
	}

	@Override
 	public String toString(){
		return 
			"WpTermItem{" + 
			"taxonomy = '" + taxonomy + '\'' + 
			",href = '" + href + '\'' + 
			",embeddable = '" + embeddable + '\'' + 
			"}";
		}
}