package RegistraduriaVotaciones.seguridadBE.Respositorios;
import RegistraduriaVotaciones.seguridadBE.Modelo.Rol;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RepositorioRol extends MongoRepository<Rol,String> {
}
