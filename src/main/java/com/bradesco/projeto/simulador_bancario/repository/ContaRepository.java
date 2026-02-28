package com.bradesco.projeto.simulador_bancario.repository;

import com.bradesco.projeto.simulador_bancario.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long> {
}