package br.com.supermarketpetize.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.supermarketpetize.model.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{


}
