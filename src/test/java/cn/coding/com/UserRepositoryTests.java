package cn.coding.com;

/*@Author JosephCrypto
 *@Create 2022-44-2/7/22 10:44 PM
 */

import cn.coding.com.model.User;
import cn.coding.com.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class UserRepositoryTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository repository;

    @Test
    public void testCreateUser() {
        User user = new User();
        user.setEmail("user@abc.com");
        user.setPassword("$2a$10$UsN4Mnujwsjd4R1BoOliVecZ340HgqO/P9ocCympFJfrzTmB.u84W");
        user.setFirstName("User");
        user.setLastName("test");
        user.setFullName("useradmin");

        User saveUser = repository.save(user);
        User exitUser = entityManager.find(User.class, saveUser.getId());
        assertThat(user.getEmail()).isEqualTo(exitUser.getEmail());
    }
}
