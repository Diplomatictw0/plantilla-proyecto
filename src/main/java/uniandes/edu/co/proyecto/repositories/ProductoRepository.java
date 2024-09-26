package uniandes.edu.co.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uniandes.edu.co.proyecto.entity.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
}

