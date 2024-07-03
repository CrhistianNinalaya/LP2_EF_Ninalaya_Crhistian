package com.example.demo.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tb_usuario")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioEntity {
	@Id
	@Column(name = "correo", columnDefinition = "VARCHAR(50)")
	private String correo;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "nombres", columnDefinition = "VARCHAR(50)", nullable = false)
	private String nombres;
	
	@Column(name = "apellidos", columnDefinition = "VARCHAR(50)", nullable = false)
	private String apellidos;
	
	@Column(name = "fecha_nacimiento", nullable = false)
	private LocalDate fecNacimiento;	
	
	private String urlImagen;
}
