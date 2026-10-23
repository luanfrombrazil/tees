package br.com.luanlana.academico.controller;


import br.com.luanlana.academico.model.Aluno;
import br.com.luanlana.academico.repository.AlunoRepository;
import br.com.luanlana.academico.service.AlunoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/aluno")
@RequiredArgsConstructor
public class AlunoController {
    private final AlunoService alunoService;

    @GetMapping
    public ResponseEntity<List<Aluno>> getAll() {
        List<Aluno> alunos = alunoService.getAll();
        return new ResponseEntity<List<Aluno>>(alunos,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    ResponseEntity<Aluno> getById(@PathVariable Long id) {
        return new ResponseEntity<>(alunoService.getById(id), HttpStatus.OK);
    }

    @PostMapping
    ResponseEntity<Aluno> insertAluno(@RequestBody Aluno aluno) {
        return new ResponseEntity(alunoService.insert(aluno),HttpStatus.OK);
    }

    @PutMapping
    ResponseEntity<Aluno> editAluno(@RequestBody Aluno aluno) {
        return new ResponseEntity(alunoService.edit(aluno),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Aluno> deleteAluno(@PathVariable Long id){
        return new ResponseEntity(alunoService.delete(id),HttpStatus.OK);
    }

}
