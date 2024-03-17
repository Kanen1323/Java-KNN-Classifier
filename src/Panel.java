import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Panel {



    private static final Panel instanse = new Panel();



    private Panel() {
    }


    public static Panel getInstance() {
        return instanse;
    }



    public static String classifications(double[] dany, List<Classification> classifications, int k,List<String> program_answer) {

        classifications = distance_calculation(dany, classifications);

        Classification.sort(classifications);
        String classyficacja = null;

        Map<String, Integer> list = new HashMap<>();

        for (int i = 0; i < k; i++) {

            list.put(classifications.get(i).getType(), list.getOrDefault(classifications.get(i).getType(), 0) + 1);


        }

        int count = 0;
        for (Map.Entry<String, Integer> entry : list.entrySet()) {
            if (entry.getValue() > count) {
                count = entry.getValue();
                classyficacja = entry.getKey();

            }


        }
        program_answer.add(classyficacja);

        return classyficacja;

    }
    public static  List<Classification> distance_calculation(double[] dany,  List<Classification> classifications){


        for (int i = 0; i <classifications.size() ; i++) {
            classifications.get(i).setDistance(Math.sqrt((Math.pow(classifications.get(i).getDany()[0]-dany[0],2)))
                    +Math.sqrt((Math.pow(classifications.get(i).getDany()[1]-dany[1],2)))
                    +Math.sqrt((Math.pow(classifications.get(i).getDany()[2]-dany[2],2)))
                    +Math.sqrt((Math.pow(classifications.get(i).getDany()[3]-dany[3],2)))
            );

        }

        return classifications;

    }

    public static void print_information(List<Classification> list){

        Map<String,Integer> map = new HashMap<>();


        for (int i = 0; i <list.size() ; i++) {

            map.put(list.get(i).getType(), map.getOrDefault(list.get(i).getType(),0)+1);


        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("This file contains an " +entry.getKey()  + " in the following quantity " + entry.getValue());


        }


    }
    public void start(){


        int choice = 1;
        List<Classification> classifications = new ArrayList<>();
        List<Classification> result = new ArrayList<>();
        String my_data;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please write k");
        int k=scanner.nextInt();
        scanner.nextLine();
        List<String> right_answer = new ArrayList<>();
        List<String> program_answer = new ArrayList<>();

        while (choice!=0){
            classifications.clear();
            result.clear();
            training_file(classifications);



            System.out.println("Write your choice \n" +
                    "0-exit \n" +
                    "1-Use a ready-made path file \n" +
                    "2-Write path for test file + \n" +
                    "3-change k \n" +
                    "4-print your data");
            int coise=scanner.nextInt();
            switch (coise){

                case 1:
                    right_answer.clear();
                    program_answer.clear();
                    try {
                        BufferedReader buff = new BufferedReader(new FileReader(new File("D:\\Java\\TPO\\KNN\\src\\test.text"))) ;
                        String line;
                        while ((line=buff.readLine())!=null){
                            String[] split = line.split(",");
                            double[] dany = {Double.parseDouble(split[0]),Double.parseDouble(split[1]),Double.parseDouble(split[2]),Double.parseDouble(split[3])};

                            result.add(new Classification(dany, Panel.classifications(dany,classifications,k,program_answer)));
                            right_answer.add(split[4]);
                        }


                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    Panel.print_information(result);
                    System.out.println("procent of right " + procent(right_answer,program_answer) + "%");

                    break;
                case 2:
                    right_answer.clear();
                    program_answer.clear();
                    scanner.nextLine();
                    System.out.println("Write path");
                    String path=scanner.nextLine();
                    try {
                        BufferedReader buff = new BufferedReader(new FileReader(new File(path))) ;
                        String line;
                        while ((line=buff.readLine())!=null){
                            String[] split = line.split(",");
                            double[] dany = {Double.parseDouble(split[0]),Double.parseDouble(split[1]),Double.parseDouble(split[2]),Double.parseDouble(split[3])};

                            result.add(new Classification(dany, Panel.classifications(dany,classifications,k,program_answer)));
                            right_answer.add(split[4]);
                        }




                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    Panel.print_information(result);
                    System.out.println("procent of right " + procent(right_answer,program_answer) + "%");
                    break;


                case 3:
                    System.out.println("Please change k");
                    k=scanner.nextInt();


                    break;
                case 4:
                    System.out.println("Please write 4 numbers");
                    scanner.nextLine();
                    my_data= scanner.nextLine();


                    split(my_data,classifications,k,result,program_answer);


            }





        }





    }
    public static void training_file(List<Classification> classifications){


        try {
            BufferedReader buff = new BufferedReader(new FileReader(new File("D:\\Java\\TPO\\KNN\\src\\traning.txt"))) ;
            String line;
            while ((line=buff.readLine())!=null){
                String[] split = line.split(",");
                double[] dany = {Double.parseDouble(split[0]),Double.parseDouble(split[1]),Double.parseDouble(split[2]),Double.parseDouble(split[3])};
                classifications.add(new Classification(dany,split[4]));


            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public static void split(String my_data, List<Classification> classifications, int k, List<Classification> result,List<String> program_answer) {
        result.clear();
        String[] split = my_data.split(",");
        if (split.length != 4) {
            System.out.println("Please write 4 numbers separated by commas.");
            return;
        }
        double[] dany = new double[4];
        try {
            for (int i = 0; i < 4; i++) {
                dany[i] = Double.parseDouble(split[i]);
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input format. Please enter numeric values separated by commas.");
            return;
        }
        result.add(new Classification(dany, Panel.classifications(dany, classifications, k,program_answer)));
        distance_calculation(dany,classifications);

        System.out.println(classifications(dany,classifications,k,program_answer));
    }


    public static double procent(List<String> right_answer,List<String> program_answer){
        double count = 0;



        for (int i = 0; i <right_answer.size() ; i++) {
            if (right_answer.get(i).equals(program_answer.get(i))){
                count++;
            }

        }





        return count/right_answer.size()*100;
    }


}



