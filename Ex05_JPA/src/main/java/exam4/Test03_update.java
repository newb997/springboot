package exam4;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Test03_update {

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
			
			user.changeName("이나은");		// 자바객체를 통해 영속 컨텍스트의 값 변경
			
//			Member4 user = new Member4();	// em.find를 하지 않으면 업데이트가 되지 않는다
//			user.changeName("이나은");
			
			em.getTransaction().commit();
			System.out.println("이름을 변경했습니다");
			
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		
		em.close();
		emf.close();
	}
}












