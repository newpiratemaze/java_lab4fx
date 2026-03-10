package com.example.java_lab4fx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import core.DataProcessor;

public class Controller {
    @FXML
    public TextArea inputField;
    @FXML
    public ListView<String> outputField;

    @FXML
    public void processSystem()
    {
        try
        {
            DataProcessor dataProcessor = new DataProcessor();



            String str = inputField.getText();


            String[] lists = str.split("\n");
            System.out.println(lists);



//        String[] str = new String[]{"12 3 5 5 14 23 29 38","6 6 15 7 16"};
//        System.out.println(str[0]);
            List<List<Integer>> resultList = dataProcessor.processPipeline(lists);


            ObservableList<String> items = FXCollections.observableArrayList();
            for(int i = 0;i<resultList.size();i++)
            {
                items.add(String.valueOf(resultList.get(i)));
            }
            outputField.setItems(items);
            //outputField.setItems((ObservableList) resultList);
        }
        catch (Exception e)
        {
            ObservableList<String> error = FXCollections.observableArrayList("Поле для ввода пустое!","Введите данные в поле для ввода выше");
            outputField.setItems(error);
        }

    }

    @FXML
    public void ReadFromFile()
    {
        try (Scanner scanner = new Scanner(new File("D:\\projects\\Java\\Java_Labs\\lab4FX\\input.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);

                inputField.setText(inputField.getText()+line+"\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void SaveToFile()
    {
        ObservableList<String> items = outputField.getItems();

        try (FileWriter writer = new FileWriter("D:\\projects\\Java\\Java_Labs\\lab4FX\\output.txt", false))
        {
            for(int i = 0;i<items.size();i++)
            {
                writer.write(items.get(i)+"\n");

            }


        }
        catch (Exception e)
        {
            System.out.println("Файл не найден");
        }
    }


}
