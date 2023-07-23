package hw40.dao;

import hw40.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query("SELECT o FROM Order o JOIN FETCH o.orderProducts op JOIN FETCH op.product p WHERE o.id = ?1")
    Order findByIdWithRelatedProducts(Long id);
}
