import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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
		User user = new User(15, "ioane", "sharvadze", new Date(),
				"5654654654654654");
		Car car = new Car("masserati" , new Date());
		car.setOwner(user);
		Set<Car> userCars = new HashSet<>();
		userCars.add(car);
		user.setCars(userCars);
		
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		
		session.save(user);
		session.save(car);
		
		session.getTransaction().commit();
		session.close();
	}

}
