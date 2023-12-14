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
@Table(name = "Suppliers")
@NamedQuery(name = "Suppliers.findAllSupplier", query = "SELECT u FROM Suppliers u")
public class Suppliers implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="SupplierID")
	private int supplierid;
	
	@Column(name = "SupplierName")
	private String suppliername;
	
	@Column(name = "Country")
	private String country;
	
	@Column(name="Images")
	private String images;
	
	@Column(name = "Status")
	private boolean status;
	
	@OneToMany(mappedBy = "suppliers", fetch = FetchType.EAGER)
	private List<Products> products;

	public Suppliers() {
		super();
	}

	public Suppliers(int supplierid, String suppliername, String country, String images, boolean status,
			List<Products> products) {
		super();
		this.supplierid = supplierid;
		this.suppliername = suppliername;
		this.country = country;
		this.images = images;
		this.status = status;
		this.products = products;
	}

	public int getSupplierid() {
		return supplierid;
	}

	public void setSupplierid(int supplierid) {
		this.supplierid = supplierid;
	}

	public String getSuppliername() {
		return suppliername;
	}

	public void setSuppliername(String suppliername) {
		this.suppliername = suppliername;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
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

	public List<Products> getProducts() {
		return products;
	}

	public void setProducts(List<Products> products) {
		this.products = products;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
