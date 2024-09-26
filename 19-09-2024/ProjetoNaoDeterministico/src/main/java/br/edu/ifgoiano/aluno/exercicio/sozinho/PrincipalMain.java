package br.edu.ifgoiano.aluno.exercicio.sozinho;

import com.google.gson.Gson;

import java.util.*;

public class PrincipalMain {

    public static void main(String[] args) {
        try {
            Gson gson = new Gson();
            String json = "{\n" +
                    "    \"alpha\": [0, 1],\n" +
                    "    \"state\": [\"q0\", \"q1\", \"q2\"],\n" +
                    "    \"initial_state\": \"q0\",\n" +
                    "    \"end_state\": [\"q2\"],\n" +
                    "    \"transition\": {\n" +
                    "        \"q0\": {\n" +
                    "            \"0\": [\"q0\", \"q1\"],\n" +
                    "            \"1\": [\"q0\"]\n" +
                    "        },\n" +
                    "        \"q1\": {\n" +
                    "            \"0\": [\"\\u03B5\"],\n" +
                    "            \"1\": [\"q2\"]\n" +
                    "        },\n" +
                    "        \"q2\": {\n" +
                    "            \"0\": [\"\\u03B5\"],\n" +
                    "            \"1\": [\"\\u03B5\"]\n" +
                    "        }\n" +
                    "    }\n" +
                    "}";
            Automato automato = gson.fromJson(json, Automato.class);

            List<Character> alfabeto = new ArrayList<>();
            for (int alpha : automato.getAlpha()) {
                alfabeto.add((char) (alpha + '0'));
            }

            Set<String> estados = new HashSet<>(automato.getState());
            String estadoInicial = automato.getInitial_state();
            Set<String> estadosFinais = new HashSet<>(automato.getEnd_state());

                // Cria o NFA
            NFA nfa = new NFA(alfabeto, estados, estadoInicial, estadosFinais);
            for (String estado : automato.getTransition().keySet()) {
                Map<String, List<String>> transicoes = automato.getTransition().get(estado);
                for (String simbolo : transicoes.keySet()) {
                    for (String proximoEstado : transicoes.get(simbolo)) {
                        if (!proximoEstado.equals("ε")) { // Ignora transições ε
                                nfa.adicionarTransicao(estado, simbolo.charAt(0), proximoEstado);
                        }
                    }
                }
            }


            DFA dfa = Conversor.converter(nfa);

            String entrada = "010";  // String a ser testada
            boolean aceito = dfa.simulando(entrada);
            System.out.println("A string " + entrada + " é aceita pelo DFA? " + aceito);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


