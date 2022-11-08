package Users.vpokemon.IdeaProjects.Hibernate.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import java.util.HashSet;
import java.util.Arrays;

public class HibernateXMLConfigStarter {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);

        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        Cart cart = new Cart(345, "Pink");
        Item item1 = new Item(123);
        Item item2 = new Item(243);
        cart.setCart(new HashSet<>(Arrays.asList(item1, item2)));
        session.persist(cart);

        transaction.commit();
        session.close();
    }
}
