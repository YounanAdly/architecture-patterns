package com.alyndroid.architecturepatternstutorialshomework.database;

import com.alyndroid.architecturepatternstutorialshomework.pojo.NumberModel;

public class DataBase {
    public static NumberModel getNumbers(){
        return new NumberModel(4, 2);
    }
}
