package com.souleimen.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import com.souleimen.entities.Voyageur;
import com.souleimen.util.JPAutil;

//classe contenant les méthodes génériques ajouter, supprimer,
//consulter par clé primaire (Id)
public class VoyageurDao {
	private EntityManager entityManager=JPAutil.getEntityManager("MonProjetAv");
	//méthode ajouter d'une entité à la bd
	public void ajouter(Voyageur v)
	{
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(v);
		tx.commit();

	}
	//méthode modifier d'une entité à partir de la bd
	public void modifier(Voyageur v)
	{
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.merge(v);
		tx.commit();

	}
	//méthode Supprimer d'une entité à partir de la bd
	public void supprimer(Voyageur v)
	{ 
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		v=entityManager.merge(v); // important
		entityManager.remove(v);
		tx.commit(); 
	}
	//méthode Consulter d'une entité à partir de la bd
	public Voyageur consulter(Voyageur v,Object id)
	{
		return entityManager.find(v.getClass(), id);
	}
	//méthode pour lister tous les objets à partir de la bd
	public List<Voyageur> listerTous() {
		List<Voyageur> voyageurs =
				entityManager.createQuery( 
						"select v from Voyageur v").getResultList();
		return voyageurs;
	}
	//méthode pour lister tous les Voyageur dont le nom contient un 
	//texte donné en paramètre (pnom)
	public List<Voyageur> listerParNom(String nom) {List<Voyageur> voyageurs
		=entityManager.createQuery( "select v from Voyageur v where v.nom like :pnom")
		.setParameter("pnom","%"+nom+"%").getResultList();
	return voyageurs; }}
