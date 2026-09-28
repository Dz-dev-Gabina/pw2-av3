package br.com.etechoracio.pw2av3.controller;

import br.com.etechoracio.pw2av3.entity.ExercicioFisico;
import br.com.etechoracio.pw2av3.enums.NivelDificuldadeEnum;
import br.com.etechoracio.pw2av3.repository.ExercicioFisicoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/exercicios")
public class ExercicioFIsicoController {
    private final ExercicioFisicoRepository repository;

    public ExercicioFIsicoController(ExercicioFisicoRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public ResponseEntity<List<ExercicioFisico>> listar() {
        List<ExercicioFisico> exercicios = repository.findAll();
        if (exercicios.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(exercicios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExercicioFisico> buscarPorId(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/niveis")
    public ResponseEntity<List<NivelDificuldadeEnum>> listarNiveis() {
        return ResponseEntity.ok(Arrays.asList(NivelDificuldadeEnum.values()));
    }
}
