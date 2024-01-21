package com.example.demo.Controller;

import com.example.demo.Entity.RoleEntity;
import com.example.demo.Entity.TkKhachEntity;
import com.example.demo.Entity.UserEntity;
import com.example.demo.Repository.TkKhachRepository;
import com.example.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegisterController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute UserEntity userEntity,
                               Model model, @RequestParam String name, @RequestParam String password, @RequestParam String email) {
        // Kiểm tra xem người dùng có tồn tại hay không
        System.out.println(""+name +" "+email +" "+password);
        if(name.isEmpty() || email.isEmpty() || password.isEmpty()){
            model.addAttribute("error", "Khong de trong!");
            return "register";
        }
        else if (userRepository.findByName(userEntity.getName()) != null) {
            model.addAttribute("error", "Nick Name đã tồn tại!");
            return "register";
        }
        else if (userRepository.findByEmail(userEntity.getEmail()) != null) {
            model.addAttribute("error", "Tài khoản đã tồn tại!");
            return "register";
        }

        // Set the role for the user
        RoleEntity role = new RoleEntity();
        role.setId(2);  // Assuming 2 is the ID for "Client" role
        userEntity.setRole(role);


        // Lưu người dùng vào cơ sở dữ liệu
        userRepository.save(userEntity);
        // Chuyển hướng đến trang đăng nhập sau khi đăng ký thành công
        return "redirect:/login";
    }
}
