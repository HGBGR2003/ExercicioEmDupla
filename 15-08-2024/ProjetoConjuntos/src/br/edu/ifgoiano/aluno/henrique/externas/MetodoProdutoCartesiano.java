package br.edu.ifgoiano.aluno.henrique.externas;

import java.util.ArrayList;

public class MetodoProdutoCartesiano {
    public static ArrayList<ArrayList<Integer>> pCartesi() {

        int [] a = {2,4};
        int [] b = {4,5,6};

        ArrayList<ArrayList<Integer>> resultadoProdutoCartesiano = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                ArrayList<Integer> elementos = new ArrayList<>();
                elementos.add(a[i]);
                elementos.add(b[j]);
                resultadoProdutoCartesiano.add(elementos);
            }
        }
        System.out.println(resultadoProdutoCartesiano);
        return resultadoProdutoCartesiano;
    }
}
