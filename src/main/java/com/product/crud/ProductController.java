package com.product.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public List<Product> getList(){
        return productService.listAll();
    }

    @PostMapping("/save")
    public void save(@RequestBody Product product){
        productService.save(product);
    }

    @GetMapping("/getProduct/{id}")
    public Product getProduct(@PathVariable Integer id){
        return productService.get(id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        productService.delete(id);
    }

    @PutMapping("/update/{id}")
    public void update(@PathVariable Integer id, @RequestBody Product product) {
        Product p = productService.get(id);
        p.setName(product.getName());
        p.setId(product.getId());
        p.setPrice(product.getPrice());
        productService.update(id, p);
    }
}
