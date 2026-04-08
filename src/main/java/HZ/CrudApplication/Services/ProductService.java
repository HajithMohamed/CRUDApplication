package HZ.CrudApplication.Services;


import HZ.CrudApplication.Models.Product;
import HZ.CrudApplication.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository proRepo;

    public Product createProduct(Product product){
        return proRepo.save(product);
    }

    public List<Product> getAllProduct(){
        return proRepo.findAll();
    }

    public Product getSingleProduct(Long id){
        return proRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public Product updateProduct(Long id, Product updateProduct){
        Product exsistingProduct = proRepo.findById(id).orElseThrow(()->new RuntimeException("Product is not found"));

        exsistingProduct.setName(updateProduct.getName());
        exsistingProduct.setBrand(updateProduct.getBrand());
        exsistingProduct.setCategory(updateProduct.getCategory());
        exsistingProduct.setImageFileName(updateProduct.getImageFileName());
        exsistingProduct.setPrice(updateProduct.getPrice());

        return proRepo.save(exsistingProduct);
    }

    public void deleteProduct(long id) {
        proRepo.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found")
        );
        proRepo.deleteById(id);
    }
}
