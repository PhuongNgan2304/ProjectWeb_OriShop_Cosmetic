package vn.iotstar.Entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Cart")
@NamedQuery(name="Cart.findAllCart", query="SELECT ca FROM Cart ca")
public class Cart implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="CartID")
	private int cartid;
	
	@Column(name="CartCode")
	private String cartcode;
	
	@Column(name = "Active")
	private boolean active;
	
	@ManyToOne
	@JoinColumn(name="UserID")
	private Users users;
	
	@ManyToOne
	@JoinColumn(name="OrderID")
	private Order_User order_user;
	
	@OneToMany(mappedBy = "cart", fetch = FetchType.EAGER)
	private List<Cart_Product> cart_product;

	public Cart() {
		super();
	}
	

	public Cart(int cartid, String cartcode, boolean active, Users users, Order_User order_user,
			List<Cart_Product> cart_product) {
		super();
		this.cartid = cartid;
		this.cartcode = cartcode;
		this.active = active;
		this.users = users;
		this.order_user = order_user;
		this.cart_product = cart_product;
	}


	public int getCartid() {
		return cartid;
	}
	public void setCartid(int cartid) {
		this.cartid = cartid;
	}

	public String getCartcode() {
		return cartcode;
	}
	public void setCartcode(String cartcode) {
		this.cartcode = cartcode;
	}

	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}

	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<Cart_Product> getCart_product() {
		return cart_product;
	}
	public void setCart_product(List<Cart_Product> cart_product) {
		this.cart_product = cart_product;
	}


	public Order_User getOrder_user() {
		return order_user;
	}
	public void setOrder_user(Order_User order_user) {
		this.order_user = order_user;
	}

	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
}
