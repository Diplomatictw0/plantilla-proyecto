package uniandes.edu.co.proyecto.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Proveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nit;
    private String nombre;
    private String direccion;
    private String nombreContacto;
    private String telefonoContacto;

    // Getters y Setters
    // Constructor vacío y con parámetros
}
