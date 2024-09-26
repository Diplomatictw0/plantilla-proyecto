package uniandes.edu.co.proyecto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uniandes.edu.co.proyecto.entity.CategoriaProducto;
import uniandes.edu.co.proyecto.repositories.CategoriaProductoRepository;

@Service
public class CategoriaProductoService {

    @Autowired
    private CategoriaProductoRepository categoriaProductoRepository;

    // Crear una nueva categoría
    public CategoriaProducto crearCategoria(CategoriaProducto categoria) {
        return categoriaProductoRepository.save(categoria);
    }

    // Leer una categoría por nombre o código
    public CategoriaProducto leerCategoriaPorId(Long id) {
        return categoriaProductoRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Categoría no encontrada con id: " + id));
    }

    public CategoriaProducto leerCategoriaPorNombre(String nombre) {
        return categoriaProductoRepository.findAll()
            .stream()
            .filter(categoria -> categoria.getNombre().equalsIgnoreCase(nombre))
            .findFirst()
            .orElseThrow(() -> new ResourceNotFoundException("Categoría no encontrada con nombre: " + nombre));
    }
}

