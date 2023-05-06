
package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.transaction.Transaction;

import dto.Train;

public class TrainDao {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
	EntityManager manager = factory.createEntityManager();
	EntityTransaction transaction = manager.getTransaction();

	public void save(Train train) {
		transaction.begin();
		manager.persist(train);
		transaction.commit();
	}
	
	public List<Train> fetch(){
		return manager.createQuery("select a from Train a").getResultList();
		
	}

	public List<Train> fetchAll() {
		// TODO Auto-generated method stub
		return manager.createQuery("select a from Train a").getResultList();
	}
  public void delete(int num)
  {
	  transaction.begin();
	  manager.remove(manager.find(Train.class, num));
	  transaction.commit();
  }
  public Train fetch(int number)
  {
	  return manager.find(Train.class, number);
  }

public void update(Train train) {
	// TODO Auto-generated method stub
	transaction.begin();
	manager.merge(train);
	transaction.commit();
}
	

}
