package vn.iotstar.DAO.SuppliersDAO;

import java.util.List;

import vn.iotstar.Entity.Suppliers;


public interface ISuppliersDAO {
	void insertSupplier(Suppliers suppliers);
	void updateSupplier(Suppliers suppliers);
	void deleteSupplier(int supplierid) throws Exception;
	Suppliers findBySupplierId(int supplierid);
	List<Suppliers> findAllSupplier();
	List<Suppliers> findBySupplierName(String suppliername);
	List<Suppliers> findAllSupplier(int page,int pagesize);
	int countSupplier();

}
