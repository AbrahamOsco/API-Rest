package com.aninfo.service;

import com.aninfo.exceptions.InvalidTransactionTypeException;
import com.aninfo.exceptions.NotFoundCBUExcepction;
import com.aninfo.model.Transaccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import com.aninfo.repository.TransaccionRepository;

@Service
public class TransaccionService {
    @Autowired
    public TransaccionRepository transaccionRepository;

    public Transaccion crearTransaccion(Transaccion transaccion, AccountService accountService){

        if(transaccion.getTipoTransaccion().equals("Deposito")){
            accountService.deposit(transaccion.getCbu(), transaccion.getValor());
        }
        else if ( transaccion.getTipoTransaccion().equals("Extraccion") ){
            accountService.withdraw(transaccion.getCbu(), transaccion.getValor());
        }
        else{
            throw new InvalidTransactionTypeException("Error Tipo de operacion no valida" +
                    "Use las operaciones: Deposito o Extraccion.");
        }
        return transaccionRepository.save(transaccion);
    }


    public Collection<Transaccion> getTransacciones(){
        return transaccionRepository.findAll();
    }

    public Optional<Transaccion> findByIdTransaccion(Long idTransaccion ){
        return Optional.ofNullable( transaccionRepository.findByIdTransaccion(idTransaccion) );
    }

    public List<Transaccion> findByCbu(Long cbu){
        List<Transaccion> listaTransacciones =  transaccionRepository.findByCbu(cbu);
        if( listaTransacciones.size() == 0 ) {
            throw new NotFoundCBUExcepction("Error CBU de la cuenta no existe ");
        }
        return listaTransacciones;
    }

    public void save(Transaccion unaTransaccion){
        transaccionRepository.save(unaTransaccion);
    }

    public void deleteByIdTransaccion(Long idTransaccion) {
        transaccionRepository.deleteById(idTransaccion);
    }


}