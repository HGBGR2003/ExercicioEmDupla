package br.edu.ifgoiano.aluno.exercicio.sozinho;

import java.util.*;

public class Conversor {
    public static DFA converter(NFA nfa) {
        List<Character> alfabeto = nfa.getAlfabeto();
        Set<String> estadosNFA = nfa.getEstados();
        String estadoInicialNFA = nfa.getEstadoInicial();
        Set<String> estadosFinaisNFA = nfa.getEstadosFinais();

        // Cria um novo DFA
        Set<String> estadosDFA = new HashSet<>();
        String estadoInicialDFA = estadoInicialNFA;  // Estado inicial é o mesmo
        Set<String> estadosFinaisDFA = new HashSet<>();
        Map<String, Map<Character, String>> transicoesDFA = new HashMap<>();

        // Inicializa a fila com o estado inicial do NFA
        Queue<Set<String>> fila = new LinkedList<>();
        Set<String> estadoInicialConjunto = new HashSet<>(Collections.singletonList(estadoInicialNFA));
        fila.add(estadoInicialConjunto);
        estadosDFA.add(estadoInicialConjunto.toString());

        while (!fila.isEmpty()) {
            Set<String> estadoAtual = fila.poll();
            String estadoAtualStr = estadoAtual.toString();

            // Verifica se algum dos estados atuais é um estado final
            for (String estado : estadoAtual) {
                if (estadosFinaisNFA.contains(estado)) {
                    estadosFinaisDFA.add(estadoAtualStr);
                    break;
                }
            }

            for (char simbolo : alfabeto) {
                Set<String> proximoEstadoConjunto = new HashSet<>();

                // Para cada estado atual, encontra os próximos estados
                for (String estado : estadoAtual) {
                    Map<Character, Set<String>> transicoes = nfa.getTransicoes().get(estado);
                    if (transicoes != null && transicoes.containsKey(simbolo)) {
                        proximoEstadoConjunto.addAll(transicoes.get(simbolo));
                    }
                }

                if (!proximoEstadoConjunto.isEmpty()) {
                    String proximoEstadoStr = proximoEstadoConjunto.toString();
                    transicoesDFA.putIfAbsent(estadoAtualStr, new HashMap<>());
                    transicoesDFA.get(estadoAtualStr).put(simbolo, proximoEstadoStr);

                    if (!estadosDFA.contains(proximoEstadoStr)) {
                        estadosDFA.add(proximoEstadoStr);
                        fila.add(proximoEstadoConjunto);
                    }
                }
            }
        }

        // Cria o DFA final
        DFA dfa = new DFA(alfabeto, estadosDFA, estadoInicialDFA, estadosFinaisDFA);
        dfa.funcao = transicoesDFA;

        return dfa;
    }
}
