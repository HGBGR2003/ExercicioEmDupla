package br.edu.ifgoiano.aluno.henrique.externas;

import java.util.ArrayList;


public class MetodoInterseccao {
    public void intercepta(){

        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();

        a.add(2);
        a.add(4);

        b.add(4);
        b.add(5);
        b.add(6);

        for(int i = 0; i < b.size(); i++) {
            ArrayList<Integer> sobras = new ArrayList<>();
            if (b.contains(a.get(i))) {
                sobras.add(a.get(i));
            }
            System.out.println(sobras);
        }
    }
}
