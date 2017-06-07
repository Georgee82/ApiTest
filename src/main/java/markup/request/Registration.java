package markup.request;

public class Registration {
	
	public UserAddress getAddress() {
		return address;
	}

	public Registration(UserAddress formUserAddress){
		this.address = formUserAddress;
	}
	
	private String email;
	private String phone;
	private String pwd;
	private String birthDate;
	private String description;
	
	private UserAddress address;

	public void setEmail(String eMail) {
		this.email = eMail;
	}

	public void setPwd(String password) {
		this.pwd = password;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}

	public String getPwd() {
		return pwd;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public String getDescription() {
		return description;
	}
	
}
