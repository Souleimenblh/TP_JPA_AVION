package com.souleimen.test;
import com.souleimen.dao.VoyageurDao;
import com.souleimen.entities.Voyageur;

public class VoyageurTest {
	public static void main(String[] args) {
		//créer un objet Voyageur
		Voyageur v = new Voyageur();
		v.setNom("Bel Hadj Souleimen");
		v.setVille("Nabeul");
		
		//Voyageur v1 = new Voyageur();
		//v1.setNom("Bel Hadj abdelkader");
		//v1.setVille("Nabeul");
		
		//ajouter l'objet Voyageur à la BD
		VoyageurDao voDao = new VoyageurDao();
		voDao.ajouter(v); 
		//voDao.ajouter(v1); 

		
        // Afficher les voyageur avant modification
        System.out.println("Appel de la méthode listerTous avant modification :");
        for (Voyageur vo : voDao.listerTous())
            System.out.println(vo.getCode() + " " + vo.getNom());

        // Modifier le voyageur
        v.setNom("Nouveau Nom");
        voDao.modifier(v);
        System.out.println("Appel de la méthode listerTous après modification :");
        for (Voyageur vo : voDao.listerTous())
            System.out.println(vo.getCode() + " " + vo.getNom());

        // Supprimer le voyageur
        voDao.supprimer(v);
        System.out.println("Appel de la méthode listerTous après suppression :");
        for (Voyageur vo : voDao.listerTous())
            System.out.println(vo.getCode() + " " + vo.getNom());
	}
}
