package com.alyndroid.architecturepatternstutorialshomework.ui;

import com.alyndroid.architecturepatternstutorialshomework.database.DataBase;

class NumberPresenter {

    private NumberView view;

    NumberPresenter(NumberView view) {
        this.view = view;
    }


    void getNumberDiv(){
        view.onGetNumberDiv(DataBase.getNumbers().getFirstNum() / DataBase.getNumbers().getSecondNum());
    }
}
