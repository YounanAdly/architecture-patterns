package com.alyndroid.architecturepatternstutorialshomework.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.alyndroid.architecturepatternstutorialshomework.database.DataBase;
import com.alyndroid.architecturepatternstutorialshomework.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,
        //MVP
        NumberView {

    TextView plus_result_textView,
            div_result_textView,
            mul_result_textView;
    Button plus_button,
            div_button,
            mul_button;

    //MVP
    NumberPresenter presenter;

    //MVVM
    NumberViewModel numberViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        plus_result_textView = findViewById(R.id.plus_result_textView);
        div_result_textView = findViewById(R.id.div_result_textView);
        mul_result_textView = findViewById(R.id.mul_result_textView);

        plus_button = findViewById(R.id.plus_button);
        div_button = findViewById(R.id.div_button);
        mul_button = findViewById(R.id.mul_button);

        plus_button.setOnClickListener(this);
        div_button.setOnClickListener(this);
        mul_button.setOnClickListener(this);

        //MVP
        presenter = new NumberPresenter(this);

        //MVVM
        numberViewModel = ViewModelProviders.of(this).get(NumberViewModel.class);
        numberViewModel.numberMulMutableLiveData.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer number) {
                mul_result_textView.setText(String.valueOf(number));
            }
        });
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.plus_button) {
            //MVC
            plus_result_textView.setText(String.valueOf(DataBase.getNumbers().getFirstNum() + DataBase.getNumbers().getSecondNum()));
        }

        if (view.getId() == R.id.div_button) {
            //MVP
            presenter.getNumberDiv();
        }

        if (view.getId() == R.id.mul_button) {
            //MVVM
            numberViewModel.getNumberMul();
        }
    }

    //MVP
    @Override
    public void onGetNumberDiv(int a) {
        div_result_textView.setText(String.valueOf(a));

    }
}
