import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class Main {
    public static void main(String[] args){

//        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("META-INF/hibernate.cfg.xml").build();
//        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
//
//        SessionFactory factory = meta.getSessionFactoryBuilder().build();
//        Session session = factory.openSession();
//        Transaction t = session.beginTransaction();
//
//        Client client = new Client();
//        client.setName("Perre");
//        client.setId(5);
//
//        session.save(client);
//        t.commit();
//        System.out.println("Succesfully saved");
//        factory.close();
//        session.close();


        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        Client client = new Client();
        client.setId(5);
        client.setName("Peter");

        Bank bank = new Bank();
        bank.setName("New Bank");

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
//
//        entityManager.persist(client);
//        entityManager.persist(bank);

        entityManager.getTransaction().commit();

        TypedQuery<Client> query = entityManager.createQuery("SELECT c FROM Client c", Client.class);
        List<Client> result = query.getResultList();

        result.forEach(results-> {
            System.out.println(results.getName() + " ");
        });
        entityManagerFactory.close();


    }
}
