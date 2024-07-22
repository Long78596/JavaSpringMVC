package vn.hoidanit.laptopshop.controller.Admin;

import java.util.List;

import jakarta.validation.Valid;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.*;

import vn.hoidanit.laptopshop.service.UploadServices;
import vn.hoidanit.laptopshop.service.UserService;
import vn.hoidanit.laptopshop.domain.User;

@Controller
public class UserController {
   private final UserService userService;
   private final UploadServices uploadService;
   private PasswordEncoder passwordEncoder;
 


   

   

   public UserController(UserService userService, UploadServices uploadService,
         PasswordEncoder passwordEncoder) {
      this.userService = userService;
      this.uploadService = uploadService;
      this.passwordEncoder = passwordEncoder;
   }

   @RequestMapping("/")
   public String getHomePage(Model model) {
      List<User> arrUsers = this.userService.getAllUsersByEmail("longkolp16@gmail.com");
      System.out.println(arrUsers);
      String test = this.userService.handleHello();
      model.addAttribute("hello", test);
      return "hello";
   }

   @RequestMapping("/admin/user")
   public String getUserPage(Model model) {
      List<User> users = this.userService.getUsersAll();
      model.addAttribute("users", users);
      System.out.println(users);
      return "admin/user/show";
   }

   @RequestMapping("/admin/user/{id}")
   public String getUserDetailsPage(Model model, @PathVariable long id) {
      User user = this.userService.getDetailsUser(id);
      model.addAttribute("user", user);
      model.addAttribute("id", id);
      return "admin/user/details";
   }

   @GetMapping("/admin/user/create")
   public String getCreateUserPage(Model model) {

      model.addAttribute("newUser", new User());
      return "admin/user/create";
   }

   @PostMapping(value = "admin/user/create")
   public String createUserPage(Model model,
         @ModelAttribute("newUser") @Valid  User hoidanit,
         BindingResult newUserBindingResult,
         @RequestParam("hoidanitFile") MultipartFile file) {
         
         //   List<FieldError> errors= newUserBindingResult.getFieldErrors();
         //   for(FieldError error: errors){
         //    System.out.println(">>>>" +error.getField()+ "-"+error.getDefaultMessage());
         //   }
           //validate
           if(newUserBindingResult.hasErrors()){
            return "/admin/user/create";
           }

            String avatar= this.uploadService.handleSaveUploadFile(file,"avatar");
         String hashPassword=this.passwordEncoder.encode(hoidanit.getPassword());
         hoidanit.setAvatar(avatar);
         hoidanit.setPassword(hashPassword);
         hoidanit.setRole(this.userService.getRoleByName(hoidanit.getRole().getName()));
         this.userService.handleSaveUser(hoidanit);
         return "redirect:/admin/user";
   }

   @RequestMapping("/admin/user/update/{id}")
   public String getUserUpdatePage(Model model, @PathVariable long id) {
      User user = this.userService.getDetailsUser(id);
      model.addAttribute("newUser", user);

      // model.addAttribute("user", user);
      model.addAttribute("id", id);
      return "admin/user/update";
   }

   @PostMapping("/admin/user/update")
   public String getUserUpdate(Model model, @ModelAttribute("newUser") User hoidanit) {
      User currentUser = this.userService.getDetailsUser(hoidanit.getId());
      if (currentUser != null) {
         currentUser.setAddress(hoidanit.getAddress());
         currentUser.setFullName(hoidanit.getFullName());
         currentUser.setPhone(hoidanit.getPhone());
         this.userService.handleSaveUser(currentUser);
      }
      return "redirect:/admin/user";
   }

   @GetMapping("/admin/user/delete/{id}")
   public String getDeleteUserPage(Model model, @PathVariable long id) {
      model.addAttribute("id", id);

      model.addAttribute("newUser", new User());
      return "/admin/user/delete";
   }

   @PostMapping("/admin/user/delete")
   public String getDeleteUser(Model model, @ModelAttribute("newUser") User eric) {

      this.userService.deleteUser(eric.getId());
      return "redirect:/admin/user";
   }

}
