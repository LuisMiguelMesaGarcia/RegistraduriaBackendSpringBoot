package RegistraduriaVotaciones.seguridadBE.Modelo;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document()
public class Usuario {
    @Id
    private String _id;
    private String seudonimo;
    private String correo;
    private String contraseña;
    @DBRef
    private Rol rol;

    public Usuario(String seudonimo, String correo, String contraseña) {
        this.seudonimo = seudonimo;
        this.correo = correo;
        this.contraseña = contraseña;
    }

    public String get_id() {
        return _id;
    }

    public String getSeudonimo() {
        return seudonimo;
    }

    public void setSeudonimo(String seudonimo) {
        this.seudonimo = seudonimo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public Rol getRol() {
        return rol;
    }
    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}
