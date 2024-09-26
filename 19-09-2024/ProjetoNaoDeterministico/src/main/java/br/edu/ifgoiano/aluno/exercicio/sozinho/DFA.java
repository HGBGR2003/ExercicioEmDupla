package br.edu.ifgoiano.aluno.exercicio.sozinho;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DFA {
    private List<Character> alfabeto;
    private Set<String> estados;
    private String estadoInicial;
    private Set<String> estadosFinais;
    Map<String, Map<Character, String>> funcao = new HashMap<>();

    public DFA(List<Character> alfabeto, Set<String> estados, String estadoInicial, Set<String> estadosFinais) {
        this.alfabeto = alfabeto;
        this.estados = estados;
        this.estadoInicial = estadoInicial;
        this.estadosFinais = estadosFinais;
    }

    // Adiciona transições
    public void adicionarTransicao(String estado, char simbolo, String proximoEstado) {
        funcao.putIfAbsent(estado, new HashMap<>());
        funcao.get(estado).put(simbolo, proximoEstado);
    }

    public Map<String, Map<Character, String>> getTransicoes() {
        return funcao;
    }

    public String getEstadoInicial() {
        return estadoInicial;
    }

    public Set<String> getEstadosFinais() {
        return estadosFinais;
    }

    public boolean simulando(String entrada){
        String correnteEstado = estadoInicial;
        System.out.println("Estado inicial: " + correnteEstado);

        for (char simbolo: entrada.toCharArray()){
            Map<Character, String> transicoes = funcao.get(correnteEstado);
            if (transicoes == null) {
                return false;
            }

            String proximoEstado = transicoes.get(String.valueOf(simbolo));

            if (proximoEstado == null){
                System.out.println("Não há transição para o símbolo " + simbolo + " no estado " + correnteEstado);
                return false;
            }

            System.out.println("Lido: " + simbolo + ", próximo estado: " + correnteEstado);
            correnteEstado = proximoEstado;

        }
        System.out.println("Estado final: " + correnteEstado);
        return estadosFinais.contains(correnteEstado);
    }

}
