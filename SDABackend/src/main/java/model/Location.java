package model;

public class Location {

	private int id;
	private int zip_code;
	private String city;
	private String state;
	private String neighborhood;
	private String number;
	private String reference;
	
	public Location(int id,int zip_code,String city,String state,String neighborhood,String number,String reference) {
		this.id=id;
		this.zip_code=zip_code;
		this.city=city;
		this.state=state;
		this.neighborhood=neighborhood;
		this.number=number;
		this.reference=reference;
	}
	
	
	
	@Override
	public String toString() {
		return "Location [id=" + id + ", zip_code=" + zip_code + ", city=" + city + ", state=" + state
				+ ", neighborhood=" + neighborhood + ", number=" + number + ", reference=" + reference + "]";
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getZip_code() {
		return zip_code;
	}
	public void setZip_code(int zip_code) {
		this.zip_code = zip_code;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getNeighborhood() {
		return neighborhood;
	}
	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	
	
}
