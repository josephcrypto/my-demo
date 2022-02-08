package cn.coding.com.repository;

import cn.coding.com.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/*@Author JosephCrypto
 *@Create 2022-43-2/7/22 10:43 PM
 */
public interface UserRepository extends JpaRepository<User, Long> {

//    @Query("SELECT u FROM User u WHERE u.email = ?1")
    User findByEmail(String email);
}
