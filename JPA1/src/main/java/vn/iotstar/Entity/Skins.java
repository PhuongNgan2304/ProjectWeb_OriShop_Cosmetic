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
@Table(name="Skins")
@NamedQuery(name="Skins.findAllSkin", query="SELECT s FROM Skins s")
public class Skins implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="SkinID")
	private int skinid;
	
	@Column(name="SkinName")
	private String skinname;
	
	@Column(name="Images")
	private String images;

	@OneToMany(mappedBy = "skins", fetch = FetchType.EAGER)
	private List<Products> products;

	public Skins() {
		super();
	}

	public Skins(int skinid, String skinname, String images, List<Products> products) {
		super();
		this.skinid = skinid;
		this.skinname = skinname;
		this.images = images;
		this.products = products;
	}

	public int getSkinid() {
		return skinid;
	}

	public void setSkinid(int skinid) {
		this.skinid = skinid;
	}

	public String getSkinname() {
		return skinname;
	}

	public void setSkinname(String skinname) {
		this.skinname = skinname;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
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
