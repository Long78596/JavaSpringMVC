package vn.hoidanit.laptopshop.controller.Admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrderController {


    @GetMapping("/admin/order")
    public String getOrder(){
        return "/admin/order/show";
    }
    
}
