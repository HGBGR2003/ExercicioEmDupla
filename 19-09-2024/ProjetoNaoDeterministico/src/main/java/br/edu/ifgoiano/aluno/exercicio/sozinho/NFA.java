package br.edu.ifgoiano.aluno.exercicio.sozinho;

import java.util.*;

public class NFA {
    private List<Character> alfabeto;
    private Set<String> estados;
    private String estadoInicial;
    private Set<String> estadosFinais;
    private Map<String, Map<Character, Set<String>>> transicoes;

    public NFA(List<Character> alfabeto, Set<String> estados, String estadoInicial, Set<String> estadosFinais) {
        this.alfabeto = alfabeto;
        this.estados = estados;
        this.estadoInicial = estadoInicial;
        this.estadosFinais = estadosFinais;
        this.transicoes = new HashMap<>();
    }

    public void adicionarTransicao(String estado, char simbolo, String proximoEstado) {
        transicoes.putIfAbsent(estado, new HashMap<>());
        transicoes.get(estado).putIfAbsent(simbolo, new HashSet<>());
        transicoes.get(estado).get(simbolo).add(proximoEstado);
    }

    public Map<String, Map<Character, Set<String>>> getTransicoes() {
        return transicoes;
    }

    public Set<String> getEstadosFinais() {
        return estadosFinais;
    }

    public String getEstadoInicial() {
        return estadoInicial;
    }

    public List<Character> getAlfabeto() {
        return alfabeto;
    }

    public void setAlfabeto(List<Character> alfabeto) {
        this.alfabeto = alfabeto;
    }

    public void setEstados(Set<String> estados) {
        this.estados = estados;
    }

    public Set<String> getEstados() {
        return estados;
    }

    public void setEstadoInicial(String estadoInicial) {
        this.estadoInicial = estadoInicial;
    }

    public void setEstadosFinais(Set<String> estadosFinais) {
        this.estadosFinais = estadosFinais;
    }

    public void setTransicoes(Map<String, Map<Character, Set<String>>> transicoes) {
        this.transicoes = transicoes;
    }




}

