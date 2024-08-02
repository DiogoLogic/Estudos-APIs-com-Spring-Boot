package br.com.api.api.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import br.com.api.api.model.Pessoa;

@Repository
public interface Repositor extends CrudRepository<Pessoa, Long>{

 
    @SuppressWarnings("null")
    List<Pessoa> findAll();

   Pessoa findByCodigo(Long codigo);

   List<Pessoa> findByOrderByNomeAsc();

   List<Pessoa> findByNomeOrderByIdadeDesc(String nome);

   List<Pessoa> findByNomeContaining(String termo);

   List<Pessoa> findByNomeStartingWith(String termo);

   List<Pessoa> findByNomeEndingWith(String Termo);

   @Query(value = "SELECT SUM(idade) FROM pessoas", nativeQuery = true)
   int somaIdades();

   @Query(value = "SELECT * FROM pessoas WHERE idade >= :idade", nativeQuery = true)
    List<Pessoa> idadeMaiorIgual( int idade);

    int countByCodigo(Long codigo);

    //int deledeleteByCodigo(Long codigo);
}
