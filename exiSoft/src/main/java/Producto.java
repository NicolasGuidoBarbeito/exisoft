public class Producto {

    int id;
    String descripcion;
    float precio;
    String comercio;
    boolean promocion;

    public Producto(int id, String descripcion, float precio, String comercio, boolean promocion) {
        this.id = id;
        this.descripcion = descripcion;
        this.precio = precio;
        this.promocion = promocion;
        this.comercio = comercio;
    }

    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public float getPrecio() {
        return precio;
    }

    public boolean isPromocion() {
        return promocion;
    }

    public String getComercio() {
        return comercio;
    }
}
