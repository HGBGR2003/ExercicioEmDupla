package br.edu.ifgoiano.aluno.exercicio.dupla;


import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MudancaDeEstado {
    @SerializedName("alpha")
    private List <String> alfabeto;
    @SerializedName("state")
   private Set <String> estados;
    @SerializedName("initial_state")
   private String inicialEstado;
    @SerializedName("end_state")
   private Set <String> finalEstado;
    @SerializedName("transition")
   private Map <String, Map <String, String>> funcaoTransicao = new HashMap<>();

    public MudancaDeEstado() {
        //this.funcaoTransicao = new HashMap<>();
    }

    public List<String> getAlfabeto() {
        return alfabeto;
    }

    public void setAlfabeto(List<String> alfabeto) {
        this.alfabeto = alfabeto;
    }

    public Set<String> getEstados() {
        return estados;
    }

    public void setEstados(Set<String> estados) {
        this.estados = estados;
    }

    public String getInicialEstado() {
        return inicialEstado;
    }

    public void setInicialEstado(String inicialEstado) {
        this.inicialEstado = inicialEstado;
    }

    public Set<String> getFinalEstado() {
        return finalEstado;
    }

    public void setFinalEstado(Set<String> finalEstado) {
        this.finalEstado = finalEstado;
    }

    public Map<String, Map<String, String>> getFuncaoTransicao() {
        return funcaoTransicao;
    }

    public void setFuncaoTransicao(Map<String, Map<String, String>> funcaoTransicao) {
        this.funcaoTransicao = funcaoTransicao;
    }

    public boolean simulando(String entrada){
        String correnteEstado = inicialEstado;
        System.out.println("Estado inicial: " + correnteEstado);

        for (char simbolo: entrada.toCharArray()){
            String simboloSt = String.valueOf(simbolo);
            Map<String, String> transicoes = funcaoTransicao.get(correnteEstado);

            if (transicoes == null) {
                return false; // Transição não definida
            }

            String proximoEstado = transicoes.get(simboloSt);

            if (proximoEstado == null){
                System.out.println("Não há transição para o símbolo " + simbolo + " no estado " + correnteEstado);
                return false;
            }

            correnteEstado = proximoEstado;
            System.out.println("Lido: " + simbolo + ", próximo estado: " + correnteEstado);

        }
        System.out.println("Estado final: " + correnteEstado);
        return finalEstado.contains(correnteEstado);
    }

}
