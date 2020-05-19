package com.uca.capas.domain;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(schema = "public", name = "contribuyente")
public class Contribuyente {

	@Id
	@Column(name="c_contribuyente")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer c_contribuyente;
	
	@Transient
	private Integer c_importancia;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="c_importancia")
	private Importancia importancia;

	@Column(name = "s_nombre")
	@Size(max = 20, message = "La cantidad maxima es de 20 caracteres!")
	@NotEmpty(message = "El campo no puede quedar vacio!")
	private String s_nombre;
	
	@Column(name = "s_apellido")
	@Size(max = 20, message = "La cantidad maxima es de 20 caracteres!")
	@NotEmpty(message = "El campo no puede quedar vacio!")
	private String s_apellido;
	
	@Column(name = "s_nit")
	@Size(max = 14, min = 14, message = "La cantidad del campo debe ser de 14 caracteres!")
	@NotEmpty(message = "El campo no puede quedar vacio!")
	private String s_nit;
	
	@Column(name = "f_fecha_ingreso")
	@Temporal(TemporalType.DATE)
	private Date f_fecha_ingreso;	

	public Integer getC_importancia() {
		return c_importancia;
	}

	public void setC_importancia(Integer c_importancia) {
		this.c_importancia = c_importancia;
	}

	public Contribuyente() {
		
	}
	
	public Integer getC_contribuyente() {
		return c_contribuyente;
	}

	public void setC_contribuyente(Integer c_contribuyente) {
		this.c_contribuyente = c_contribuyente;
	}

	public Importancia getImportancia() {
		return importancia;
	}

	public void setImportancia(Importancia importancia) {
		this.importancia = importancia;
	}

	public String getS_nombre() {
		return s_nombre;
	}

	public void setS_nombre(String s_nombre) {
		this.s_nombre = s_nombre;
	}

	public String getS_apellido() {
		return s_apellido;
	}

	public void setS_apellido(String s_apellido) {
		this.s_apellido = s_apellido;
	}

	public String getS_nit() {
		return s_nit;
	}

	public void setS_nit(String s_nit) {
		this.s_nit = s_nit;
	}

	public String getF_fecha_ingreso() throws ParseException {
		DateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");  
		Date date2=new SimpleDateFormat("yyyy-mm-dd").parse(String.valueOf(f_fecha_ingreso));
		String strDate = formatter.format(date2); 
		return strDate;
	}

	public void setF_fecha_ingreso(Date f_fecha_ingreso) {
		this.f_fecha_ingreso = f_fecha_ingreso;
	}
	
}
