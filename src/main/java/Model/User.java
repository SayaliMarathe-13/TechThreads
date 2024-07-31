package Model;


import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;
@Entity
@Component
public class User {
private String name;
@Id
private String contact;
private String email;
private String password;
public User() {
		super();
		// TODO Auto-generated constructor stub
	}
@Override
	public String toString() {
		return "User [name=" + name + ", contact=" + contact + ", email=" + email + ", password=" + password + "]";
	}
public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
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



}
