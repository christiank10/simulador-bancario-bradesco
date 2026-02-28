package com.bradesco.projeto.simulador_bancario.controller;

import com.bradesco.projeto.simulador_bancario.model.Conta;
import com.bradesco.projeto.simulador_bancario.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contas")
public class ContaController {

    @Autowired
    private ContaRepository repository;

    @GetMapping
    public List<Conta> listarTodas() {
        return repository.findAll();
    }

    @GetMapping("/{id}/auditoria")
    public String auditarConta(@PathVariable Long id) {
        // Aqui o findById funciona porque o Repository e a Conta agora estão no mesmo pacote
        Conta conta = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Conta não encontrada"));
        
        double saldo = conta.getSaldo().doubleValue();
        
        if (saldo > 5000) {
            return "Agente IA Bradesco: Cliente [" + conta.getTitular() + "] VIP Prime.";
        } else if (saldo < 0) {
            return "Agente IA Bradesco: Alerta de risco para [" + conta.getTitular() + "].";
        } else {
            return "Agente IA Bradesco: Conta saudável.";
        }
    }
}