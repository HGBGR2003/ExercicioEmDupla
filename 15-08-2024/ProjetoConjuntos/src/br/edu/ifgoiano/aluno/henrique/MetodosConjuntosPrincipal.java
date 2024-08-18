package br.edu.ifgoiano.aluno.henrique;

import java.util.ArrayList;

public class MetodosConjuntosPrincipal {
  public static void main(String[] args) {
    int[] a = { 2, 4 };
    int[] b = { 4, 5, 6 };
    ArrayList<Integer> uniao = new ArrayList<>();
    uniao = unir(a, b);

    System.out.println("\n");
    System.out.println(uniao);

    ArrayList<ArrayList<Integer>> conjPar = conjDParts(a);
    System.out.println(conjPar);

    ArrayList<ArrayList<Integer>> prodCart = pCartesi(a, b);
    System.out.println(prodCart);
  }

  public static ArrayList<Integer> unir (int[]a, int[]b){
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
    return uniaoDeArrays;
  }

  public static ArrayList<ArrayList<Integer>> conjDParts(int[] a) {
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
    return conjutoPartes;
  }

  public static ArrayList<ArrayList<Integer>> pCartesi(int[] a, int[] b) {
    ArrayList<ArrayList<Integer>> resultadoProdutoCartesiano = new ArrayList<>();
    for (int i = 0; i < a.length; i++) {
      for (int j = 0; j < b.length; j++) {
        ArrayList<Integer> elementos = new ArrayList<>();
        elementos.add(a[i]);
        elementos.add(b[j]);
        resultadoProdutoCartesiano.add(elementos);
      }
    }
    return resultadoProdutoCartesiano;
  }
}
