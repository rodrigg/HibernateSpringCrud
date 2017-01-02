package com.rodionbykov.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rodionbykov.model.Nota;
import com.rodionbykov.repository.custom.NotaRepositoryCustom;

public interface NotaRepository extends JpaRepository<Nota, Integer>, NotaRepositoryCustom {

}
