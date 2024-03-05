package com.example.bt_model4_ss3.repository;

import com.example.bt_model4_ss3.model.Product;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
@Controller
public class ProductRepository implements IProductRepository{

    private static List<Product> list;
    private static int size ;
    static {
        list = new ArrayList<>();
        list.add(new Product(1l,"Keo" ,100d,1000d));
        list.add(new Product(2l,"Banh" ,100d,1000d));
        list.add(new Product(3l,"Nuoc ngot" ,100d,1000d));
        list.add(new Product(4l,"Banh My" ,100d,1000d));
        size = list.size();
    }
    @Override
    public List<Product> listProduct() {
        return list;
    }

    @Override
    public void addProduct(Product product) {
        product.setId((long) size);
        list.add(product);
    }

    @Override
    public void updateProduct(Product product) {
        list.stream()
                .forEach(product1 -> {
            if(product1.getId()== product.getId()){
                product1.setId(product1.getId());
                product1.setName(product.getName());
                product1.setPrice(product.getPrice());
                product1.setQuantity(product.getQuantity());
            }
        });
    }

    @Override
    public void deleteProduct(Long id) {
        list.removeIf(e -> e.getId() == id);
    }
}
