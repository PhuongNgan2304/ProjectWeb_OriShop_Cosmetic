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
@Table(name="Product_Types")
@NamedQuery(name="Product_Types.findAllType", query="SELECT t FROM Product_Types t")
public class Product_Types implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="TypeID")
	private int typeid;
	
	@Column(name = "TypeName")
	private String typename;
	
	@Column(name = "Images")
	private String images;
	
	@Column(name = "TypeCode")
	private String typecode;
	
	@Column(name = "Status")
	private boolean status;
	
		
	@OneToMany(mappedBy = "product_types", fetch = FetchType.EAGER)
	private List<Products> products;

	public Product_Types() {
		
	}

	public Product_Types(int typeid, String typename, String images, String typecode, boolean status,
			List<Products> products) {
		super();
		this.typeid = typeid;
		this.typename = typename;
		this.images = images;
		this.typecode = typecode;
		this.status = status;
		this.products = products;
	}

	public int getTypeid() {
		return typeid;
	}

	public void setTypeid(int typeid) {
		this.typeid = typeid;
	}

	public String getTypename() {
		return typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public String getTypecode() {
		return typecode;
	}

	public void setTypecode(String typecode) {
		this.typecode = typecode;
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
