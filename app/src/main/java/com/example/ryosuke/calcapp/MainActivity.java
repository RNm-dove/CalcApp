package com.example.ryosuke.calcapp;

import android.content.Intent;
import android.renderscript.Float2;
import android.renderscript.ScriptGroup;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText text1;
    EditText text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text1 = (EditText) findViewById(R.id.text1);
        text2 = (EditText) findViewById(R.id.text2);
        text1.setInputType(InputType.TYPE_CLASS_NUMBER);//入力制限　TYPE_CLASS_NUMBERは数値　
        text2.setInputType(InputType.TYPE_CLASS_NUMBER);

        Button button_plus = (Button) findViewById(R.id.button_plus);
        button_plus.setOnClickListener(this);

        Button button_minus = (Button) findViewById(R.id.button_minus);
        button_minus.setOnClickListener(this);

        Button button_times = (Button) findViewById(R.id.button_times);
        button_times.setOnClickListener(this);

        Button button_divided = (Button) findViewById(R.id.button_divided);
        button_divided.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){

        String editstr1 = text1.getText().toString();
        String editstr2 = text2.getText().toString();

        //数値が入力されてない場合の処理
        if (editstr1.matches("") || editstr2.matches("")){
            Toast.makeText(this,"数値を入力してください",Toast.LENGTH_SHORT).show();
            return;
        }

        Float value1 =Float.valueOf(editstr1);
        Float value2 =Float.valueOf(editstr2);

        //Intent 作成
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("VALUE1", value1);
        intent.putExtra("VALUE2", value2);

        //四則演算の場合分け
        switch (v.getId()){
            case R.id.button_plus :
                intent.putExtra("OPERATE",1);
                break;
            case R.id.button_minus :
                intent.putExtra("OPERATE",2);
                break;
            case R.id.button_times :
                intent.putExtra("OPERATE",3);
                break;
            case R.id.button_divided :
                intent.putExtra("OPERATE",4);
                break;
            default: break;
        }

        startActivity(intent);
    }
}
