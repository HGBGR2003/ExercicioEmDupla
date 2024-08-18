package br.edu.ifgoiano.aluno.henrique.externas;

import java.util.ArrayList;

public class MetodoPartes {
    public static ArrayList<ArrayList<Integer>> conjDParts() {

        int [] a = {2,4};

        ArrayList<ArrayList<Integer>> conjutoPartes = new ArrayList<>();
        for (int i = 0; i <= a.length + 1; i++) {
            ArrayList<Integer> auxiliar = new ArrayList<>();
            if (i <= a.length && i != 0) {
                auxiliar.add(a[i - 1]);
            } else if (i > a.length) {
                for (int h = 0; h < a.length; h++) {
                    auxiliar.add(a[h]);
                }
            }
            conjutoPartes.add(auxiliar);
        }
        System.out.println(conjutoPartes);
        return conjutoPartes;
    }
}
