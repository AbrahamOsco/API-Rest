package com.aninfo.repository;

import com.aninfo.model.Transaccion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface TransaccionRepository extends CrudRepository<Transaccion, Long> {

    Transaccion findByIdTransaccion(Long idTransaccion);

    //Como CBU no es la clave primara para la entidad entonces seguimos convecnion de spring findByNombreCampo.
    // es como sql escribimos el metodo y Spring implementa el metodo en tiempo de ejecución.
    List<Transaccion> findByCbu(Long cbu);

    @Override
    List<Transaccion> findAll();

}
