package com.fumagalli.gerenciamento_departamentos.services;

import com.fumagalli.gerenciamento_departamentos.models.DepartamentoModel;
import com.fumagalli.gerenciamento_departamentos.repositories.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartamentoService {
    @Autowired
    private DepartamentoRepository departamentoRepository;

    public List<DepartamentoModel> findAll(){
        return departamentoRepository.findAll();
    }

    public DepartamentoModel criarDepartamento(DepartamentoModel departamentoModel){
        return departamentoRepository.save(departamentoModel);
    }

    public Optional<DepartamentoModel> buscarPorId(Long id){
        return departamentoRepository.findById(id);
    }

    public DepartamentoModel atualizar(long id, DepartamentoModel departamentoModel){
        DepartamentoModel model = departamentoRepository.findById(id).get();
        model.setNome(departamentoModel.getNome());
        model.setLocalizacao(departamentoModel.getLocalizacao());

        return departamentoRepository.save(model);
    }

    public void deletar(Long id){
        departamentoRepository.deleteById(id);
    }

}
