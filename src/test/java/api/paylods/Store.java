package api.paylods;
public class Store {

	int id;
	int petId;
	int quantity;
	int shipDate;
	String statuString;
	boolean completed;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPetId() {
		return petId;
	}
	public void setPetId(int petId) {
		this.petId = petId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getShipDate() {
		return shipDate;
	}
	public void setShipDate(int shipDate) {
		this.shipDate = shipDate;
	}
	public String getStatus() {
		return statuString;
	}
	public void setStatuString(String statuString) {
		this.statuString = statuString;
	}
	public boolean isCompleted() {
		return completed;
	}
	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
	
	
	
	
}
