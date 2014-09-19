import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class Main {
	private static Configuration configuration;
	private static ServiceRegistry serviceRegistry;

	static {
		configuration = new Configuration().configure();
		serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
				configuration.getProperties()).build();

	}

	public static SessionFactory getSessionFactory() {
		return configuration.buildSessionFactory(serviceRegistry);
	}

	public static void main(String[] args) {
		User user = new User(5, "ioane", "sharvadze", new Date(),
				"5654654654654654");

		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
	}

}
