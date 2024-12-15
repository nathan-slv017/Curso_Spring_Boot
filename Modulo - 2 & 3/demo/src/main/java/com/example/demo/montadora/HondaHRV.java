package com.example.demo.montadora;

import java.awt.*;

public class HondaHRV extends Carro{


    public HondaHRV(Motor motor) {
        super(motor);
        setModelo("HVR");
        setCor(Color.BLACK);
        setMontadora(Montadora.HONDA);
    }
}
