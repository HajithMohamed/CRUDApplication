package HZ.CrudApplication.Models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Product {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String brand;
    private String category;
    private Double price;

    @Column(columnDefinition = "TEXT")
    private String description;

    private String imageFileName;


}