package fr.epsi.b3devc1;

import fr.epsi.b3devc1.bo.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("banque-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            // Créer deux clients
            Client client1 = new Client();
            client1.setMontant(1000.0);
            client1.setMotif("Client VIP 1");
            client1.setDate(LocalDate.now());

            Client client2 = new Client();
            client2.setMontant(2000.0);
            client2.setMotif("Client VIP 2");
            client2.setDate(LocalDate.now());

            // Créer un compte
            Compte compte = new Compte();
            compte.setNumero("123456");
            compte.setSolde(1500.0);

            // Associer le compte au premier client
            client1.addCompte(compte);

            // Persister les entités
            em.persist(client1);
            em.persist(compte);

            // Associer le compte au deuxième client
            client2.addCompte(compte);

            // Persister les entités
            em.persist(client2);

            // Créer un client
            Client client = new Client();
            em.persist(client);

            // Créer un Livret A
            LivretA livretA = new LivretA();
            livretA.setNumero("LIV123");
            livretA.setSolde(5000.0);
            livretA.setTaux(1.2);
            client.addCompte(livretA);
            em.persist(livretA);

            // Créer une Assurance Vie
            AssuranceVie assuranceVie = new AssuranceVie();
            assuranceVie.setNumero("ASS789");
            assuranceVie.setSolde(10000.0);
            assuranceVie.setTaux(2.5);
            assuranceVie.setDateFin(LocalDate.of(2030, 12, 31));
            client.addCompte(assuranceVie);
            em.persist(assuranceVie);

            // Récupérer un compte existant (par exemple, compte id=1)
            compte = em.find(Compte.class, 1);
            if (compte == null) {
                System.out.println("Compte introuvable !");
                return;
            }

            // Insérer une opération de type opération
            Operation op1 = new Operation();
            op1.setDate(LocalDateTime.now());
            op1.setMontant(200.0);
            op1.setMotif("Paiement facture");
            op1.setCompte(compte);
            em.persist(op1);

            // Insérer une opération de type virement
            Virement virement = new Virement();
            virement.setDate(LocalDateTime.now());
            virement.setMontant(500.0);
            virement.setMotif("Virement salaire");
            virement.setBeneficiaire("Jean Dupont");
            virement.setCompte(compte);
            em.persist(virement);


            em.getTransaction().commit();
            System.out.println("Données insérées avec succès!");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Échec de l'insertion des données.");
            em.getTransaction().rollback();
        } finally {
            em.close();
            emf.close();
        }
    }
}
