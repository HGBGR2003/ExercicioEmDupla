package br.edu.ifgoiano.aluno.henrique.externas;

import java.util.ArrayList;

public class MetodoInterseccao {
  public ArrayList<Integer> intercepta(int[] a, int[] b) {
    ArrayList<Integer> interc = new ArrayList<>();
    for (int k = 0; k < a.length; k++) {

      for (int j = 0; j < b.length; j++) {
        if (a[k] == b[j]) {
          interc.add(a[k]);
        }

      }
    }
    return interc;
  }
}
