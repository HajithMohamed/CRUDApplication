package HZ.CrudApplication.Repository;

import HZ.CrudApplication.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
