package br.edu.ifgoiano.aluno.henrique.externas;

import java.util.ArrayList;

public class MetodoComplementar {

    public ArrayList<Integer> verificaComplementar() {
        int a[] = { 2, 4 };
        int u[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        ArrayList<Integer> comp = new ArrayList<>();
        for (int i = 0; i < u.length; i++) {
            comp.add(u[i]);
        }
        for (int i = 0; i < comp.size(); i++) {
            for (int j = 0; j < a.length; j++) {
                if (comp.get(i) == a[j]) {
                    comp.remove(i);
                }
            }
        }
        return comp;
    }
}
