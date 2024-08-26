package br.com.supermarketpetize.model.rest.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {

	private List<String> id_product;
	private String orderStatus;
	private String quantity;
}
