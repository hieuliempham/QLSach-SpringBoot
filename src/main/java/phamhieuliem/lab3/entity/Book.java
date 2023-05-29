package phamhieuliem.lab3.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import phamhieuliem.lab3.validator.annotation.ValidCategoryId;

@Data
@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    @NotEmpty(message = "Title must not be empty")
    @Size(max = 50, min = 1, message = "Tiltle must less than 50 characters")
    private String title;

    @Column(name = "author")
    private String author;


    @Column(name = "price")
    @NotNull(message = "Price is required")
    private Double price;

    @ManyToOne
    @JoinColumn(name = "category_id")
    @ValidCategoryId
    private Category category;
}
