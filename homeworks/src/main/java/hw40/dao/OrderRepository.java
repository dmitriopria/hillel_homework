package hw40.dao;

import hw40.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query("SELECT DISTINCT o FROM Order o LEFT JOIN FETCH o.products p WHERE o.id = ?1")
    Order findByIdWithRelatedProducts(Long id);
}
