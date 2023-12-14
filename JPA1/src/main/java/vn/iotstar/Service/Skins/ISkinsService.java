package vn.iotstar.Service.Skins;

import java.util.List;

import vn.iotstar.Entity.Skins;

public interface ISkinsService {
	void insertSkin(Skins skins);
	void updateSkin(Skins skins);
	void deleteSkin(int skinid) throws Exception;
	Skins findBySkinId(int skinid);
	List<Skins> findAllSkin();
	List<Skins> findBySkinName(String skinname);
	List<Skins> findAllSkin(int page,int pagesize);
	int countSkin();
}
