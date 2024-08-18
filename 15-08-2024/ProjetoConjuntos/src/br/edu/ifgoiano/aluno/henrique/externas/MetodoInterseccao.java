package br.edu.ifgoiano.aluno.henrique.externas;

import java.util.ArrayList;

public class MetodoInterseccao {
  public ArrayList<Integer> intercepta() {

    ArrayList a = new ArrayList<>();
    ArrayList b = new ArrayList();

    a.add(2);
    a.add(4);

    b.add(4);
    b.add(5);
    b.add(6);

    ArrayList<Integer> interc = new ArrayList<>();
    for (int k = 0; k < a.size(); k++) {

      for (int j = 0; j < b.size(); j++) {
        if (a.get(k) == b.get(j)) {
          interc.add((Integer) a.get(k));
        }
      }
    }
    System.out.println(interc);
    return interc;
  }
}
