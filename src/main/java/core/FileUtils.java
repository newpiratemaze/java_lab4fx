package core;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

public class FileUtils
{

    public void ReadFromFile(TextArea inputField)
    {
        //try (Scanner scanner = new Scanner(new File("D:\\projects\\Java\\Java_Labs\\lab4FX\\input.txt"))) {
        try (Scanner scanner = new Scanner(new File("D:\\projects\\Java\\alabs\\j_lab4fx\\input.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);

                inputField.setText(inputField.getText()+line+"\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    public void SaveToFile(ListView<String> outputField)
    {
        ObservableList<String> items = outputField.getItems();

        //try (FileWriter writer = new FileWriter("D:\\projects\\Java\\Java_Labs\\lab4FX\\output.txt", false))
        try (FileWriter writer = new FileWriter("D:\\projects\\Java\\alabs\\j_lab4fx\\output.txt", false))
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
