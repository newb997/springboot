package exam4;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Test04_delete {

	public static void main(String[] args) {
		// 무조건 필수
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JpaEx01"); //persistence.xml <persistence-unit name="JpaEx01" 이름이랑 똑같아야함
		EntityManager em = emf.createEntityManager();
		
	
		try {
			em.getTransaction().begin();
			
			Member4 user = em.find(Member4.class, "test@test.com");
			if(user == null) {
				System.out.println("존재하지 않습니다");
				return;
			} 
			em.remove(user);	// 데이터베이스에서 삭제가 아니라 영속성 컨테이너에서 삭제되는것임
			
			em.getTransaction().commit();	// 커밋을 해야 데이터베이스에서 삭제가 됨
			System.out.println("탈퇴처리 하였습니다");
			
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		
		em.close();
		emf.close();
	}
}












