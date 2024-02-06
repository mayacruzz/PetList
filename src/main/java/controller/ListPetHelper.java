package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.ListPet;

/**
 * Maya Cruz - Gcruz
 * CIS175 - Spring 2024
 * Feb 5, 2024
 */
public class ListPetHelper {
	
	static EntityManagerFactory emfactory =
			Persistence.createEntityManagerFactory("PetList");

	public void insertItem(ListPet lp) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(lp);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<ListPet> showAllItems(){
		EntityManager em = emfactory.createEntityManager();
		List<ListPet> allItems = em.createQuery("SELECT i FROM ListPet i").getResultList();
		return allItems; }
	
	public void deleteItem(ListPet toDelete) {
		EntityManager em = emfactory.createEntityManager(); em.getTransaction().begin();
		TypedQuery<ListPet> typedQuery = em.createQuery("select lp from ListPet lp where lp.type = :selectedType and lp.name = :selectedName", ListPet.class);
		
		typedQuery.setParameter("selectedType", toDelete.getType()); 
		typedQuery.setParameter("selectedName", toDelete.getName());
		
		typedQuery.setMaxResults(1);
		
		ListPet result = typedQuery.getSingleResult();
		
		em.remove(result); 
		em.getTransaction().commit(); 
		em.close();
	}

	/**
	 * @param petType
	 * @return
	 */
	public List<ListPet> searchForPetByType(String petType) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager(); em.getTransaction().begin();
		TypedQuery<ListPet> typedQuery = em.createQuery("select lp from ListPet lp where lp.type = :selectedType", ListPet.class); typedQuery.setParameter("selectedType", petType);
		List<ListPet> foundItems = typedQuery.getResultList(); em.close();
		return foundItems; 
	}

	/**
	 * @param petName
	 * @return
	 */
	public List<ListPet> searchForPetByName(String petName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager(); em.getTransaction().begin();
		TypedQuery<ListPet> typedQuery = em.createQuery("select lp from ListPet lp where lp.name = :selectedName", ListPet.class); typedQuery.setParameter("selectedName", petName);
		List<ListPet> foundItems = typedQuery.getResultList(); em.close();
		return foundItems;
	}
	
	public ListPet searchForItemById(int idToEdit) { 
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager(); 
		em.getTransaction().begin();
		ListPet found = em.find(ListPet.class, idToEdit); 
		em.close();
		return found;
		}

	/**
	 * @param toEdit
	 */
	public void updatePet(ListPet toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager(); 
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit(); 
		em.close();
	}
	public void cleanUp(){
		emfactory.close(); 
		}

}
