package com.romain.mathieu.spreadscience.Model.API;

import java.util.List;

import com.google.gson.annotations.SerializedName;


public class Embedded{

	@SerializedName("replies")
	private List<List<RepliesItemItem>> replies;

	@SerializedName("author")
	private List<AuthorItem> author;

	@SerializedName("wp:term")
	private List<List<WpTermItemItem>> wpTerm;

	@SerializedName("wp:featuredmedia")
	private List<WpFeaturedmediaItem> wpFeaturedmedia;

	public List<List<RepliesItemItem>> getReplies(){
		return replies;
	}

	public List<AuthorItem> getAuthor(){
		return author;
	}

	public List<List<WpTermItemItem>> getWpTerm(){
		return wpTerm;
	}

	public List<WpFeaturedmediaItem> getWpFeaturedmedia(){
		return wpFeaturedmedia;
	}

	@Override
 	public String toString(){
		return 
			"Embedded{" + 
			"replies = '" + replies + '\'' + 
			",author = '" + author + '\'' + 
			",wp:term = '" + wpTerm + '\'' + 
			",wp:featuredmedia = '" + wpFeaturedmedia + '\'' + 
			"}";
		}
}