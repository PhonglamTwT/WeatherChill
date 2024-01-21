package com.example.demo.Controller;

import com.example.demo.Entity.TkChuEntity;
import com.example.demo.Entity.TkKhachEntity;
import com.example.demo.Entity.UserEntity;
import com.example.demo.Repository.ImageRepository;
import com.example.demo.Repository.TkChuRepository;
import com.example.demo.Repository.TkKhachRepository;
import com.example.demo.Repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.thymeleaf.util.StringUtils;


@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    private RedirectAttributes redirectAttributes;

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        return "login";
    }

    @PostMapping("/login")
    public String LoginChu(RedirectAttributes redirectAttributes,
                           @ModelAttribute UserEntity userEntity,
                           Model model) {
        UserEntity user = userRepository.findByEmailAndPassword(userEntity.getEmail(),userEntity.getPassword());
        if (user != null) {
            if(user.getRole().getId() == 1){
                return "redirect:/ListImage";
            }
            String ten = user.getName();
            redirectAttributes.addFlashAttribute("ten", user.getName());
            return "redirect:/ListAlbum?ten=" + ten;
        }else {
            // User not found, display error message
            model.addAttribute("error", "u");
            return "login";
        }
    }
}
