package org.example;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String... args) {

        int port = 8989;
        File file = new File("categories.tsv");
        Categories categories = getCategories(file);


        try (ServerSocket serverSocket = new ServerSocket(port);) { // порт можете выбрать любой в доступном диапазоне 0-65536. Но чтобы не нарваться на уже занятый - рекомендуем использовать около 8080
            while (true) {
                try (Socket clientSocket = serverSocket.accept(); // ждем подключения
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                ) {

                    //Читаем строку, отправленную клиентом
                    //строка в формате json пример:
                    // {"title": "булка", "date": "2022.02.08", "sum": 200}

                    final String strJson = in.readLine();
                    Object obj = new JSONParser().parse(strJson);
                    // Кастим obj в JSONObject
                    JSONObject jo = (JSONObject) obj;
                    // Достаём title
                    String title = (String) jo.get("title");
                    // Достаём date
                    String date = (String) jo.get("date");
                    // Достаём sum
                    Long sum = (Long) jo.get("sum");
                    String s1 = "Title: " + title + ", Date: " + date + ", Sum: " + sum;
                    PrintStream printStream = new PrintStream(System.out, true, "cp866");
                    printStream.println(s1);

                    Category category = categories.getCategory(title);
                    category.addSum(sum);

                    out.println(categories.maxCategory());


                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ParseException pe) {
                    pe.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Categories getCategories(File file) {
        //Сразу добавим категорию "другое"
        List<String> categoriesList = new ArrayList<>();
        Category categoryOther = new Category("другое", categoriesList, 0L);
        List<Category> categoryArrayList = new ArrayList<>();
        categoryArrayList.add(categoryOther);
        Categories categories = new Categories(categoryArrayList);

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            //чтение построчно
            String s;
            while ((s = br.readLine()) != null) {

                String[] parts = s.split("\t");
                String product = parts[0];
                String category = parts[1];
                categories.addCategory(category, product);

            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return categories;
    }


}