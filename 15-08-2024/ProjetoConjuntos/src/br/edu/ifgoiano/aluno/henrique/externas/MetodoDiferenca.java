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

        HashSet <Integer> setA = new HashSet <> (a);
        HashSet <Integer> setB = new HashSet <> (b);

        diferenca.addAll(setA);
        diferenca.removeAll(setB);

        System.out.println(diferenca);
    }
}
