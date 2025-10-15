package br.com.luanlana.academico.service;

import br.com.luanlana.academico.model.Aluno;
import br.com.luanlana.academico.repository.AlunoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlunoService {
    private final AlunoRepository alunoRepository;

    public List<Aluno> getAll() {
        return alunoRepository.findAll();
    }

    public Aluno getById(Long id) {
        Aluno aluno = alunoRepository.findById(id).get();
        if (aluno == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return aluno;
    }

    public Aluno edit(Aluno novo) {
        Aluno aluno = alunoRepository.findById(novo.getId()).get();
        if (aluno == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        aluno.setRg(novo.getRg());
        aluno.setNome(novo.getNome());
        aluno.setCurso(novo.getCurso());
        return alunoRepository.save(aluno);
    }

    public Aluno insert(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    public Aluno delete(Long id) {
        Aluno aluno = alunoRepository.getById(id);
        if (aluno == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        else
            alunoRepository.delete(aluno);
        return aluno;
    }
}
