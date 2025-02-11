package com.example.demo.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tb_producto")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ProductoEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idProducto;
	
	@Column(name = "nom_producto", columnDefinition = "VARCHAR(50)", nullable = false)
	private String nomProducto;
	
	@Column(name = "precio" ,nullable = false)
	private double precio;
	
	@Column(name = "Stock", nullable = false)
	private Integer stock;	
	
	@ManyToOne
	@JoinColumn(name = "categoriaId", nullable= false)
	private CategoriaEntity categoriaEntity;
}
