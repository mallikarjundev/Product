package com.product.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    public List<Product> listAll() {
        return productRepository.findAll();
    }
    public void save(Product product){
        productRepository.save(product);
    }

    public Product get(Integer id){
        return productRepository.findById(id).get();
    }
    public void delete(Integer id){
        productRepository.deleteById(id);
    }

    public void update(Integer id, Product product) {
        productRepository.save(product);
    }
}
