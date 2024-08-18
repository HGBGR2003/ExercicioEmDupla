package br.edu.ifgoiano.aluno.henrique.externas;

import java.util.ArrayList;

public class MetodoUniao {
    public static ArrayList<Integer> unir() {

        int [] a = {2,4};
        int [] b = {4,5,6};

        int aux = 0;
        int[] juntos = new int[a.length + b.length];
        System.arraycopy(a, 0, juntos, 0, a.length);
        System.arraycopy(b, 0, juntos, a.length, b.length);
        ArrayList<Integer> uniaoDeArrays = new ArrayList<>();
        for (int i = 0; i < juntos.length; i++) {
            uniaoDeArrays.add(juntos[i]);
        }
        for (int i = 0; i < uniaoDeArrays.size(); i++) {
            if (i == 0) {
                aux = uniaoDeArrays.get(i);
            } else if (uniaoDeArrays.get(i) == aux) {
                uniaoDeArrays.remove(i);
            }
            aux = uniaoDeArrays.get(i);
        }
        System.out.println(uniaoDeArrays);
        return uniaoDeArrays;
    }
}
