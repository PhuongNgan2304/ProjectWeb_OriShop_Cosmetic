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
@Table(name = "Products")
@NamedQuery(name = "Products.findAllProduct", query = "SELECT p FROM Products p")
public class Products implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ProductID")
	private int productid;
	
	@Column(name = "ProductName")
	private String productname;
	
	@Column(name = "Price")
	private int price;
	
	@Column(name = "Amount")
	private int amount;
	
	@Column(name = "Description")
	private String description;
	
	@Column(name = "Images")
	private String images;
	
	@Column(name = "Status")
	private boolean status;
	
	@ManyToOne
	@JoinColumn(name = "TypeID")
	private Product_Types product_types;
	
	@ManyToOne
	@JoinColumn(name = "SupplierID")
	private Suppliers suppliers;
	
	@ManyToOne
	@JoinColumn(name = "SkinID")
	private Skins skins;
	
	
	
	@OneToMany(mappedBy = "product", fetch = FetchType.EAGER)
	private List<Cart_Product> cart_product;
	
	
	public Products() {
		super();
	}


	public Products(int productid, String productname, int price, int amount, String description, String images,
			boolean status, Product_Types product_types, Suppliers suppliers, Skins skins,
			List<Cart_Product> cart_product) {
		super();
		this.productid = productid;
		this.productname = productname;
		this.price = price;
		this.amount = amount;
		this.description = description;
		this.images = images;
		this.status = status;
		this.product_types = product_types;
		this.suppliers = suppliers;
		this.skins = skins;
		this.cart_product = cart_product;
	}


	public int getProductid() {
		return productid;
	}


	public void setProductid(int productid) {
		this.productid = productid;
	}


	public String getProductname() {
		return productname;
	}


	public void setProductname(String productname) {
		this.productname = productname;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public int getAmount() {
		return amount;
	}


	public void setAmount(int amount) {
		this.amount = amount;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getImages() {
		return images;
	}


	public void setImages(String images) {
		this.images = images;
	}


	public boolean isStatus() {
		return status;
	}


	public void setStatus(boolean status) {
		this.status = status;
	}


	public Product_Types getProduct_types() {
		return product_types;
	}


	public void setProduct_types(Product_Types product_types) {
		this.product_types = product_types;
	}


	public Suppliers getSuppliers() {
		return suppliers;
	}


	public void setSuppliers(Suppliers suppliers) {
		this.suppliers = suppliers;
	}


	public Skins getSkins() {
		return skins;
	}


	public void setSkins(Skins skins) {
		this.skins = skins;
	}


	public List<Cart_Product> getCart_product() {
		return cart_product;
	}


	public void setCart_product(List<Cart_Product> cart_product) {
		this.cart_product = cart_product;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	


}
