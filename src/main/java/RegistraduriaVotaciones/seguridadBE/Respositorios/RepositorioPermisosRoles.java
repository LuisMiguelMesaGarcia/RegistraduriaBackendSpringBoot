package RegistraduriaVotaciones.seguridadBE.Respositorios;

import RegistraduriaVotaciones.seguridadBE.Modelo.PermisosRoles;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RepositorioPermisosRoles extends MongoRepository<PermisosRoles,String> {

}
