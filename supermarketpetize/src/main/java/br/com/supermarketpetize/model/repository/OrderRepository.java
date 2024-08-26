package br.com.supermarketpetize.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.supermarketpetize.model.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long>  {

}
