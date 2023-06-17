package com.inventorymanagement.system.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
@ToString

public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long supplier_id;
    private String supplier_name;
    private String contact_person;
    private String address;
    private String phone_number;
    private String email;

    @OneToMany(mappedBy = "supplier")
    private List<Product> products;

}
