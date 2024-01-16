package exam2;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class TableNameCreate {

	public static void main(String[] args) {
		
		// 무조건 필수
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JpaEx01"); //persistence.xml <persistence-unit name="JpaEx01" 이름이랑 똑같아야함
		EntityManager entityManager = emf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		
		entityManager.close();
		emf.close();
	}
}
