package ijse.springIntroNew.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ijse.springIntroNew.dto.ProductReqDto;
import ijse.springIntroNew.entity.Category;
import ijse.springIntroNew.entity.Product;
import ijse.springIntroNew.service.CategoryService;
import ijse.springIntroNew.service.ProductService;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() {

        List<Product> productList = productService.getProductList();
        return ResponseEntity.status(200).body(productList);
    }

    @PostMapping("/products")
    public ResponseEntity<Product> addProduct(@RequestBody ProductReqDto productReqDto) {
        Product product = new Product();
        product.setName(productReqDto.getName());
        product.setPrice(productReqDto.getPrice());
        product.setDescription(productReqDto.getDescription());

        // find category by categoryTd in ProductReqDto and assign it to a new product
        Category category = categoryService.getCategoryById(productReqDto.getCategoryId());
        product.setCategory(category);

        Product products = productService.createProduct(product);
        return ResponseEntity.status(201).body(products);

    }

}
