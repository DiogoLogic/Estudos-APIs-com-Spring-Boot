package br.com.api.api.repository;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.api.api.model.Pessoa;

@Repository
public interface Repositor extends CrudRepository<Pessoa, Long>{

 
    @SuppressWarnings("null")
    List<Pessoa> findAll();

   Pessoa findByCodigo(Long codigo);

   List<Pessoa> findByOrderByNomeAsc();

   List<Pessoa> findByNomeOrderByidadeDesc();

}
