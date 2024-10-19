package br.edu.ifgoiano.aluno.henrique;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ERRepository {
    private HashMap<Integer,MatchValues> matchValues = new HashMap<>();
    private String text;
    private String expression;

    public ERRepository(String text, String expression) {
        this.text = text;
        this.expression = expression;
    }

    public HashMap<Integer,MatchValues> execute(){
        Pattern tex =  Pattern.compile(expression);
        Matcher mat = tex.matcher(text);

        while(mat.find()){

            String titulo = mat.group(1);
            String texto = mat.group(2);
            String autor = mat.group(3);

            MatchValues mv = new MatchValues(matchValues.size() + 1, titulo + ";" + texto + ";" + autor, mat.start(), mat.end());
            matchValues.put(mv.getId(), mv);

        }

        return matchValues;
    }

    public void toPrint(){
        System.out.println("Esse é o texto da Expressão Regular");
        for (Map.Entry<Integer, MatchValues> entry : matchValues.entrySet()){
            MatchValues mv = entry.getValue();
            System.out.printf("ID: %d, Texto: '%s', Posição Inicial: %d, Posição Final: %d%n",
                    mv.getId(), mv.getText(), mv.getPositionStart(), mv.getPositionEnd());

            System.out.println("-----------------------------------------------------------------");
        }

    }

    public void toJSON(){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonSaida = gson.toJson(matchValues);
        System.out.println("Expressão em JSON");
        System.out.println("----------");
        System.out.println(jsonSaida);
    }

    public void toCSV(String fileName){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("Título;Texto;Autor");
            writer.newLine();

            for (MatchValues mv : matchValues.values()){
               // MatchValues mv = entry.getValue();
                String[] partes = mv.getText().split(";");
                if (partes.length == 3) {
                    writer.write(partes[0] + ";" + partes[1] + ";" + partes[2]);
                    writer.newLine();
                }
            }
            System.out.println("Dados salvos em: " + fileName);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
