package com.example.ryosuke.calcapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    Float answer;//後にswich分岐で計算値を入れる変数

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        Float value1 = intent.getFloatExtra("VALUE1",1);//VALUEの値をfloat型として取得
        Float value2 = intent.getFloatExtra("VALUE2",1);
        int ope = intent.getIntExtra("OPERATE",5);

       // Log.d("VALUE1,VALUE2,OPERATE:",String.valueOf(value1)+","+String.valueOf(value2)+","+String.valueOf(ope));

        TextView textView = (TextView) findViewById(R.id.textView);

        //opeの値により四則演算の場合分け
        switch (ope){
            case 1:
                answer = value1 + value2;
                break;
            case 2:
                answer = value1 - value2;
                break;
            case 3:
                answer = value1 * value2;
                break;
            case 4:
                answer = value1 / value2;
                break;
            default: answer = 0f;
                break;
        }
        textView.setText(String.valueOf(answer));
    }
}
