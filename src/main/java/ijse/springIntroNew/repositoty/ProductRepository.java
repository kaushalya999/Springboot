package ijse.springIntroNew.repositoty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ijse.springIntroNew.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
