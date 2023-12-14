package vn.iotstar.Service.Suppliers;

import java.util.List;

import vn.iotstar.DAO.SuppliersDAO.ISuppliersDAO;
import vn.iotstar.DAO.SuppliersDAO.SuppliersDAO_Impl;
import vn.iotstar.Entity.Suppliers;

public class SupplierServiceImpl implements ISuppliersService{
	ISuppliersDAO supplierDAO = new SuppliersDAO_Impl();
	
	@Override
	public void insertSupplier(Suppliers suppliers) {
		supplierDAO.insertSupplier(suppliers);
	}

	@Override
	public void updateSupplier(Suppliers suppliers) {
		supplierDAO.updateSupplier(suppliers);
	}

	@Override
	public void deleteSupplier(int supplierid) throws Exception {
		supplierDAO.deleteSupplier(supplierid);
	}

	@Override
	public Suppliers findBySupplierId(int supplierid) {
		return supplierDAO.findBySupplierId(supplierid);
	}

	@Override
	public List<Suppliers> findAllSupplier() {
		return supplierDAO.findAllSupplier();
	}

	@Override
	public List<Suppliers> findBySupplierName(String suppliername) {
		return supplierDAO.findBySupplierName(suppliername);
	}

	@Override
	public List<Suppliers> findAllSupplier(int page, int pagesize) {
		return supplierDAO.findAllSupplier(page, pagesize);
	}

	@Override
	public int countSupplier() {
		return supplierDAO.countSupplier();
	}

}
