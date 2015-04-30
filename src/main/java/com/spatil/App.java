package com.spatil;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spatil.person.model.Person;
import com.spatil.person.service.PersonService;

/**
 * @author sunil_patil1
 * 
 */
public class App {
	public static void main(String[] args) {
		ApplicationContext appContext = new ClassPathXmlApplicationContext(
				"spring/config/spring-config.xml");
		PersonService personService = appContext.getBean("personService",
				PersonService.class);

		Person person = new Person();
		person.setName("sunil");
		person.setEmail("sunilpatil@gmail.com");

		personService.addPerson(person);
		System.out.println("Person Saved Successfully...");
		
		person = personService.findPersonByName("sunil");
		System.out.println(person.getName());

		// Person p = appContext.getBean("person",Person.class);

		String[] beanNames = appContext.getBeanDefinitionNames();
		for (String beanName : beanNames)
			System.out.println(beanName);

	}
}
