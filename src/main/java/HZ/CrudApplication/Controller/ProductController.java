package HZ.CrudApplication.Controller;

import HZ.CrudApplication.Models.Product;
import HZ.CrudApplication.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService proSer;

    @GetMapping("/get-all-products")
    //@ResponseBody
//    public List<Product> getAllProduct()
    public String getAllProduct(Model model) {
        model.addAttribute("products", proSer.getAllProduct());
        return "products/index";
    }

    @PostMapping("/create-product")
    @ResponseBody
    public Product createProduct(@RequestBody Product product){
        return proSer.createProduct(product);
    }



    @GetMapping("/get-single-product/{id}")
    @ResponseBody
    public Product getSingleProduct(@PathVariable Long id){
        return proSer.getSingleProduct(id);
    }

    @PutMapping("update-product/{id}")
    @ResponseBody
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product){
        return proSer.updateProduct(id, product);
    }

    @DeleteMapping("/delete-product/{id}")
    @ResponseBody
    public String deleteProduct(@PathVariable long id){
        proSer.deleteProduct(id);
        return "Product deleted successfully";
    }
}
