package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import uniandes.edu.co.proyecto.entity.CategoriaProducto;
import uniandes.edu.co.proyecto.services.CategoriaProductoService;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaProductoController {

    @Autowired
    private CategoriaProductoService categoriaProductoService;

    // Crear categoría
    @PostMapping("/crear")
    public ResponseEntity<CategoriaProducto> crearCategoria(@RequestBody CategoriaProducto categoria) {
        CategoriaProducto nuevaCategoria = categoriaProductoService.crearCategoria(categoria);
        return new ResponseEntity<>(nuevaCategoria, HttpStatus.CREATED);
    }

    // Leer categoría por ID
    @GetMapping("/leer/{id}")
    public ResponseEntity<CategoriaProducto> leerCategoriaPorId(@PathVariable Long id) {
        CategoriaProducto categoria = categoriaProductoService.leerCategoriaPorId(id);
        return new ResponseEntity<>(categoria, HttpStatus.OK);
    }

    // Leer categoría por nombre
    @GetMapping("/leerPorNombre")
    public ResponseEntity<CategoriaProducto> leerCategoriaPorNombre(@RequestParam String nombre) {
        CategoriaProducto categoria = categoriaProductoService.leerCategoriaPorNombre(nombre);
        return new ResponseEntity<>(categoria, HttpStatus.OK);
    }
}
