package hu.home.springbootcrud.controller.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import hu.home.springbootcrud.controller.entity.Product;
import hu.home.springbootcrud.controller.service.ProductService;


@RestController
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product) {
        return service.saveProduct(product);
    }

    @PostMapping("/addProducts")
    public List<Product> addProducts(@RequestBody List<Product> products) {
        return service.saveProducts(products);
    }


    @RequestMapping(value = "api/products", method = RequestMethod.GET)
    public List<Product> findAllProducts() {
        return service.getProducts();
    }

    @RequestMapping(value = "api/productById/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity findProductById(@PathVariable int id) {
        try {
            return new ResponseEntity(service.getProductById(id), HttpStatus.OK);
        }
        catch(Exception ex){
            return new ResponseEntity(ex.getCause(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "api/product/{name}")
    @ResponseBody
    public ResponseEntity findProductByName(@PathVariable String name) {
        try {
            return new ResponseEntity(service.getProductByName(name), HttpStatus.OK);
        }
        catch(Exception ex){
            return new ResponseEntity(ex.getCause(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update")
    public Product updateProduct(@RequestBody Product product) {
        return service.updateProduct(product);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id) {
        return service.deleteProduct(id);
    }
}

