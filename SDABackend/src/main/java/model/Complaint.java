package model;

public class Complaint {
	
	private int id;
	private String offender;
	private String infringement;
	private String smuggledProduct;
	private String offenseDescription;
	private String _URLDocument; 
	private String imageURL; 
	
	
	public Complaint(int id,String offender,String infringement,String smuggledProduct,String offenseDescription,String URLDocument,String imageURL) {
		this.id=id;
		this.offender=offender;
		this.infringement=infringement;
		this.smuggledProduct=smuggledProduct;
		this.offenseDescription=offenseDescription;
		this.imageURL=imageURL;
	}
	
	@Override
	public String toString() {
		return "Location [id=" + id + ", offender=" + offender + ", infringement=" + infringement
				+ ", smuggled_Product=" + smuggledProduct + ", offense_Description=" + offenseDescription
				+ ", URL_Document=" + _URLDocument + ", image_URL=" + imageURL + "]";
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOffender() {
		return offender;
	}
	public void setOffender(String offender) {
		this.offender = offender;
	}
	public String getInfringement() {
		return infringement;
	}
	public void setInfringement(String infringement) {
		this.infringement = infringement;
	}
	public String getSmuggled_Product() {
		return smuggledProduct;
	}
	public void setSmuggled_Product(String smuggled_Product) {
		this.smuggledProduct = smuggled_Product;
	}
	public String getOffense_Description() {
		return offenseDescription;
	}
	public void setOffense_Description(String offense_Description) {
		this.offenseDescription = offense_Description;
	}
	public String getURL_Document() {
		return _URLDocument;
	}
	public void setURL_Document(String uRL_Document) {
		_URLDocument = uRL_Document;
	}
	public String getImage_URL() {
		return imageURL;
	}
	public void setImage_URL(String image_URL) {
		this.imageURL = image_URL;
	}
	
	
	
	
	
	
	

}
