package co.edu.uniquindio.poo.model;

import java.time.LocalDate;
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

    public Map<String, Producto> getHashMaplistaProductos() {
        return hashMaplistaProductos;
    }

    public void setHashMaplistaProductos(Map<String, Producto> hashMaplistaProductos) {
        this.hashMaplistaProductos = hashMaplistaProductos;
    }


if(clienteEncontrado.isEmpty())


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

    public List<Producto> obtenerProductosCantidadMayorA10YMenorA50() {
        List<Producto> productosDisponibles = new ArrayList<>();
        for (Producto producto : hashMaplistaProductos.values()) {
            if (producto.getCantidadDisponible() >= 10 && < 50) {
                productosDisponibles.add(producto);
            }
        }
        return productosDisponibles;
    }
//punto3
    public ArrayList<Cliente> clientesEnXFecha (){
    ArrayList<Cliente>listaClientes = new ArrayList<>();
    LocalDate fechaA = LocalDate.of(2026,10,7)
    if ((fechaA).isEqual())
        for(Factura factura : listafacturas){
            if(factura.fecha().isEqual(fechaA)){
                listaClientes.add(factura.cliente());
            }
        }

    return listaClientes;
    }
    public ArrayList<Cliente> clientesEnXFecha2 (){
        ArrayList<Cliente>listaClientes = new ArrayList<>();
      for(Cliente cliente : listaClientes){
          if(clienteAux.esCompraEnFecha(fechaA))
      }

        return listaClientes;
    }
//punto 4
    public ArrayList<Factura> obtenerFacturasConR (){
    ArrayList<Cliente>listaClientes = new ArrayList<>();
    for(Cliente cliente : listaClientes){
        if(cliente.)
    }
    import java.util.ArrayList;
import java.util.List;

        public List<Factura> obtenerFacturasClientesConR(List<Factura> listaFacturas) {
            List<Factura> resultado = new ArrayList<>();

            for (Factura factura : listaFacturas) {
                String nombre = factura.getCliente().getNombre();

                // Verifica que no sea nulo y que empiece con 'R' o 'r'
                if (factura.tieneClienteConR() {
                    resultado.add(factura);
                }
            }

            return resultado;
        }
    }
}
