package vn.hoidanit.laptopshop.controller.Admin;

import java.util.List;
import java.util.Optional;

import jakarta.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import vn.hoidanit.laptopshop.domain.Product;
import vn.hoidanit.laptopshop.service.ProductServices;
import vn.hoidanit.laptopshop.service.UploadServices;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ProductController {
    private final UploadServices uploadServices;
    private final ProductServices productServices;
    
    
    public ProductController(UploadServices uploadServices,ProductServices productServices) {
        this.uploadServices = uploadServices;
        this.productServices=productServices;
    }
    @GetMapping("/admin/product")
    public String getProduct(Model model){
        List<Product> prs= this.productServices.fetchProducts();
        model.addAttribute("products", prs);
        return "/admin/product/show";
    }
    @GetMapping("/admin/product/create")
    public String getCreateProduct(Model model) {
        model.addAttribute("newProduct", new  Product());
      return "admin/product/create";
        
    }
    @PostMapping("/admin/product/create")
    public String handCreateProduct(
        @ModelAttribute("newProduct") @Valid Product pr,
        BindingResult newBindingResult,
        @RequestParam("hoidanitFile") MultipartFile file
    ){
          if(newBindingResult.hasErrors()){
              return "admin/product/create";
          }
          String image=this.uploadServices.handleSaveUploadFile(file,"product");
             pr.setImage(image);
             this.productServices.createProduct(pr);
           return "redirect:/admin/product";
    }
    @GetMapping("/admin/product/{id}")
    public String getProductDetailPage( Model model , @PathVariable long id){
        Product pr= this.productServices.fetchProductById(id).get();
        model.addAttribute("product", pr);
        model.addAttribute("id", id);

        return "admin/product/details";
    }
    @GetMapping("/admin/product/delete/{id}")
    public String getDeleteProductPage(Model model, @PathVariable long id){
        model.addAttribute("id", id);
        model.addAttribute("newProduct", new Product());
        return "admin/product/delete";
    }

    @PostMapping("/admin/product/delete")
    public String postDeleteProduct(Model model , @ModelAttribute("newProduct") Product pr){
        this.productServices.deleteProduct(pr.getId());
        return "redirect:/admin/product";
    }
    @GetMapping("/admin/product/update/{id}")
    public String getUpdateProductPage( Model model, @PathVariable long id){
        Optional<Product> currentProduct=this.productServices.fetchProductById(id);
        model.addAttribute("newProduct", currentProduct.get());
        return "admin/product/update";
    }
    
    @PostMapping("/admin/product/update")
    public String handleUpdateProduct(@ModelAttribute("newProduct") @Valid Product pr,
            BindingResult newProductBindingResult,
            @RequestParam("hoidanitFile") MultipartFile file) {

        // validate
        if (newProductBindingResult.hasErrors()) {
            return "admin/product/update";
        }

        Product currentProduct = this.productServices.fetchProductById(pr.getId()).get();
        if (currentProduct != null) {
            // update new image
            if (!file.isEmpty()) {
                String img = this.uploadServices.handleSaveUploadFile(file, "product");
                currentProduct.setImage(img);
            }

            currentProduct.setName(pr.getName());
            currentProduct.setPrice(pr.getPrice());
            currentProduct.setQuantity(pr.getQuantity());
            currentProduct.setDetailDesc(pr.getDetailDesc());
            currentProduct.setShortDesc(pr.getShortDesc());
            currentProduct.setFactory(pr.getFactory());
            currentProduct.setTarget(pr.getTarget());

            this.productServices.createProduct(currentProduct);
        }

        return "redirect:/admin/product";
    }

   
   
    
    
}
