package cn.coding.com.controller;

/*@Author JosephCrypto
 *@Create 2022-01-2/7/22 11:01 PM
 */

import cn.coding.com.model.User;
import cn.coding.com.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/*@Author JosephCrypto
 *@Create 2022-41-2/8/22 9:41 PM
 */

@Controller
public class AppController {

    @Autowired
    private UserRepository repository;

    @GetMapping("/")
    public String showHomePage() {
        return "index";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "signup_form";
    }

    @PostMapping("/process_register")
    public String processRegister(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encoderPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encoderPassword);

        repository.save(user);
        return "register_success";
    }

    @GetMapping("/list_users")
    public String listUsers(Model model) {
        List<User> listUsers = repository.findAll();
        model.addAttribute("listUsers", listUsers);
        return "list-user";
    }
}
