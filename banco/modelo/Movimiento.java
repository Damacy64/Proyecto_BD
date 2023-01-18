package banco.modelo;

import java.sql.Date;

/**
 *
 * @author pzx64
 */
public class Movimiento {
    private int id_movimiento;
    private Date fecha;
    private double monto;
    private int no_cuenta;

    public Movimiento() {
    }

    public Movimiento(int id_movimiento, Date fecha, double monto, int no_cuenta) {
        this.id_movimiento = id_movimiento;
        this.fecha = fecha;
        this.monto = monto;
        this.no_cuenta = no_cuenta;
    }

    public int getId_movimiento() {
        return id_movimiento;
    }

    public Date getFecha() {
        return fecha;
    }

    public double getMonto() {
        return monto;
    }

    public int getNo_cuenta() {
        return no_cuenta;
    }

    public void setId_movimiento(int id_movimiento) {
        this.id_movimiento = id_movimiento;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public void setNo_cuenta(int no_cuenta) {
        this.no_cuenta = no_cuenta;
    }
    
    
}
