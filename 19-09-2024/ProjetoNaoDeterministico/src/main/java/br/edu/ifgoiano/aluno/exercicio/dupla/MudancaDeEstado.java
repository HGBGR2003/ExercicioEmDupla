package br.edu.ifgoiano.aluno.exercicio.dupla;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MudancaDeEstado {
    Set<String> estados = new HashSet<>();
    Set <Character> alpabeto = new HashSet<>();
    String inicialEstado;
    Set <String> fimEstados = new HashSet<>();
    Map<String, Map<Character, String>> transicoes = new HashMap<>();

    public void adicionarEstados (String estado){
        estados.add(estado);
    }

    public void adicionarTransicao(String deEstado, char entrada, String paraEstado){
        alpabeto.add(entrada);
        transicoes.putIfAbsent(paraEstado, new HashMap<>());
        transicoes.get(paraEstado).put(entrada, paraEstado);
    }

    public void iniciandoEstado(String estado){
        inicialEstado = estado;
    }

    public void fimEstado (String estado){
        fimEstados.add(estado);
    }

    @Override
    public String toString() {
        return "MudancaDeEstado{" +
                "estados=" + estados +
                ", alpabeto=" + alpabeto +
                ", inicialEstado='" + inicialEstado + '\'' +
                ", fimEstados=" + fimEstados +
                ", transicoes=" + transicoes +
                '}';
    }

    public boolean aceitou(String entrada){
        String correnteEstado = inicialEstado;
        for (char simbolo: entrada.toCharArray()){
            if (!alpabeto.contains(simbolo)){
                return false;
            }
            Map<Character, String> estadoTransicoes = transicoes.get(correnteEstado);
            if (estadoTransicoes == null || !estadoTransicoes.containsKey(simbolo)){
                return false;
            }
            correnteEstado = estadoTransicoes.get(simbolo);
        }
        return fimEstados.contains(correnteEstado);
    }


}
