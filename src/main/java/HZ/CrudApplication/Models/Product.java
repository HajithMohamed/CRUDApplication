package HZ.CrudApplication.Models;

import jakarta.persistence.*;
import jdk.jfr.DataAmount;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name ="products")
@Data
public class Product {
    @Id
    @GeneratedValue()
    private int id;

    private String name;
    private String brand;
    private String category;
    private double price;

    @Column(columnDefinition = "TEXT")
    private String description;
    private Date createdAt;
    private String imageFileName;

}
