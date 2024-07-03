package com.example.demo.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name = "tb_categoria")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_categoria")
	private Integer idCategoria;
	
	@Column(name = "nom_categoria", columnDefinition = "VARCHAR(50)", nullable = false)
	private String nomCategoria;
}
