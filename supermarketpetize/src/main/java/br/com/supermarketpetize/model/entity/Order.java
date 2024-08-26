package br.com.supermarketpetize.model.entity;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.PrePersist;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate orderDate;

	@ManyToMany
	@JoinTable(name = "order_products", joinColumns = @JoinColumn(name = "order_id"), inverseJoinColumns = @JoinColumn(name = "product_id") )
	private List<Product> products;

	@Column(nullable = false)
	private OrderStatus orderStatus;

	@Column(nullable = false)
	private Integer quantity;

	@PrePersist
	public void Prepersist() {
		setOrderDate(LocalDate.now());
	}

}
