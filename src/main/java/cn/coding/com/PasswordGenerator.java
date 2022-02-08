package cn.coding.com;

/*@Author JosephCrypto
 *@Create 2022-31-2/8/22 10:31 PM
 */

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordGenerator {

    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawPassword = "tryme123";
        String encodedPassword = encoder.encode(rawPassword);
        System.out.println(encodedPassword);

    }

}
