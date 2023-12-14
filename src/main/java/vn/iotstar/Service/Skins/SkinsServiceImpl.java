package vn.iotstar.Service.Skins;

import java.util.List;

import vn.iotstar.DAO.SkinsDAO.ISkinsDAO;
import vn.iotstar.DAO.SkinsDAO.SkinsDAOImpl;
import vn.iotstar.Entity.Skins;

public class SkinsServiceImpl implements ISkinsService{
	ISkinsDAO skinDAO = new SkinsDAOImpl();

	@Override
	public void insertSkin(Skins skins) {
		skinDAO.insertSkin(skins);
	}

	@Override
	public void updateSkin(Skins skins) {
		skinDAO.updateSkin(skins);
	}

	@Override
	public void deleteSkin(int skinid) throws Exception {
		skinDAO.deleteSkin(skinid);
	}

	@Override
	public Skins findBySkinId(int skinid) {
		return skinDAO.findBySkinId(skinid);
	}

	@Override
	public List<Skins> findAllSkin() {
		return skinDAO.findAllSkin();
	}

	@Override
	public List<Skins> findBySkinName(String skinname) {
		return skinDAO.findBySkinName(skinname);
	}

	@Override
	public List<Skins> findAllSkin(int page, int pagesize) {
		return skinDAO.findAllSkin(page, pagesize);
	}

	@Override
	public int countSkin() {
		return skinDAO.countSkin();
	}

}
