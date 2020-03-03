package com.alyndroid.architecturepatternstutorialshomework.ui;

import com.alyndroid.architecturepatternstutorialshomework.database.DataBase;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NumberViewModel extends ViewModel {

     MutableLiveData<Integer> numberMulMutableLiveData = new MutableLiveData<>();

    public void getNumberMul(){
        numberMulMutableLiveData.setValue(DataBase.getNumbers().getFirstNum() * DataBase.getNumbers().getSecondNum());
    }
}
