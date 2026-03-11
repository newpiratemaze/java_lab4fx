package console;

import core.DataProcessor;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import core.*;

public class ConsoleApp
{
    FileUtils fu = new FileUtils();
    InputArgs params = new InputArgs();
    public void main(String[] args)
    {
        DataProcessor dataProcessor = new DataProcessor();


//        List<Integer> list= new ArrayList<>();
//
//        list.add(12);
//        list.add(3);
//        list.add(5);
//        list.add(5);
//        list.add(5);
//        list.add(14);
//        list.add(23);
//        list.add(11);
//        list.add(29);
//        list.add(38);
//        list.add(362);
//
//
//        String[] str = new String[]{"12 3 5 5 14 23 29 38","6 6 15 7 16"};
//        System.out.println(str[0]);


        params = parseCmdArgs(args);

        String fullText = fu.ReadFromFileConsole(params);
        String[] str = fullText.split("\n");
        List<List<Integer>> resultList = dataProcessor.processPipeline(str);

        System.out.println(resultList);

        fu.SaveToFileConsole(resultList,params);
        //List<Integer> result = dataProcessor.processVariant18(list);
        //System.out.println("Группа с наибольшим количеством элементов: "+result);
    }



    public InputArgs parseCmdArgs(String[] args) {
        InputArgs result = new InputArgs();

        for (int i = 0; i < args.length; i++) {
            switch (args[i])
            {
                case "-i" -> result.inputFile = args[++i];
                case "-o" -> result.outputFile = args[++i];
            }
        }
        return result;
    }
}
