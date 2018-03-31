package com.romain.mathieu.spreadscience.Model.API;


import com.google.gson.annotations.SerializedName;


public class Sizes{

	@SerializedName("thumbnail")
	private Thumbnail thumbnail;

	@SerializedName("medium")
	private Medium medium;

	@SerializedName("medium_large")
	private MediumLarge mediumLarge;

	@SerializedName("full")
	private Full full;

	public Thumbnail getThumbnail(){
		return thumbnail;
	}

	public Medium getMedium(){
		return medium;
	}

	public MediumLarge getMediumLarge(){
		return mediumLarge;
	}

	public Full getFull(){
		return full;
	}

	@Override
 	public String toString(){
		return 
			"Sizes{" + 
			"thumbnail = '" + thumbnail + '\'' + 
			",medium = '" + medium + '\'' + 
			",medium_large = '" + mediumLarge + '\'' + 
			",full = '" + full + '\'' + 
			"}";
		}
}