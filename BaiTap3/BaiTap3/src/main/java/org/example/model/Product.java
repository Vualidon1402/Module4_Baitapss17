package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product {
    private Integer product_id;
    private Integer category_id;
    private String product_name;
    private Double product_price;
    private Integer totalPages;
    private java.sql.Date yearCreate;
    private String product_author;
    private boolean product_status;

}
