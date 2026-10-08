package co.edu.uniquindio.poo.model;

import java.util.*;

public class Tienda {

    private final String nombre;
    private final String nit;
    private String telefono;

    private final ArrayList<Cliente> listaClientes = new ArrayList<>();
    private final List<Factura> listaFacturas = new LinkedList<>();
    private Map<String, Producto> hashMaplistaProductos = new HashMap<>();


    public Tienda(String nombre, String nit, String telefono) {
        this.nombre = nombre;
        this.nit = nit;
        this.telefono = telefono;
    }

    // setters y getters

    public String getNombre() {
        return nombre;
    }

    public String getNit() {
        return nit;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String registrarCliente(Cliente cliente) {
        Cliente clienteEncontrado = buscarCliente(cliente.getDocumentoIdentidad());
        if (clienteEncontrado == null) {
            listaClientes.add(cliente);
            return "El cliente fue registrado exitosamente";
        } else return "No se puede registrar, ya existe un cliente con esa informacion registrado anteriormente.";
    }

    // Cambiar if(clienteEncontrado == null){ por un Optional
    // hacer el metodo buscar cliente usando un optional
    public boolean agregarProducto(Producto producto) {
        if (listaProductos.containsKey(producto.getCodigo())) {
            return false;
        }
        listaProductos.put(producto.getCodigo(), producto);
        return true;
    }

    public Producto buscarProducto(String codigo) {
        return listaProductos.get(codigo);
    }

    public Collection<Producto> obtenerProductos() {
        return listaProductos.values();
    }

    public boolean actualizarProducto(String codigo, Producto datosNuevos) {
        if (listaProductos.containsKey(codigo)) {
            listaProductos.put(codigo, datosNuevos);
            return true;
        }
        return false;
    }

    public boolean eliminarProducto(String codigo) {
        return listaProductos.remove(codigo) != null;
    }

    public boolean agregarCliente(Cliente cliente) {
        if (buscarCliente(cliente.getDocumentoIdentidad()) != null) {
            return false;
        }
        return listaClientes.add(cliente);
    }

    public Cliente buscarCliente(String documentoIdentidad) {
        for (Cliente c : listaClientes) {
            if (c.getDocumentoIdentidad().equalsIgnoreCase(documentoIdentidad)) {
                return c;
            }
        }
        return null;
    }

    public ArrayList<Cliente> obtenerClientes() {
        return listaClientes;
    }

    public boolean actualizarCliente(String id, Cliente datosNuevos) {
        Cliente c = buscarCliente(id);
        if (c != null) {
            int posicion = listaClientes.indexOf(c);
            listaClientes.set(posicion, datosNuevos);
            return true;
        }
        return false;
    }

    public boolean eliminarCliente(String documentoIdentidad) {
        Cliente c = buscarCliente(documentoIdentidad);
        return c != null && listaClientes.remove(c);
    }

    public boolean agregarFactura(Factura nuevaFactura) {
        for (Factura f : listaFacturas) {
            if (f.codigo().equalsIgnoreCase(nuevaFactura.codigo())) {
                return false;
            }
        }
        return listaFacturas.add(nuevaFactura);
    }

    public Factura buscarFactura(String codigo) {
        for (Factura f : listaFacturas) {
            if (f.codigo().equalsIgnoreCase(codigo)) {
                return f;
            }
        }
        return null;
    }

    public boolean eliminarFactura(String codigo) {
        Factura f = buscarFactura(codigo);
        if (f != null) {
            return listaFacturas.remove(f);
        }
        return false;
    }

    public Optional<Cliente> buscarCliente(String documentoIdentidad) {
        return listaClientes.stream()
                .filter(cliente -> cliente.getDocumentoIdentidad().equalsIgnoreCase(documentoIdentidad))
                .findFirst();
    }

    Optional<Cliente> clienteEncontrado = buscarCliente(documentoIdentidad);


if(clienteEncontrado.isEmpty())

}
//punto 1
public List<Producto> obtenerProductosCantidadMayorA10() {
    List<Producto> productosDisponibles = new ArrayList<>();
    for (Producto producto : hashMaplistaProductos.values()) {
        if (producto.getCantidadDisponible() >= 10) {
            productosDisponibles.add(producto);
        }
    }
    return productosDisponibles;
}

}

