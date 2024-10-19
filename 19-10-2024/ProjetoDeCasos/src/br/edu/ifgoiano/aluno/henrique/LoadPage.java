package br.edu.ifgoiano.aluno.henrique;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class LoadPage {
    public void getPage(URL url, File file) throws IOException {
        BufferedReader in =
                new BufferedReader(new InputStreamReader(url.openStream()));

        BufferedWriter out = new BufferedWriter(new FileWriter(file));

        String inputLine;

        while ((inputLine = in.readLine()) != null) {

            // Imprime página no console
            System.out.println(inputLine);

            // Grava pagina no arquivo
            out.write(inputLine);
            out.newLine();
        }

        in.close();
        out.flush();
        out.close();
    }

    public static void main(String[] args) {
        URL url = null;
        File file = new File("pagina_uol.html");

        try {
            url = new URL("https://noticias.uol.com.br/blogs-e-colunas/");
            LoadPage lp = new LoadPage();
            lp.getPage(url, file);

            BufferedReader br = new BufferedReader(new FileReader(file));
            StringBuilder html = new StringBuilder();
            String line;

            while ((line = br.readLine()) != null) {
                html.append(line).append("\n");
            }

            br.close();

            String expression = "<h2 class=\"titulo\">(.*?)</h2>.*?<p class=\"texto\">(.*?)</p>.*?<span class=\"autor\">(.*?)</span>";

            ERRepository eReposit = new ERRepository(html.toString(), expression);
            eReposit.execute();
            eReposit.toPrint();
            eReposit.toJSON();
            eReposit.toCSV("noticias_uol.csv");

            System.out.println("Dados salvos com sucesso no arquivo 'noticias_uol.csv'!");

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

