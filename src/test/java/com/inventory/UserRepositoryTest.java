
package com.inventory;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.inventory.entities.role.Role;
import com.inventory.entities.user.User;
import com.inventory.entities.user.UserRepository;

@DataJpaTest

@AutoConfigureTestDatabase(replace = Replace.NONE)

@Rollback(false)

public class UserRepositoryTest {

	@Autowired
	private UserRepository repo;

	@Autowired
	private TestEntityManager entityManager;
	
	/*
	 * @Test public void testCreateUser() { Role roleAdmin =
	 * entityManager.find(Role.class, 1); User userBrian = new User("Brian",
	 * "Karaya", "bmkaraya@shop.nl", "123456"); userBrian.addRole(roleAdmin);
	 * 
	 * User savedUser = repo.save(userBrian);
	 * assertThat(savedUser.getId()).isGreaterThan(0);
	 * 
	 * }
	 */
	
	/*
	 * @Test public void createUserWithTwoRoles() { User userJane = new User("Jane",
	 * "Joe", "jjoe@shop.nl","editorAdmin"); Role roleEditor =
	 * entityManager.find(Role.class, 2); Role roleSalesPerson =
	 * entityManager.find(Role.class, 3);
	 * 
	 * userJane.addRole(roleEditor); userJane.addRole(roleSalesPerson);
	 * 
	 * User savedUser = repo.save(userJane);
	 * assertThat(savedUser.getId()).isGreaterThan(0); }
	 */
	
	@Test
	public void listAllUsers() {
		Iterable<User> listUsers = repo.findAll();
		listUsers.forEach(user ->System.out.println(user));
	}
	/*
	 * @Test public void getUserById() { User userJane = repo.findById(1).get();
	 * System.out.println(userJane); assertThat(userJane).isNotNull(); }
	 */
		
			 

	/*
	 * @Test public void testCreateRoles() { Role roleAdmin = new
	 * Role("Administrator"); Role roleEditor = new Role("Editor"); Role roleVisitor
	 * = new Role("Visitor");
	 * 
	 * entityManager.persist(roleAdmin); entityManager.persist(roleEditor);
	 * entityManager.persist(roleVisitor);
	 * 
	 * }
	 * 
	 * @Test public void createUserWithOneRole() { Role roleAdmin =
	 * entityManager.find(Role.class, 1); User user = new User("jdoe@shop.nl",
	 * "admin1", "Joe", "Doe"); user.addRole(roleAdmin); repo.save(user); }
	 * 
	 * @Test public void createSuperUser() { Role roleAdmin =
	 * entityManager.find(Role.class, 1); User user = new User("admin", "super",
	 * "user", "admin@shop.nl", "admin1"); user.addRole(roleAdmin);
	 * 
	 * repo.save(user); }
	 * 
	 * @Test public void createUserWithOneRole() { Role roleVisitor =
	 * entityManager.find(Role.class, 3); User user = new User("User1", "Mary",
	 * "Jane", "user1@shop.nl", "user1"); user.addRole(roleVisitor);
	 * 
	 * repo.save(user); }
	 * 
	 * @Test public void createEditorRole() { Role roleEditor =
	 * entityManager.find(Role.class, 2); User user = new User("editor1", "Max",
	 * "user", "editor1@shop.nl", "a1"); user.addRole(roleEditor);
	 * 
	 * repo.save(user); }
	 * 
	 * @Test public void createUserWithTwoRoles() { Role roleAdmin =
	 * entityManager.find(Role.class, 1); Role roleEditor =
	 * entityManager.find(Role.class, 2);
	 * 
	 * User user = new User("editorAdmin", "Jane", "Joe", "jjoe@shop.nl",
	 * "editorAdmin1"); user.addRole(roleAdmin); user.addRole(roleEditor);
	 * 
	 * repo.save(user);
	 * 
	 * }
	 */
	@Test
	public void testCountById() {
		Integer id = 5;
		Long countById=repo.countById(id);
		
		assertThat(countById).isNotNull().isGreaterThan(0);
	}
	
}
