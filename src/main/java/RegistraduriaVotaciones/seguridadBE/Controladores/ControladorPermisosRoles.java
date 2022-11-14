package RegistraduriaVotaciones.seguridadBE.Controladores;

import RegistraduriaVotaciones.seguridadBE.Modelo.PermisosRoles;
import RegistraduriaVotaciones.seguridadBE.Modelo.Rol;
import RegistraduriaVotaciones.seguridadBE.Modelo.Permiso;
import RegistraduriaVotaciones.seguridadBE.Respositorios.RepositorioPermiso;
import RegistraduriaVotaciones.seguridadBE.Respositorios.RepositorioPermisosRoles;
import RegistraduriaVotaciones.seguridadBE.Respositorios.RepositorioRol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/permisos-roles")
public class ControladorPermisosRoles {
    @Autowired
    private RepositorioPermisosRoles miRepositorioPermisosRoles;
    @Autowired
    private RepositorioRol miRepositorioRol;
    @Autowired
    private RepositorioPermiso miRepositorioPermiso;

    @GetMapping("")
    public List<PermisosRoles> index(){
        return this.miRepositorioPermisosRoles.findAll();
    }
    /** asignar rol y permisos */
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("rol/{id_rol}/permiso/{id_permiso}")
    public PermisosRoles create(@PathVariable String id_rol,@PathVariable String id_permiso){
        PermisosRoles unPermisosRoles = new PermisosRoles();
        Rol unRol = this.miRepositorioRol.findById(id_rol).orElse(null);
        Permiso unPermiso = this.miRepositorioPermiso.findById(id_permiso).orElse(null);
        if(unRol != null && unPermiso != null){
            unPermisosRoles.setRol(unRol);
            unPermisosRoles.setPermiso(unPermiso);
            return this.miRepositorioPermisosRoles.save(unPermisosRoles);
        }else{
            return null;
        }
    }

    @GetMapping("{id}")
    public PermisosRoles show(@PathVariable String id){
        PermisosRoles unPermisosRoles = this.miRepositorioPermisosRoles
                .findById(id)
                .orElse(null);
        return unPermisosRoles;
    }

    @PutMapping("{id}/rol/{id_rol}/permiso/{id_permiso}")
    public PermisosRoles update(@PathVariable String id, @PathVariable String id_rol, @PathVariable String id_permiso){
        PermisosRoles permisosRolesActual = this.miRepositorioPermisosRoles.findById(id).orElse(null);
        Rol unRol = this.miRepositorioRol.findById(id_rol).orElse(null);
        Permiso unPermiso = this.miRepositorioPermiso.findById(id_permiso).orElse(null);
        if(unRol != null && unPermiso != null){
            permisosRolesActual.setRol(unRol);
            permisosRolesActual.setPermiso(unPermiso);
            return this.miRepositorioPermisosRoles.save(permisosRolesActual);
        }else{
            return null;
        }
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void delete(@PathVariable String id){
        PermisosRoles unPermisosRoles = this.miRepositorioPermisosRoles.findById(id).orElse(null);
        if(unPermisosRoles != null){
            this.miRepositorioPermisosRoles.delete(unPermisosRoles);
        }
    }

}
