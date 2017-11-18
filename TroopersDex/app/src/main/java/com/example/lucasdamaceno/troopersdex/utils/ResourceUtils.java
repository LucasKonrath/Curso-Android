package com.example.lucasdamaceno.troopersdex.utils;

import com.example.lucasdamaceno.troopersdex.R;
import com.example.lucasdamaceno.troopersdex.model.Affiliation;

/**
 * Created by lucas.damaceno on 18/11/2017.
 */

public class ResourceUtils {

    public static int getResourceBasedOnAffiliation(Affiliation affiliation){

        switch (affiliation){
            case GALACTIC_REPUBLIC:
                return R.drawable.galactic_republic;
            case GALACTIC_EMPIRE:
                return  R.drawable.galactic_empire;
            case FIRST_ORDER:
                return R.drawable.first_order;
            default:
                return 0;
        }
    }
}
