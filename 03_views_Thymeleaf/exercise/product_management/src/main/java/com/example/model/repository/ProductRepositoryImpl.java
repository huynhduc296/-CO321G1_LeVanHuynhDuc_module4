package com.example.model.repository;

import com.example.model.bean.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
    private static final Map<Integer, Product> products;

    static {

        products = new HashMap<>();
        products.put(1, new Product(1, "John", 123));
        products.put(2, new Product(2, "Bill", 2322));
        products.put(3, new Product(3, "Alex", 1232));
        products.put(4, new Product(4, "Adam", 2222));
        products.put(5, new Product(5, "Sophia", 7845));
        products.put(6, new Product(6, "Rose", 235));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id,product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }

    @Override
    public List<Product> searchByName(String name) {
            List<Product> list=new ArrayList<>(products.values());
            List<Product> productList=new ArrayList<>();
            for (int i=0;i<list.size();i++){
                if (list.get(i).getName().toLowerCase().contains(name.toLowerCase())){
                    productList.add(list.get(i));
                }
            }
            return productList;
        }
}
