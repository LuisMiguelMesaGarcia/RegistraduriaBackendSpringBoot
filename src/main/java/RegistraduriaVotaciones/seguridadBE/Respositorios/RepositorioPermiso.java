package RegistraduriaVotaciones.seguridadBE.Respositorios;
import RegistraduriaVotaciones.seguridadBE.Modelo.Permiso;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RepositorioPermiso extends MongoRepository<Permiso, String> {
}
