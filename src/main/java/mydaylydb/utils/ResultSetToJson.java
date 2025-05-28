package mydaylydb.utils;

import org.json.JSONArray;
import org.json.JSONObject;
import java.sql.*;

public class ResultSetToJson {

    public static JSONArray convert(ResultSet rs) throws SQLException {
        JSONArray jsonArray = new JSONArray();
        ResultSetMetaData metaData = rs.getMetaData();
        int columnas = metaData.getColumnCount();

        while (rs.next()) {
            JSONObject obj = new JSONObject();
            for (int i = 1; i <= columnas; i++) {
                String nombreColumna = metaData.getColumnLabel(i); // o getColumnName(i)
                Object valor = rs.getObject(i);
                obj.put(nombreColumna, valor);
            }
            jsonArray.put(obj);
        }

        return jsonArray;
    }
}
