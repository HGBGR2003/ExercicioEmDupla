package br.edu.ifgoiano.aluno.exercicio.sozinho;

import java.util.List;
import java.util.Map;

public class Automato {
    private List<Character> alpha;
    private List<String> state;
    private String initial_state;
    private List<String> end_state;
    private Map<String, Map<String, List<String>>> transition;

    public List<Character> getAlpha() {
        return alpha;
    }

    public void setAlpha(List<Character> alpha) {
        this.alpha = alpha;
    }

    public List<String> getState() {
        return state;
    }

    public void setState(List<String> state) {
        this.state = state;
    }

    public String getInitial_state() {
        return initial_state;
    }

    public void setInitial_state(String initial_state) {
        this.initial_state = initial_state;
    }

    public List<String> getEnd_state() {
        return end_state;
    }

    public void setEnd_state(List<String> end_state) {
        this.end_state = end_state;
    }

    public Map<String, Map<String, List<String>>> getTransition() {
        return transition;
    }

    public void setTransition(Map<String, Map<String, List<String>>> transition) {
        this.transition = transition;
    }
}
