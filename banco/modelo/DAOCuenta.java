package banco.modelo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author pzx64
 */
public class DAOCuenta {

    public int nuevoRegistro(String tipo, double saldo, String rfc) {
        String consulta = "INSERT INTO Cuenta (tipo, saldo, rfc)"
                + "VALUES ('"
                + tipo + "', "
                + saldo + ", '"
                + rfc + "')";
        return new Database().actualizar(consulta);
    }

    public int nuevoRegistro(String rfc, String nombre, String ciudad, String tipo, double monto) {
        String consulta = "sp_crearCuenta('"
                + rfc + "' , '"
                + nombre + "', '"
                + ciudad + "' , '"
                + tipo + "','"
                + monto + ")";
        return new Database().invocarProcedimiento(consulta);
    }

    public int modificarRegistro(int no_cuenta, String tipo) {
        String consulta = "UPDATE Cuenta set tipo='"
                + tipo + "' WHERE no_cuenta=" + no_cuenta;

        return new Database().actualizar(consulta);
    }

    public int eliminarRegistro(int no_cuenta) {
        String consulta = "DELETE FROM Cuenta WHERE no_cuenta=" + no_cuenta;

        return new Database().actualizar(consulta);
    }

    public List<Cuenta> registros() {
        String consulta = "SELECT * FROM Cuenta";
        List<Map> registros = new Database().ejecutar(consulta);

        List<Cuenta> cuentas = new ArrayList();
        for (Map renglon : registros) {
            Cuenta ct = new Cuenta((Integer) renglon.get("no_cuenta"),
                    (String) renglon.get("tipo"),
                    (BigDecimal) renglon.get("saldo"),
                    (String) renglon.get("rfc"));
            cuentas.add(ct);
        }
        return cuentas;
    }

    public List<Cuenta> registros(String rfc) {
        String consulta = "SELECT * FROM Cuenta WHERE rfc='" + rfc + "'";
        List<Map> registros = new Database().ejecutar(consulta);

        List<Cuenta> cuentas = new ArrayList();
        for (Map renglon : registros) {
            Cuenta ct = new Cuenta((Integer) renglon.get("no_cuenta"),
                    (String) renglon.get("tipo"),
                    (BigDecimal) renglon.get("saldo"),
                    (String) renglon.get("rfc"));
            cuentas.add(ct);
        }
        return cuentas;
    }

    public Cuenta registro(int no_cuenta) {
        String consulta = "SELECT * FROM Cuenta WHERE no_cuenta=" + no_cuenta;
        List<Map> registros = new Database().ejecutar(consulta);
        Map renglon = registros.get(0);
        Cuenta ct = new Cuenta((Integer) renglon.get("no_cuenta"),
                (String) renglon.get("tipo"),
                (BigDecimal) renglon.get("saldo"),
                (String) renglon.get("rfc"));
        return ct;
    }

    public int depositar(int no_cuenta, double monto) {
        String consulta = "sp_movimiento("
                + no_cuenta + ","
                + monto + ")";

        return new Database().invocarProcedimiento(consulta);
    }

    public int retirar(int no_cuenta, double monto) {
        monto = monto * -1;
        String consulta = "sp_movimiento("
                + no_cuenta + ","
                + monto + ")";

        return new Database().invocarProcedimiento(consulta);
    }

    public int transferir(int origen, int destino, double monto) {
        String consulta = "sp_transferir("
                + origen + ","
                + destino + ","
                + monto + ")";
        return new Database().invocarProcedimiento(consulta);
    }
}
