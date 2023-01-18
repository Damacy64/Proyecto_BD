package banco.modelo;

import java.math.BigDecimal;

/**
 *
 * @author pzx64
 */
public class Cuenta {
    private int no_cuenta;
    private String tipo;
    private BigDecimal saldo;
    private String rfc;

    public Cuenta() {
    }

    public Cuenta(int no_cuenta, String tipo, BigDecimal saldo, String rfc) {
        this.no_cuenta = no_cuenta;
        this.tipo = tipo;
        this.saldo = saldo;
        this.rfc = rfc;
    }

    public int getNo_cuenta() {
        return no_cuenta;
    }

    public String getTipo() {
        return tipo;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public String getRfc() {
        return rfc;
    }

    public void setNo_cuenta(int no_cuenta) {
        this.no_cuenta = no_cuenta;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }
    
    
}
