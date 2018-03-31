package com.romain.mathieu.spreadscience.Model.API;


import com.google.gson.annotations.SerializedName;


public class AuthorItem{

	@SerializedName("avatar_urls")
	private AvatarUrls avatarUrls;

	@SerializedName("_links")
	private Links links;

	@SerializedName("name")
	private String name;

	@SerializedName("link")
	private String link;

	@SerializedName("description")
	private String description;

	@SerializedName("id")
	private int id;

	@SerializedName("url")
	private String url;

	@SerializedName("slug")
	private String slug;

	public AvatarUrls getAvatarUrls(){
		return avatarUrls;
	}

	public Links getLinks(){
		return links;
	}

	public String getName(){
		return name;
	}

	public String getLink(){
		return link;
	}

	public String getDescription(){
		return description;
	}

	public int getId(){
		return id;
	}

	public String getUrl(){
		return url;
	}

	public String getSlug(){
		return slug;
	}

	@Override
 	public String toString(){
		return 
			"AuthorItem{" + 
			"avatar_urls = '" + avatarUrls + '\'' + 
			",_links = '" + links + '\'' + 
			",name = '" + name + '\'' + 
			",link = '" + link + '\'' + 
			",description = '" + description + '\'' + 
			",id = '" + id + '\'' + 
			",url = '" + url + '\'' + 
			",slug = '" + slug + '\'' + 
			"}";
		}
}