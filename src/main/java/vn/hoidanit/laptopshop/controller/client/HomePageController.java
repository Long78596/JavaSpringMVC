package vn.hoidanit.laptopshop.controller.client;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import vn.hoidanit.laptopshop.domain.Product;
import vn.hoidanit.laptopshop.domain.User;
import vn.hoidanit.laptopshop.domain.dto.RegisterDTO;
import vn.hoidanit.laptopshop.service.ProductServices;
import vn.hoidanit.laptopshop.service.UserService;

import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;





@Controller
public class HomePageController {
       private final ProductServices productServices;
       private final UserService userService;
       private final PasswordEncoder passwordEncoder;
       
   

   

    public HomePageController(ProductServices productServices, UserService userService,
            PasswordEncoder passwordEncoder
          ) {
        this.productServices = productServices;
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    

    @GetMapping
    public String getHomePage( Model model){
        List<Product> products=this.productServices.fetchProducts();
        model.addAttribute("products",products);
     

        return "client/homepage/show";


    }

     @GetMapping("/register")
    public String getRegister(Model model) {
      model.addAttribute("registerUser", new RegisterDTO());
        return "client/auth/register";
    }


    @PostMapping("/register")
    public String handleRegister(@ModelAttribute("registerUser")@Valid RegisterDTO registerDTO,
    BindingResult bindingResult
    ) {
     
      if (bindingResult.hasErrors()) {
        return "client/auth/register";
      }
        User user = this.userService.registerDTOtoUser(registerDTO);
       String hashPassword = this.passwordEncoder.encode(user.getPassword());
        user.setPassword(hashPassword);
        user.setRole(this.userService.getRoleByName("USER"));
        this.userService.handleSaveUser(user);

        System.out.println(user);
       
        return "redirect:login";

    }
    @GetMapping("/login")
    public String getLoginPage(Model model){
            model.addAttribute("registerUser", new RegisterDTO());
        return "client/auth/login";
        }
        
        @GetMapping("/access-deny")
        public String getdenyPage(Model model) {
        
          return "client/auth/deny";
        }
      
       
        
    

    
}
