package vn.iotstar.DAO.SkinsDAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import vn.iotstar.Entity.Skins;
import vn.iotstar.JPAConfig.JPAConfig;

public class SkinsDAOImpl implements ISkinsDAO {

	@Override
	public void insertSkin(Skins skins) {
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {
			trans.begin();
			enma.persist(skins);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			throw e;
		} finally {
			enma.close();
		}
	}

	@Override
	public void updateSkin(Skins skins) {
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {
			trans.begin();
			enma.merge(skins);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			throw e;
		} finally {
			enma.close();
		}
	}

	@Override
	public void deleteSkin(int skinid) throws Exception {
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {
			trans.begin();
			Skins skins = enma.find(Skins.class, skinid);
			if (skins != null) {
				enma.remove(skins);
			} else {
				throw new Exception("Không tìm thấy");
			}
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			throw e;
		} finally {
			enma.close();
		}
	}

	@Override
	public Skins findBySkinId(int skinid) {
		EntityManager enma = JPAConfig.getEntityManager();
		Skins skins = enma.find(Skins.class, skinid);
		return skins;
	}

	@Override
	public List<Skins> findAllSkin() {
		EntityManager enma = JPAConfig.getEntityManager();
		TypedQuery<Skins> query = enma.createNamedQuery("Skins.findAllSkin", Skins.class);
		return query.getResultList();
	}

	@Override
	public List<Skins> findBySkinName(String skinname) {
		EntityManager enma = JPAConfig.getEntityManager();
		String jpql = "SELECT s FROM Skins s WHERE s.SkinName like :skinname";
		TypedQuery<Skins> query = enma.createQuery(jpql, Skins.class);
		query.setParameter("skinname", "%" + skinname + "%");

		return query.getResultList();
	}

	@Override
	public List<Skins> findAllSkin(int page, int pagesize) {
		EntityManager enma = JPAConfig.getEntityManager();
		TypedQuery<Skins> query = enma.createNamedQuery("Skins.findAll", Skins.class);
		query.setFirstResult(page * pagesize);
		query.setMaxResults(pagesize);
		return query.getResultList();
	}

	@Override
	public int countSkin() {
		EntityManager enma = JPAConfig.getEntityManager();
		String jpql = "SELECT count(s) FROM Skins s";
		Query query = enma.createQuery(jpql);
		return ((Long) query.getSingleResult()).intValue();
	}
	
	public static void main(String[] args) {
	    SkinsDAOImpl skinsDAO = new SkinsDAOImpl();
	    List<Skins> skinsList = skinsDAO.findAllSkin();
	    
	    if (skinsList != null && !skinsList.isEmpty()) {
	        System.out.println("Có dữ liệu từ cơ sở dữ liệu.");
	        for (Skins skin : skinsList) {
	            System.out.println("Skin ID: " + skin.getSkinid() + ", Skin Name: " + skin.getSkinname());
	        }
	    } else {
	        System.out.println("Không có dữ liệu từ cơ sở dữ liệu.");
	    }
	}


}

