package com.nashtech.observability_pi_shaped.repository;

import com.nashtech.observability_pi_shaped.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
