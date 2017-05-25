package com.fulton.reid.artartisan;


import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by Reid on 1/28/2017.
 */

public class settingGenerator {
    //public setting
    public String setting = "";


    public void SettingGenerator(){




    }
    public void createrandomSetting(){

        List<String> sSetting = Arrays.asList("Woodlands", "Desert", "Snowy Artic", "Mountains", "Garden", "Ocean Road", "Jungle", "Lair", "Car",
                "Barn", "Bayou","Tomb","Train","Farmhouse","Castle",
                "Church","Prarie","Highlands","Morgue","Beneath the Sea","Beach","Volcano","Kitchen","The Sea","Cemetary","Bedroom");


        Random rand = new Random();

        int num = rand.nextInt(sSetting.size());

        setting = sSetting.get(num);


    }

    public String returnsetting(){

        return setting;


    }



}
