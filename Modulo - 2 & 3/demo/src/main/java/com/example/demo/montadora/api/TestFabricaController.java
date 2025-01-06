package com.example.demo.montadora.api;

import com.example.demo.montadora.CarroStatus;
import com.example.demo.montadora.Chave;
import com.example.demo.montadora.HondaHRV;
import com.example.demo.montadora.Motor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/carros")
public class TestFabricaController {

    @Autowired
    //@Qualifier("motorEletrico")
    @Eletrico
    private Motor motor;

    @PostMapping
    public CarroStatus ligarCarro(@RequestBody Chave chave) {
        var carro = new HondaHRV(motor);
        return carro.darIgnicao(chave);
    }

}
