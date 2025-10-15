package br.com.luanlana.academico.repository;

import br.com.luanlana.academico.model.Aluno;
import org.springframework.stereotype.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {

}