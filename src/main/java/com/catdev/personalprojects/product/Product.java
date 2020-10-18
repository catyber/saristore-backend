package com.catdev.personalprojects.product;

public class Product {
    private Long id;
    private String storeId;
    private String productName;

    public Product(Long id, String storeId, String productName) {
        this.id = id;
        this.storeId = storeId;
        this.productName = productName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

}
