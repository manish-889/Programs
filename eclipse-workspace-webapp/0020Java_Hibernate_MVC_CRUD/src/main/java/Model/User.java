package Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String uname;
	String email;
	String phone;
	String gender;
	String country;
	String lanuguage;
	String image;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getLanuguage() {
		return lanuguage;
	}
	public void setLanuguage(String lanuguage) {
		this.lanuguage = lanuguage;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User(String uname, String email, String phone, String gender, String country, String lanuguage,
			String image) {
		super();
		this.uname = uname;
		this.email = email;
		this.phone = phone;
		this.gender = gender;
		this.country = country;
		this.lanuguage = lanuguage;
		this.image = image;
	}
	
	
}
