package vn.iotstar.Entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Users")
@NamedQuery(name="Users.findAll", query="SELECT u FROM Users u")
public class Users implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="UserID")
	private int UserID;
	@Column(name="Username")
	private String Username;
	@Column(name="Password")
	private String Password;
	@Column(name="Phone")
	private String Phone;
	@Column(name="Fullname")
	private String Fullname;
	@Column(name="Email")
	private String Email;
	@Column(name="Admin")
	private boolean Admin;
	@Column(name="Active")
	private boolean Active;
	@Column(name="Images")
	private String Images;
	
	
	@OneToMany(mappedBy = "users", fetch = FetchType.EAGER)
	private List<Cart> cart;
	
	public Users() {
		super();
	}
	public Users(int userID, String username, String password, String phone, String fullname, String email,
			boolean admin, boolean active, String images) {
		super();
		UserID = userID;
		Username = username;
		Password = password;
		Phone = phone;
		Fullname = fullname;
		Email = email;
		Admin = admin;
		Active = active;
		Images = images;
	}
	public int getUserID() {
		return UserID;
	}
	public void setUserID(int userID) {
		UserID = userID;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public String getFullname() {
		return Fullname;
	}
	public void setFullname(String fullname) {
		Fullname = fullname;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public boolean isAdmin() {
		return Admin;
	}
	public void setAdmin(boolean admin) {
		Admin = admin;
	}
	public boolean isActive() {
		return Active;
	}
	public void setActive(boolean active) {
		Active = active;
	}
	public String getImages() {
		return Images;
	}
	public void setImages(String images) {
		Images = images;
	}
	
}
