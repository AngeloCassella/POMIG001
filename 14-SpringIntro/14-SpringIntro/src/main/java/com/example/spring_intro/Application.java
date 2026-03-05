package com.example.spring_intro;

import com.example.spring_intro.classes.User;
import com.example.spring_intro.components.UserComponent;
import com.example.spring_intro.configurations.UserConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

		System.out.println("Springboot App...");

//		User u1 = new User("Mario", "Rossi", 45, "Roma", "m.rossi@example.com");
//		System.out.println(u1);
//		User u2 = new User();
//		u2.setFirstName("Giuseppe");
//		u2.setLastName("Verdi");
//		u2.setCity("Milano");
//		u2.setAge(21);
//		u2.setEmail("g.verdi@example.com");
//		System.out.println(u2);


		// Per creare instanze in una Applicazione Spring possiamo utilizzare:
		// -> Configurazione di Beans tramite file xml
		//    configWithXml();
		// -> Configurazione di Beans tramite Classe con Annotation @Configuration
		//	  configWithConfigurationClass();
		// -> Configurazione di Beans tramite Annotation @Component sulla classe Pojo
		//	  configWithComponent();
	}

	public static void configWithXml() {
		// Creo un Application Context dove gestire il ciclo di vita di un bean
		// creato tramite file di configurazione XML
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("configuration_beans.xml");

		// Creazione di un bean tramite il costruttore
		User userXML1 = (User) context.getBean("beanUser");
		System.out.println(userXML1);
		User userXML1_1 = (User) context.getBean("beanUser");
		System.out.println(userXML1_1);

		// Creazione di un bean tramite i setter
		User userXML2 = (User) context.getBean("beanUserSet");
		System.out.println(userXML2);
		User userXML2_1 = (User) context.getBean("beanUserSet");
		System.out.println(userXML2_1);

		// Creazione di un bean di tipo prototype
		User userXML3 = (User) context.getBean("beanUserCopy");
		userXML3.setFirstName("Francesca");
		userXML3.setLastName("Neri");
		System.out.println(userXML3);
		User userXML3_1 = (User) context.getBean("beanUserCopy");
		userXML3_1.setFirstName("Antonio");
		userXML3_1.setLastName("Bianchi");
		System.out.println(userXML3_1);

		// Chiudere l'Application Context
		context.close();

	}

	public static void configWithConfigurationClass() {
		// Creo un Application Context dove gestire il ciclo di vita di un bean
		// creato tramite una classe di configurazione
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(UserConfiguration.class);

		// Creazione di un bean tramite il costruttore
		User userAdminConfig = (User) context.getBean("adminUser");
		System.out.println(userAdminConfig);

		// Creazione di un bean tramite il costruttore
		User userCustomConfig = (User) context.getBean("customUser", "Giuseppe", "Verdi", 21, "Milano", "g.verdi@example.com");
		System.out.println(userCustomConfig);

		// Chiudere l'Application Context
		context.close();
	}

	public static void configWithComponent() {
		// Creo un Application Context dove gestire il ciclo di vita di un bean
		// creato tramite una classe di configurazione
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(UserConfiguration.class);

		context.scan("com.example.spring_intro.components");
		//context.refresh();

		// Creazione di un bean tramite il costruttore
		UserComponent userComponent =  (UserComponent) context.getBean("user_component", "Giuseppe", "Verdi", 63, "Milano", "g.verdi@example.com");
		System.out.println(userComponent);

		// Creazione di un bean tramite i setter
		UserComponent userComponentSet = (UserComponent) context.getBean("user_component");
		userComponentSet.setFirstName("Francesca");
		userComponentSet.setLastName("Neri");
		userComponentSet.setAge(21);
		userComponentSet.setCity("Napoli");
		userComponentSet.setEmail("f.neri@example.com");
		System.out.println(userComponentSet);



		// Chiudere l'Application Context
		context.close();
	}
}
