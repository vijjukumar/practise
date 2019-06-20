package com.vijju.functionalI;

import java.util.function.Function;
import java.util.Date;
import java.io.BufferedInputStream;

/**
 * Created by e088740 on 2/24/2019.
 */
public class MainClass {

    public static void main(String... args) throws  Exception{

        ProcessTN70 process = new ProcessTN70();
        process.readFile();

        String header="HIP755120-AA     000000179440083895\n";
        String ica = ProcessTN70.parseField(header,ProcessTN70.HEADER_ICA_OFFSET,ProcessTN70.HEADER_ICA_LEN) ;
        System.out.println("ica "+ica);

        Function<Integer, Integer> num = (value) -> value + 3;
        Integer result = num.apply(8);
        System.out.println("tota  ---" + result);

        FunctionalInterfaces fn = (String name) -> {
            System.out.print("name is " + name);
            return 10;

        };
        Integer results = fn.accountSummary("test");
        String name;
        String teypes;
        String next;
        if(true){
            String nams;
        }


    }
}
