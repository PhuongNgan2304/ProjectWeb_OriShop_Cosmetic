package vn.iotstar.DAO.UsersDAO;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import vn.iotstar.Entity.Users;
import vn.iotstar.JPAConfig.JPAConfig;
public class UsersDAO_Impl implements IUsersDAO{
	@Override
	public Users login(String user,String pass) {
		EntityManager emma=JPAConfig.getEntityManager();
		try {
            // Sử dụng TypedQuery để tìm một bản ghi Login dựa trên tên người dùng và mật khẩu
            TypedQuery<Users> query = emma.createQuery("SELECT u FROM Users u WHERE u.Username =:user AND u.Password = :pass", Users.class);
            query.setParameter("user", user);
            query.setParameter("pass", pass);
            // Trả về đối tượng Login nếu tìm thấy
            return query.getSingleResult();
        } catch (Exception e) {
            // Nếu không tìm thấy kết quả, hoặc có lỗi, trả về null hoặc xử lý theo cách khác
            return null;
        } finally {
            emma.close(); // Đảm bảo đóng EntityManager sau khi sử dụng
        }
		    
		}
	
	@Override
	//Tạo tài khoản
	public void SignUp(Users signup) {
		EntityManager emma=JPAConfig.getEntityManager();
		EntityTransaction trans =emma.getTransaction();
		try {
			trans.begin();
			emma.persist(signup);
			trans.commit();
		}catch(Exception e) {
			e.printStackTrace();
			trans.rollback();
			throw e;
		}finally {
			emma.close();
		}
	}
	@Override
	public Users checkAccountExist(String user)
	{
		EntityManager emma=JPAConfig.getEntityManager();
		try {
            // Sử dụng TypedQuery để tìm một bản ghi Login dựa trên tên người dùng và mật khẩu
            TypedQuery<Users> query = emma.createQuery("SELECT l FROM Login l WHERE l.Username =:user", Users.class);
            query.setParameter("user", user);
            // Trả về đối tượng Login nếu tìm thấy
            return query.getSingleResult();
        } catch (Exception e) {
            // Nếu không tìm thấy kết quả, hoặc có lỗi, trả về null hoặc xử lý theo cách khác
            return null;
        } finally {
            emma.close(); // Đảm bảo đóng EntityManager sau khi sử dụng
        }
	}

	//CHỨC NĂNG QUẢN LÍ USER CHO ADMIN
	@Override
	public void UpdateUser(Users user ) {
		EntityManager emma=JPAConfig.getEntityManager();
		EntityTransaction trans =emma.getTransaction();
		try {
			trans.begin();
			emma.merge(user);
			trans.commit();
		}catch(Exception e) {
			e.printStackTrace();
			trans.rollback();
			throw e;
		}finally {
			emma.close();
		}
	}
	

	@Override
	public void DeleteUser(int userid) {
			EntityManager enma = JPAConfig.getEntityManager();
			EntityTransaction trans = enma.getTransaction();
			try {
				trans.begin();
				Users user = enma.find(Users.class,userid);
				if(user != null) {
					enma.remove(user);
				}else {
					throw new Exception("Không tìm thấy");
				}

				trans.commit();
			} catch (Exception e) {
				e.printStackTrace();
				trans.rollback();
			}finally {
				enma.close();
			}
		
	}
	@Override
	public void DeleteUser(String username) {
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {
			trans.begin();
			Users user = enma.find(Users.class,username);
			if(user != null) {
				enma.remove(user);
			}else {
				throw new Exception("Không tìm thấy");
			}

			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		}finally {
			enma.close();
		}
	}
	@Override
	public List<Users> findAll() {
		EntityManager enma = JPAConfig.getEntityManager();
		TypedQuery<Users> query= enma.createNamedQuery("Users.findAll", Users.class);
		return query.getResultList();
	}
	@Override
	public List<Users> findAll(int page, int pagesize){
		EntityManager enma = JPAConfig.getEntityManager();
		TypedQuery<Users> query= enma.createNamedQuery("Users.findAll", Users.class);
		query.setFirstResult(page*pagesize);
		query.setMaxResults(pagesize);
		return query.getResultList();
    }
	@Override
	public Users findByUserId(int userid) {
		EntityManager enma = JPAConfig.getEntityManager();
		Users user  = enma.find(Users .class,userid);
		return user ;
	}
	@Override
	public Users findByUserName(String username) {
		EntityManager enma = JPAConfig.getEntityManager();
		Users user  = enma.find(Users .class,username);
		return user ;
	}
	@Override
	public Users findByEmail(String email) 
	{
		EntityManager emma=JPAConfig.getEntityManager();
		try {
            // Sử dụng TypedQuery để tìm một bản ghi Login dựa trên tên người dùng và mật khẩu
            TypedQuery<Users> query = emma.createQuery("SELECT u FROM Users u WHERE u.Email =:email", Users.class);
            query.setParameter("email", email);
            System.out.println("email:" + query.getSingleResult());
            // Trả về đối tượng Login nếu tìm thấy
            return query.getSingleResult();
        } catch (Exception e) {
            // Nếu không tìm thấy kết quả, hoặc có lỗi, trả về null hoặc xử lý theo cách khác
            return null;
        } finally {
            emma.close(); // Đảm bảo đóng EntityManager sau khi sử dụng
        }
		
	}
	public static void main(String[] args) {
	    IUsersDAO usersDAO = new UsersDAO_Impl();
	    List<Users> usersList = usersDAO.findAll();
	    
	    if (usersList != null && !usersList.isEmpty()) {
	        System.out.println("Có dữ liệu từ cơ sở dữ liệu.");
	        for (Users users : usersList) {
	            System.out.println("User ID: " + users.getUserID() + ", User Name: " + users.getUsername());
	        }
	    } else {
	        System.out.println("Không có dữ liệu từ cơ sở dữ liệu.");
	    }
	}

}
