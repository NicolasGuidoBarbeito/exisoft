import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

public class LectorCSV {

    public ArrayList<String> leerArchivoCSVdesde(String ruta){

        Path filePath = Paths.get(ruta);
        String[] datosDeLinea;
        ArrayList<String> datosArchivo = new ArrayList<>();
        try {

            BufferedReader br = Files.newBufferedReader(filePath);
            String linea;

            while((linea = br.readLine()) != null){
                datosDeLinea = linea.split(",");

                datosArchivo.addAll(Arrays.asList(datosDeLinea));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return datosArchivo;
    }
}
