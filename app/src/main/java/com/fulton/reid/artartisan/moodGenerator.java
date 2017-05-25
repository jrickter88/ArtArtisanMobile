package com.fulton.reid.artartisan;


import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by Reid on 1/28/2017.
 */

public class moodGenerator {
    //public setting
    public String mood = "";


    public void moodGeneratorGenerator(){




    }
    public void createrandomMood(){

        List<String> smood = Arrays.asList("Melencholy", "Fearful", "Happy", "Mischevious", "Playful", "Devious", "Angry", "Sarcastic", "Restless",
                "Worrisome", "Helpless");


        Random rand = new Random(System.currentTimeMillis());

        int num = rand.nextInt(smood.size());

        mood = smood.get(num);


    }

    public String returnMood(){

        return mood;


    }



}
