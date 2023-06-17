package com.inventorymanagement.system.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Customer")
@ToString
public class Customer {

    @Id
    @GeneratedValue
    private Long customer_id;
    private String customer_name;
    private String customer_address;
    private String phone_number;
    private String email;
}
