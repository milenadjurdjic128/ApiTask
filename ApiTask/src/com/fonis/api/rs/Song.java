package com.fonis.api.rs;

public class Song {

	private String name;
	private String author;
	private double duration;
	
	public Song(String name, String author, double duration) {
		this.name = name;
		this.author = author;
		this.duration = duration;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public double getDuration() {
		return duration;
	}
	
	public void setDuration(double duration) {
		this.duration = duration;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Song) {
			Song p = (Song) o;
			
			if(name.equals(p.getName()) && author.equals(p.getAuthor())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return "Name of the song is " + name + ", author is " + author + ", and duration of the song is "
				+ duration;
	}
	
	
}
