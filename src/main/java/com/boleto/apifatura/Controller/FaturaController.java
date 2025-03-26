package com.boleto.apifatura.Controller;

import com.boleto.apifatura.Model.Fatura;
import com.boleto.apifatura.Repository.FaturaRepository;
import com.boleto.apifatura.Service.FaturaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/faturas")
public class FaturaController {
    private final FaturaService faturaService;
    public FaturaController(FaturaService faturaService) {
        this.faturaService = faturaService;
    }

    @GetMapping
    public List<Fatura> listarFaturas() {return faturaService.listarTodos();}

    @PostMapping
    public ResponseEntity<Fatura> criarFatura(@Valid @RequestBody Fatura fatura) {
        Fatura novaFatura = faturaService.salvar(fatura);
        return ResponseEntity.ok(novaFatura);
    }
}