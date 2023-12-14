package vn.iotstar.Entity;

import java.io.Serializable;
import java.util.Date;
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
@Table(name="Order_User")
@NamedQuery(name="Order_User.findAllOrder_User", query="SELECT ou FROM Order_User ou")
public class Order_User implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="OrderID")
	private int orderid;
	
	@ManyToOne
	@JoinColumn(name="CartID")
	private Cart cart;
	
	@Column(name="Paid")
	private boolean paid;
	
	@Column(name="Total")
	private int total;
	
	@Column(name="Adress")
	private String address;
	
	@Column(name="OrderDate")
	private Date orderdate;
	
	@Column(name="ArriveDate")
	private Date arrivedate;

	public Order_User() {
		super();
	}

	

	public Order_User(int orderid, Cart cart, boolean paid, int total, String address, Date orderdate,
			Date arrivedate) {
		super();
		this.orderid = orderid;
		this.cart = cart;
		this.paid = paid;
		this.total = total;
		this.address = address;
		this.orderdate = orderdate;
		this.arrivedate = arrivedate;
	}



	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	

	public Cart getCart() {
		return cart;
	}



	public void setCart(Cart cart) {
		this.cart = cart;
	}



	public boolean isPaid() {
		return paid;
	}

	public void setPaid(boolean paid) {
		this.paid = paid;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}

	public Date getArrivedate() {
		return arrivedate;
	}

	public void setArrivedate(Date arrivedate) {
		this.arrivedate = arrivedate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
