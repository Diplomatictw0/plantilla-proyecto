package uniandes.edu.co.proyecto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uniandes.edu.co.proyecto.entity.Proveedor;
import uniandes.edu.co.proyecto.exeptions.ResourceNotFoundException;
import uniandes.edu.co.proyecto.repositories.ProveedorRepository;

@Service
public class ProveedorService {

    @Autowired
    private ProveedorRepository proveedorRepository;

    // Crear un nuevo proveedor
    public Proveedor crearProveedor(Proveedor proveedor) {
        return proveedorRepository.save(proveedor);
    }

    // Actualizar un proveedor existente
    public Proveedor actualizarProveedor(Long id, Proveedor proveedorActualizado) {
        Proveedor proveedor = proveedorRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Proveedor no encontrado con id: " + id));
        
        proveedor.setNombre(proveedorActualizado.getNombre());
        proveedor.setTelefonoContacto(proveedorActualizado.getTelefonoContacto());
        proveedor.setNombreContacto(proveedorActualizado.getNombreContacto());
        proveedor.setDireccion(proveedorActualizado.getDireccion());
        proveedor.setNit(proveedorActualizado.getNit());

        return proveedorRepository.save(proveedor);
    }
}
