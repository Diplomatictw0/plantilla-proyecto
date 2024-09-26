package uniandes.edu.co.proyecto.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private int costoBodega;
    private int precioUnitario;
    private String presentacion;
    private int cantidadPresentacion;
    private String unidadMedida;
    private int volumenEmpaque;
    private int pesoEmpaque;
    private Date fechaExpiracion;
    private String codigoBarras;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private CategoriaProducto categoriaProducto;

    // Getters y Setters
    // Constructor vacío y con parámetros
}
