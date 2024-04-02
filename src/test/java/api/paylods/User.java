package api.paylods;

public class User {
	
	int id;
	String username;
	String firstName;
	String lastName;
	String email;
	String  password;
	String  phone;
	String userStatus;

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getusername() {
		return username;
	}
	public void setusername(String ingusername) {
		this.username = ingusername;
	}
	public String getgfirstName() {
		return firstName;
	}
	public void setfirstName(String ingfirstName) {
		this.firstName = ingfirstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}




}
