import java.util.ArrayList;
import java.util.List;

public class Comercio {

    String razonSocial;
    List<Producto> productos;

    public Comercio(String razonSocial) {
        this.razonSocial = razonSocial;
        this.productos = new ArrayList<>();
    }

    public void agregarProducto(Producto producto){
        productos.add(producto);
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public List<Producto> getProductos() {
        return productos;
    }

}
