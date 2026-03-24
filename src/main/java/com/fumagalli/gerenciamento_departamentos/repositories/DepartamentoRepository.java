package com.fumagalli.gerenciamento_departamentos.repositories;

import com.fumagalli.gerenciamento_departamentos.models.DepartamentoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartamentoRepository extends JpaRepository<DepartamentoModel, Long> {
}
