import java.util.ArrayList;
import java.util.List;

public class Builder {

    List<Comercio> instanciarComerciosSAPartirDe(ArrayList<String> datos){

        List<Comercio> comercios = new ArrayList<>();

        for(int i = 0; i + 4 < datos.size(); i = i + 5){

            String descripcion = datos.get(i + 3);

            for(Comercio comercioDeLista : comercios){
                if(comercioDeLista.getRazonSocial().equals(descripcion)){
                    break;
                }
            }
            Comercio comercio = new Comercio(descripcion);
            comercios.add(comercio);
        }
        return comercios;
    }

    List<Producto> instanciarProductosAPartirDe(ArrayList<String> datos, List<Comercio> comercios){

        List<Producto> productos = new ArrayList<>();

        for(int i = 0; i + 4 < datos.size(); i = i + 5){

            String idProducto = datos.get(i);
            String descripcionProducto = datos.get(i + 1);
            String precioProducto = datos.get(i + 2);
            String comercio = datos.get(i + 3);
            String promocionProducto = datos.get(i + 4);
            boolean promocion = false;

            if(promocionProducto.equals("Si")){
                promocion = true;
            }

            Producto producto = new Producto(Integer.parseInt(idProducto), descripcionProducto, Float.parseFloat(precioProducto), comercio, promocion);
            actualizarProductosDeComercio(comercios,comercio, producto);
            productos.add(producto);
        }
        return productos;
    }

    public void actualizarProductosDeComercio(List<Comercio> comercios, String comercio, Producto producto){

        for(Comercio comercioDeLista: comercios){
            if(comercioDeLista.getRazonSocial().equals(comercio)){
                comercioDeLista.agregarProducto(producto);
            }
        }
    }
}
