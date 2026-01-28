package ijse.springIntroNew.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ijse.springIntroNew.entity.Product;

@Service
public interface ProductService {

    List<Product> getProductList(); // Reading

    Product createProduct(Product product); // create a product

}
