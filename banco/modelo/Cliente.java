package banco.modelo;

/**
 *
 * @author pzx64
 */
public class Cliente {
    private String rfc;
    private String nombre;
    private String ciudad;

    public Cliente() {
    }

    public Cliente(String rfc, String nombre, String ciudad) {
        this.rfc = rfc;
        this.nombre = nombre;
        this.ciudad = ciudad;
    }

    public String getRfc() {
        return rfc;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    
    
}
