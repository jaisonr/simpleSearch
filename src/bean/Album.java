package bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Album {
	private String title;
	private String[] links;
	private List<String> songs = new ArrayList<String>();
	private Artist artist;
	private Map<String, String> musicians = new HashMap<String, String>();

	public Album() {
		// TODO Auto-generated constructor stub
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String[] getLinks() {
		return links;
	}

	public void setLinks(String[] links) {
		this.links = links;
	}

	public List<String> getSongs() {
		return songs;
	}

	public void setSongs(List<String> songs) {
		this.songs = songs;
	}

	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}

	public Map<String, String> getMusicians() {
		return musicians;
	}

	public void setMusicians(Map<String, String> musicians) {
		this.musicians = musicians;
	}

	public static class Artist {
		private String name;
		private Date dateOfBirth;

		public Artist() {
			// TODO Auto-generated constructor stub
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Date getDateOfBirth() {
			return dateOfBirth;
		}

		public void setDateOfBirth(Date dateOfBirth) {
				this.dateOfBirth = dateOfBirth;
		}
	}

}
