package rmiClient;

import rmiService.IBanque;
import metier.Compte;

import java.rmi.Naming;
import java.util.Date;

public class BanqueClient {
    public static void main(String[] args) {
        try {
            // Se connecter au registre RMI pour obtenir l'objet distant
            IBanque banque = (IBanque) Naming.lookup("//localhost/BanqueService");

            // Utiliser les méthodes de l'objet distant
            
            Compte nouveauCompte = new Compte(123, 1000.0, new Date()); // Création d'un compte
            String resultat = banque.creerCompte(nouveauCompte); // Appel de la méthode distante

            // Afficher le résultat
            System.out.println("Résultat : " + resultat);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
