package RegistraduriaVotaciones.seguridadBE.Modelo;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class PermisosRoles {
    @Id
    private String _id;
    @DBRef
    private Rol rol;
    @DBRef
    private Permiso permiso;

    public PermisosRoles() {
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Permiso getPermiso() {
        return permiso;
    }

    public void setPermiso(Permiso permiso) {
        this.permiso = permiso;
    }
}
