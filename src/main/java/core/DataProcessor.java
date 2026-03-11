package core;

import java.util.ArrayList;
import java.util.List;

public class DataProcessor
{
    public List<List<Integer>> processPipeline(String[] str)
    {
        List<List<Integer>> resultList = new ArrayList<>();

        for(int i=0;i<str.length;i++)
        {
            String[] strElem = str[i].split(" ");
            for(int j = 0;j<strElem.length;j++)
            {
                System.out.print(strElem[j]+" ");
            }
            //System.out.println("strElem: "+strElem);


            List<Integer> lst = new ArrayList<>();

            for(int j = 0;j<strElem.length;j++)
            {
                lst.add(Integer.parseInt(strElem[j]));
                //System.out.println("lst: "+lst);
            }

            List<Integer> result = processVariant18(lst);
            resultList.add(result);
            System.out.println("Группа с наибольшим количеством элементов: "+result);
            System.out.println(" ");
        }

        return resultList;
    }


    public List<Integer> processVariant18(List<Integer> list)
    {
        List<Integer> result = new ArrayList<>();

        List<List<Integer>> groupList = new ArrayList<>();

        List<Integer> lst = new ArrayList<>();
        lst.add(list.get(0));

        groupList.add(lst);

        for(int i=1;i<list.size();i++)
        {
            boolean addFlag = false;

            int elem1 = list.get(i);
            int elSum1 = sumOfElems(elem1);

            for(int j=0;j<groupList.size();j++)
            {
                int elem2 = groupList.get(j).get(0);
                int elSum2 = sumOfElems(elem2);
                if(elSum2 == elSum1)
                {
                    groupList.get(j).add(elem1);
                    addFlag = true;
                    break;
                }

            }
            if(addFlag==false)
            {
                List<Integer> group = new ArrayList<>();
                group.add(elem1);
                groupList.add(group);
            }

        }
        for(int i = 0;i< groupList.size();i++)
        {
            System.out.println("Группа "+i+": "+groupList.get(i));

            if(groupList.get(i).size()>result.size())
            {
                result = groupList.get(i);
            }

        }

        //System.out.println(" ");


        return result;
    }

    public int sumOfElems(int num)
    {
        int elemSum = 0;
        String[] elems = (String.valueOf(num)).split("");
        for(int j=0;j<elems.length;j++)
        {
            elemSum+=Integer.parseInt(elems[j]);
        }

        return elemSum;
    }
}
