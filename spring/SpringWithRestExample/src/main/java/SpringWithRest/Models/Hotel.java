package SpringWithRest.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Hotel {

	@JsonProperty(value="id")
	private int    id;

	@JsonProperty(value="name")
	private String name;


	@JsonProperty(value="address")
	private String address;

	// Ctor
	
	public Hotel() {
		
	}
	
	public Hotel(int id, String name, String address) {
		this.id = id;
		this.name = name;
		this.address = address;
	}
	
	// Access Methods
	
	public void changeName(String name) {
		this.name = name;
	}
	
	public void changeAddress(String address) {
		this.address = address;
	}
	
	public int id() {
		return (this.id);
	}
	
	public String name() {
		return (this.name);
	}
	
	public String address() {
		return (this.address);
	}
}
