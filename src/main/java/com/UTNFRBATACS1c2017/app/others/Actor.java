/**
 * 
 */
package com.UTNFRBATACS1c2017.app.others;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.UTNFRBATACS1c2017.app.helpers.Conector;

/**
 * @author facundo91
 *
 */
public class Actor {
	private int id;
	private String name;
	private List<Image> profiles = new ArrayList<Image>();
	private List<Credit> credits = new ArrayList<Credit>();

	public Actor(String id) throws JSONException, IOException {
		Conector conector = new Conector();
		JSONObject actorJson = conector.getResource2("person", id);
		this.setId(actorJson.getInt("id"));
		this.setName(actorJson.getString("name"));
		this.setImages(id,conector);
		this.setCredits(id,conector);
	}
	
	public Actor() {
		// TODO Auto-generated constructor stub
	}

	private void setImages(String id, Conector conector) throws JSONException, IOException {
		JSONArray imagesJson = conector.getResource2("person",id+"/images").getJSONArray("profiles");
        for(int i=0; i<imagesJson.length() ; i++){
        	this.addProfile(new Image(imagesJson.getJSONObject(i),this));
       }
	}

	private void setCredits(String id, Conector conector) throws JSONException, IOException {
		JSONArray creditsJson = conector.getResource2("person",id+"/movie_credits").getJSONArray("cast");
        for(int i=0; i<creditsJson.length() ; i++){
        	this.addCredit(new Credit(creditsJson.getJSONObject(i),this));
       }
	}

	public void addCredit(Credit credit) {
		this.getCredits().add(credit);
	}

	private void addProfile(Image image) {
		this.getProfiles().add(image);
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	private void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	private void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the profiles
	 */
	public List<Image> getProfiles() {
		return profiles;
	}

	/**
	 * @param profiles the profiles to set
	 */
	private void setProfiles(List<Image> profiles) {
		this.profiles = profiles;
	}

	/**
	 * @return the credits
	 */
	public List<Credit> getCredits() {
		return credits;
	}

	/**
	 * @param credits the credits to set
	 */
	private void setCredits(List<Credit> credits) {
		this.credits = credits;
	}

	public void showDetails() {
		// TODO Auto-generated method stub

	}
}
