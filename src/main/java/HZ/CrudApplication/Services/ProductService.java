package HZ.CrudApplication.Services;


import HZ.CrudApplication.Models.Product;
import HZ.CrudApplication.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
