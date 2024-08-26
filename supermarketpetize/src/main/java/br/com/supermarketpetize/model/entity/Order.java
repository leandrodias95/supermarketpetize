package br.com.supermarketpetize.model.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
	
	@Column
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate orderDate;
	
	@ManyToOne
	@JoinColumn(name = "id_product")
	private Product product; 
	
	@Column
	private String orderStatus;
	
	@PrePersist
	public void Prepersist() {
		setOrderDate(LocalDate.now());
	}

}
