package com.romain.mathieu.spreadscience.Model.API;


import com.google.gson.annotations.SerializedName;


public class RepliesItemItem{

	@SerializedName("author_name")
	private String authorName;

	@SerializedName("date")
	private String date;

	@SerializedName("parent")
	private int parent;

	@SerializedName("author_url")
	private String authorUrl;

	@SerializedName("author_avatar_urls")
	private AuthorAvatarUrls authorAvatarUrls;

	@SerializedName("_links")
	private Links links;

	@SerializedName("author")
	private int author;

	@SerializedName("link")
	private String link;

	@SerializedName("id")
	private int id;

	@SerializedName("type")
	private String type;

	@SerializedName("content")
	private Content content;

	public String getAuthorName(){
		return authorName;
	}

	public String getDate(){
		return date;
	}

	public int getParent(){
		return parent;
	}

	public String getAuthorUrl(){
		return authorUrl;
	}

	public AuthorAvatarUrls getAuthorAvatarUrls(){
		return authorAvatarUrls;
	}

	public Links getLinks(){
		return links;
	}

	public int getAuthor(){
		return author;
	}

	public String getLink(){
		return link;
	}

	public int getId(){
		return id;
	}

	public String getType(){
		return type;
	}

	public Content getContent(){
		return content;
	}

	@Override
 	public String toString(){
		return 
			"RepliesItemItem{" + 
			"author_name = '" + authorName + '\'' + 
			",date = '" + date + '\'' + 
			",parent = '" + parent + '\'' + 
			",author_url = '" + authorUrl + '\'' + 
			",author_avatar_urls = '" + authorAvatarUrls + '\'' + 
			",_links = '" + links + '\'' + 
			",author = '" + author + '\'' + 
			",link = '" + link + '\'' + 
			",id = '" + id + '\'' + 
			",type = '" + type + '\'' + 
			",content = '" + content + '\'' + 
			"}";
		}
}