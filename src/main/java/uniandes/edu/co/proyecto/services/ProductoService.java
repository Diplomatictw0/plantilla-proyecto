package uniandes.edu.co.proyecto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uniandes.edu.co.proyecto.entity.CategoriaProducto;
import uniandes.edu.co.proyecto.entity.Producto;
import uniandes.edu.co.proyecto.exeptions.ResourceNotFoundException;
import uniandes.edu.co.proyecto.repositories.CategoriaProductoRepository;
import uniandes.edu.co.proyecto.repositories.ProductoRepository;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private CategoriaProductoRepository categoriaProductoRepository;

    // Crear producto
    public Producto crearProducto(Producto producto, Long categoriaId) {
        CategoriaProducto categoria = categoriaProductoRepository.findById(categoriaId)
            .orElseThrow(() -> new ResourceNotFoundException("Categoría no encontrada con id: " + categoriaId));
        producto.setCategoriaProducto(categoria);
        return productoRepository.save(producto);
    }

    // Leer producto por ID
    public Producto leerProducto(Long id) {
        return productoRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado con id: " + id));
    }

    // Actualizar producto
    public Producto actualizarProducto(Long id, Producto productoActualizado) {
        Producto producto = productoRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado con id: " + id));
        
        producto.setNombre(productoActualizado.getNombre());
        producto.setCostoBodega(productoActualizado.getCostoBodega());
        producto.setPrecioUnitario(productoActualizado.getPrecioUnitario());
        producto.setPresentacion(productoActualizado.getPresentacion());
        producto.setCantidadPresentacion(productoActualizado.getCantidadPresentacion());
        producto.setUnidadMedida(productoActualizado.getUnidadMedida());
        producto.setVolumenEmpaque(productoActualizado.getVolumenEmpaque());
        producto.setPesoEmpaque(productoActualizado.getPesoEmpaque());
        producto.setFechaExpiracion(productoActualizado.getFechaExpiracion());
        producto.setCodigoBarras(productoActualizado.getCodigoBarras());

        return productoRepository.save(producto);
    }
}

