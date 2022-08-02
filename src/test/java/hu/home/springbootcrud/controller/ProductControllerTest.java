package hu.home.springbootcrud.controller;

import hu.home.springbootcrud.controller.entity.Product;
import hu.home.springbootcrud.controller.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProductControllerTest {

    @Mock
    ProductService productService;

    @Test
    public void getProductByIdOrNameTest()
    {
        Product productSpaid = new Product(1,"spaid",10,200.5d);
        Product productHammer = new Product(2,"hammer",20,300.4d);
        Product productRake = new Product(3,"rake",30,435.67d);

        when(productService.getProductById(1)).thenReturn(productSpaid);
        when(productService.getProductById(2)).thenReturn(productHammer);
        when(productService.getProductById(3)).thenReturn(productRake);

        assertEquals(productService.getProductById(1),productSpaid);
        assertEquals(productService.getProductById(2),productHammer);
        assertEquals(productService.getProductById(3),productRake);

    }

}

