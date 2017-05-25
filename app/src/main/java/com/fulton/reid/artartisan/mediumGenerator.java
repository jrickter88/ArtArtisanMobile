package com.fulton.reid.artartisan;


import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by Reid on 1/28/2017.
 */

public class mediumGenerator {
    //public setting
    public String medium = "";


    public void mediumGeneratorGenerator(){




    }
    public void createrandomMedium(){
      List<String> sMedium = Arrays.asList("Ink", "Pencil", "Crayon", "MS-Paint", "Color Pencil", "Digital");


        Random rand = new Random(System.currentTimeMillis());

        int num = rand.nextInt(sMedium.size());

        medium = sMedium.get(num);


    }

    public String returnmedium(){

        return medium;


    }



}
