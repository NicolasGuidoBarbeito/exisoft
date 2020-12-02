import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args){

        LectorCSV lectorCSV = new LectorCSV();

        ArrayList<String> datosArchivoCSV = lectorCSV.leerArchivoCSVdesde("C:\\preciosCSV.csv");

        Builder builder = new Builder();

        List<Comercio> comercios = builder.instanciarComerciosSAPartirDe(datosArchivoCSV);
        List<Producto> productos = builder.instanciarProductosAPartirDe(datosArchivoCSV, comercios);

        List<Producto> productosOrdenados = productosOrdenadosPorComercio(productos);

        Producto productoConPrecioMasBajo = precioMasBajoDe(productos.get(0), productos);

        precioMasAltoDe(productos.get(0), productos);

        mejorPrecioEnComercio(comercios.get(0));

        cantidadDeProductosEnVenta(comercios.get(0));

        }

        static List<Producto> productosOrdenadosPorComercio(List<Producto> productos) {

            for (int i = 0; i < productos.size(); i++) {

                Producto producto = productos.get(i);

                if (i + 1 < productos.size() && producto.getPrecio() <= productos.get(i + 1).getPrecio()) {
                    productos.add(i, productos.get(i + 1));
                    productos.remove(i + 2);
                }

                if (i - 1 >= 0 && producto.getPrecio() >= productos.get(i - 1).getPrecio()) {
                    productos.add(i, productos.get(i - 1));
                    productos.remove(i - 2);
                }
            }
            return productos;
        }

        static Producto precioMasBajoDe(Producto producto, List<Producto> productos){

        Producto productoConPrecioMasBajo = null;

        for(int i = 0; i < productos.size(); i++){
                Producto productoEnIndice = productos.get(i);

                if(sonProductosIguales(productoEnIndice, producto)){
                    if(productoEnIndice.getPrecio() <= producto.getPrecio()){
                        productoConPrecioMasBajo = productoEnIndice;
                    } else {
                        productoConPrecioMasBajo = producto;
                    }
                }
        }
        System.out.print("Local que tiene producto con precio mas bajo:");
        System.out.print(productoConPrecioMasBajo.getComercio());
        return productoConPrecioMasBajo;
    }

        static boolean sonProductosIguales(Producto producto, Producto otroProducto){
            return producto. getDescripcion().equals(otroProducto.getDescripcion());
        }

    static boolean esProductoConPromocion(Producto producto){
        return producto.isPromocion();
    }


    static void precioMasAltoDe(Producto producto, List<Producto> productos){

        Producto productoConPrecioMasAltoConPromocion = null;
        Producto productoConPrecioMasAltoSinPromocion = null;

        int contadorDeLocalesConPromocion = 0;
        int contadorDeLocalesSinPromocion = 0;

        for(int i = 0; i < productos.size(); i++){
                Producto productoEnIndice = productos.get(i);

                if(sonProductosIguales(productoEnIndice, producto) && esProductoConPromocion(productoEnIndice) && esProductoConPromocion(producto)){
                    if(productoEnIndice.getPrecio() > producto.getPrecio()){
                        productoConPrecioMasAltoConPromocion = productoEnIndice;
                    } if(productoEnIndice.getPrecio() == producto.getPrecio()){
                        contadorDeLocalesConPromocion++;
                    }
                    else {
                        productoConPrecioMasAltoConPromocion = producto;
                    }
                }

                if(sonProductosIguales(productoEnIndice, producto) && !esProductoConPromocion(productoEnIndice) && !esProductoConPromocion(producto)){
                    if(productoEnIndice.getPrecio() > producto.getPrecio()){
                        productoConPrecioMasAltoSinPromocion = productoEnIndice;
                    } if(productoEnIndice.getPrecio() == producto.getPrecio()){
                        contadorDeLocalesSinPromocion++;
                    }
                    else {
                        productoConPrecioMasAltoSinPromocion = producto;
                    }
                }
        }
        System.out.print("Local que tiene producto con precio mas alto con promoción:");
        System.out.print(productoConPrecioMasAltoConPromocion.getComercio());
        System.out.print("Cantidad de locales con este precio:");
        System.out.print(contadorDeLocalesConPromocion);

        System.out.print("Local que tiene producto con precio mas alto sin promoción:");
        System.out.print(productoConPrecioMasAltoSinPromocion.getComercio());
        System.out.print("Cantidad de locales con este precio:");
        System.out.print(contadorDeLocalesSinPromocion);
    }

    static Producto mejorPrecioEnComercio(Comercio comercio){

        Producto productoConPrecioMasBajo = null;

        for(int i = 0; i < comercio.getProductos().size(); i++){
            if(i + 1 < comercio.getProductos().size()){
                Producto productoEnIndice = comercio.getProductos().get(i);
                Producto productoSiguiente = comercio.getProductos().get(i + 1);

                if(sonProductosIguales(productoEnIndice, productoSiguiente)){
                    if(productoEnIndice.getPrecio() <= productoSiguiente.getPrecio()){
                        productoConPrecioMasBajo = productoEnIndice;
                    } else {
                        productoConPrecioMasBajo = productoSiguiente;
                    }
                }
            }
        }
        System.out.print("Producto con mejor precio:");
        System.out.print(productoConPrecioMasBajo.getDescripcion());
        return productoConPrecioMasBajo;
    }

    float precioPromedioConPromocion(Producto producto, List<Producto> productos){

        int cantidadDeProductosIguales = 0;
        float sumatoriaDePrecios = 0;

        for(int i = 0; i < productos.size(); i++){
            Producto productoEnIndice = productos.get(i);

            if(sonProductosIguales(productoEnIndice, producto) && esProductoConPromocion(productoEnIndice) && esProductoConPromocion(producto)){
                sumatoriaDePrecios = sumatoriaDePrecios + producto.getPrecio() + productoEnIndice.getPrecio();
                cantidadDeProductosIguales++;
            }
        }
        return sumatoriaDePrecios / cantidadDeProductosIguales;
    }

    float precioPromedioSinPromocion(Producto producto, List<Producto> productos){

        int cantidadDeProductosIguales = 0;
        float sumatoriaDePrecios = 0;

        for(int i = 0; i < productos.size(); i++){
            Producto productoEnIndice = productos.get(i);

            if(sonProductosIguales(productoEnIndice, producto) && !esProductoConPromocion(productoEnIndice) && !esProductoConPromocion(producto)){
                sumatoriaDePrecios = sumatoriaDePrecios + producto.getPrecio() + productoEnIndice.getPrecio();
                cantidadDeProductosIguales++;
            }
        }
        return sumatoriaDePrecios / cantidadDeProductosIguales;
    }

    static int cantidadDeProductosEnVenta(Comercio comercio){
        return comercio.getProductos().size();
    }
}