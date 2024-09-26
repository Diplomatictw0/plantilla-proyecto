package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import uniandes.edu.co.proyecto.entity.Producto;
import uniandes.edu.co.proyecto.services.ProductoService;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    // Crear producto
    @PostMapping("/crear")
    public ResponseEntity<Producto> crearProducto(@RequestBody Producto producto, @RequestParam Long categoriaId) {
        Producto nuevoProducto = productoService.crearProducto(producto, categoriaId);
        return new ResponseEntity<>(nuevoProducto, HttpStatus.CREATED);
    }

    // Leer producto por ID
    @GetMapping("/leer/{id}")
    public ResponseEntity<Producto> leerProducto(@PathVariable Long id) {
        Producto producto = productoService.leerProducto(id);
        return new ResponseEntity<>(producto, HttpStatus.OK);
    }

    // Actualizar producto
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Producto> actualizarProducto(@PathVariable Long id, @RequestBody Producto productoActualizado) {
        Producto producto = productoService.actualizarProducto(id, productoActualizado);
        return new ResponseEntity<>(producto, HttpStatus.OK);
    }
}
