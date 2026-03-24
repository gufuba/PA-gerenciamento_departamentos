package com.fumagalli.gerenciamento_departamentos.controllers;

import com.fumagalli.gerenciamento_departamentos.models.DepartamentoModel;
import com.fumagalli.gerenciamento_departamentos.services.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/departamentos")
public class DepartamentoController {
    @Autowired
    private DepartamentoService departamentoService;

    @GetMapping
    public ResponseEntity<List<DepartamentoModel>> findAll(){
        List<DepartamentoModel> requeste = departamentoService.findAll();
        return ResponseEntity.ok().body(requeste);
    }

    @PostMapping
    public ResponseEntity<DepartamentoModel> criarDepartamento(@RequestBody DepartamentoModel departamentoModel){
        DepartamentoModel novo = departamentoService.criarDepartamento(departamentoModel);
        return ResponseEntity.status(201).body(novo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarDepartamento(@PathVariable Long id){
        departamentoService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartamentoModel> buscarPorIdDepartamento(@PathVariable Long id){
        Optional<DepartamentoModel> departamento = departamentoService.buscarPorId(id);

        if(departamento.isPresent()){
            return ResponseEntity.ok(departamento.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<DepartamentoModel> atualizarDepartamento(@PathVariable Long id, @RequestBody DepartamentoModel departamentoModel){
        DepartamentoModel atualizado = departamentoService.atualizar(id, departamentoModel);
        return ResponseEntity.ok().body(atualizado);
    }
}
