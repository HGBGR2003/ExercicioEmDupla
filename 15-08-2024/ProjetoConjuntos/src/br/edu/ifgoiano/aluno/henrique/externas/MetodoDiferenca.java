package br.edu.ifgoiano.aluno.henrique.externas;

import java.util.ArrayList;
import java.util.HashSet;

public class MetodoDiferenca {
    public void diferencaConjuntos (){
        ArrayList <Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();
        ArrayList<Integer> diferenca = new ArrayList<>();

        a.add(2);
        a.add(4);

        b.add(4);
        b.add(5);
        b.add(6);

        HashSet <Integer> saidaA = new HashSet <> (a);
        HashSet <Integer> saidaB = new HashSet <> (b);

        diferenca.addAll(saidaA);
        diferenca.removeAll(saidaB);

        System.out.println(diferenca);
    }
}
