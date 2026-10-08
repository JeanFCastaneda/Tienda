package co.edu.uniquindio.poo.model;

import java.time.LocalDate;
import java.util.ArrayList;

public record Factura(String codigo, LocalDate fecha, double total,
                      EstadoFactura estadoFactura, MetodoPago metodoPago, Cliente cliente,
                      ArrayList<DetalleFactura> listaDetallesFactura, Tienda ownedByTienda) {

}

public void crearFactura(Factura factura) {
    facturas.add(factura);
}
public Optional<Factura> buscarFactura(int id) {
    return facturas.stream()
            .filter(f -> f.id() == id)
            .findFirst();
}
public boolean actualizarFactura(int id, Factura nuevaFactura) {
    Optional<Factura> factura = buscarFactura(id);

    if (factura.isPresent()) {
        int posicion = facturas.indexOf(factura.get());
        facturas.set(posicion, nuevaFactura);
        return true;
    }

    return false;
}
public boolean eliminarFactura(int id) {
    Optional<Factura> factura = buscarFactura(id);

    if (factura.isPresent()) {
        facturas.remove(factura.get());
        return true;
    }

    return false;
}
public float calcularSubTotal(){
    return (float) (cantidadComprada*getProducto().getValor());
}