package banco.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author pzx64
 */
public class DAOCliente {

    public int nuevoRegistro(String rfc, String nombre, String ciudad) {
        String consulta = "INSERT INTO Cliente VALUES ('"
                + rfc + "', '"
                + nombre + "', '"
                + ciudad + "')";
        Database db = new Database();
        return db.actualizar(consulta);
    }

    public int modificarRegistro(String rfc, String nombre, String ciudad) {
        String consulta = "UOADATE cliente SET nombre='"
                + nombre + "', ciudad='"
                + ciudad + "',WHERE rfc='"
                + rfc + "'";

        Database db = new Database();
        return db.actualizar(consulta);
    }

    public int eliminarRegistro(String rfc) {
        String consulta = "DELETE FROM cliente WHERE rfc ='"
                + rfc + "'";

        Database db = new Database();
        return db.actualizar(consulta);
    }

    public List registros() {
        String consultas = "Select * from cliente";
        Database db = new Database();
        List<Map> renglones = db.ejecutar(consultas);

        List clientes = new ArrayList();
        for (Map renglon : renglones) {
            Cliente clt = new Cliente((String) renglon.get("rfc"),
                    (String) renglon.get("nombre"),
                    (String) renglon.get("ciudad"));
            clientes.add(clt);
        }
        return clientes;
    }
}
