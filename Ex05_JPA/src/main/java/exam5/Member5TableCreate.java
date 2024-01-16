package exam5;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Member5TableCreate {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JpaEx01"); //persistence.xml <persistence-unit name="JpaEx01" 이름이랑 똑같아야함
		EntityManager em = emf.createEntityManager();
		
		em.close();
		emf.close();
	}
}
