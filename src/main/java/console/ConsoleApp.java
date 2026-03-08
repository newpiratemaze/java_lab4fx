package console;

import core.DataProcessor;

import java.util.ArrayList;
import java.util.List;

public class ConsoleApp
{
    public void main(String[] args)
    {
        DataProcessor dataProcessor = new DataProcessor();

        List<Integer> list= new ArrayList<>();

        list.add(12);
        list.add(3);
        list.add(5);
        list.add(5);
        list.add(5);
        list.add(14);
        list.add(23);
        list.add(11);
        list.add(29);
        list.add(38);
        list.add(362);


        String[] str = new String[]{"12 3 5 5 14 23 29 38","6 6 15 7 16"};
        System.out.println(str[0]);
        List<List<Integer>> resultList = dataProcessor.processPipeline(str);


        List<Integer> result = dataProcessor.processVariant18(list);
        System.out.println("Группа с наибольшим количеством элементов: "+result);
    }
}
