package br.edu.ifgoiano.aluno.henrique.Main;

import java.util.ArrayList;

import br.edu.ifgoiano.aluno.henrique.externas.MetodoComplementar;

public class MetodoConjuntoComplementar {
    public static void main(String[] args) {
        MetodoComplementar verifComplementar = new MetodoComplementar();
        ArrayList<Integer> verificandoComp = verifComplementar.verificaComplementar();
        System.out.println("\n");
        System.out.println(verificandoComp);

    }
}
