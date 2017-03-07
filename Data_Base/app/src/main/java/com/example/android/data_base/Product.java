package com.example.android.data_base;


/**
 * Created by sanjaypradeep on 21-09-2016.
 */
public class Product {

    int id;
    String product_name;

    public Product(String product_name){
        this.product_name=product_name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public int getId() {
        return id;
    }

    public String getProduct_name() {
        return product_name;
    }
}
