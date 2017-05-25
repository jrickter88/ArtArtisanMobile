package com.fulton.reid.artartisan;


import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by Reid on 1/28/2017.
 */

public class styleGenerator {
    //public setting
    public String style = "";


    public void styleGeneratorGenerator(){




    }
    public void createrandomStyle(){
      List<String> sstyle = Arrays.asList("Classical", "Retro", "Noir", "Renissance", "Impressionism", "Charicature");


        Random rand = new Random(System.currentTimeMillis());

        int num = rand.nextInt(sstyle.size());

        style = sstyle.get(num);


    }

    public String returnstyle(){

        return style;


    }



}
