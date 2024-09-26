package br.edu.ifgoiano.aluno.exercicio.dupla;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class PrincipalTest {
    public static void main(String[] args) {
        String testeJson;

        testeJson = "{\n" +
                "    \"alpha\": [\"0\", \"1\"],\n" +
                "    \"state\": [\"q0\", \"q1\", \"q2\"],\n" +
                "    \"initial_state\": \"q0\",\n" +
                "    \"end_state\": [\"q2\"],\n" +
                "    \"transition\": {\n" +
                "        \"q0\": {\n" +
                "            \"0\": \"q0\",\n" +
                "            \"1\": \"q1\"\n" +
                "        },\n" +
                "        \"q1\": {\n" +
                "            \"0\": \"q0\",\n" +
                "            \"1\": \"q2\"\n" +
                "        },\n" +
                "        \"q2\": {\n" +
                "            \"0\": \"q2\",\n" +
                "            \"1\": \"q2\"\n" +
                "        }\n" +
                "    }\n" +
                "}\n";

        Gson gson = new Gson();
        MudancaDeEstado mde = gson.fromJson(testeJson, MudancaDeEstado.class);


        String entrada = "011";
        boolean aceitou = mde.simulando(entrada);
        System.out.println("A string " + entrada + " é aceita pelo DFA? " + aceitou);





    }

}
