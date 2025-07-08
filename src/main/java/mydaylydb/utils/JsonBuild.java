package mydaylydb.utils;

import java.util.List;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

public class JsonBuild {

    public static JsonObject Built(List data) {
        // Crear un JsonObjectBuilder
        JsonObjectBuilder jsonBuilder = Json.createObjectBuilder();

        // Agregar pares clave-valor al JsonObjectBuilder
        jsonBuilder.add("nombre", "Juan");
        jsonBuilder.add("apellido", "Parez");
        jsonBuilder.add("edad", 30);

        // Construir el JsonObject
        JsonObject jsonObject = jsonBuilder.build();
        
        return jsonObject;
        // Imprimir el JsonObject como una cadena
        //System.out.println(jsonObject.toString());
    }
}
