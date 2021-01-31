package com.example.d5_new_project_java;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;

public class MainActivity extends AppCompatActivity {


    /**
     * Variables:
     *
     * Declare - [Access Modifier][type][name]; (default: default (check permissions on "default"!))
     * Example - private String address;
     * Example - private int age;
     * initialize - Create a new instance of the declared type
     * Example - private String address = "123 sesame street"
     * Example - age = 55;
     * primitive types: int, float, long, short, double, byte, bool, char
     * other types - String, Integer, Long, etc
     * can also create own custom types (classes?)
     */

    /**
     *     METHODS
     * Declare - [Access Modifier][Type][Name(PARAMS)]
     * Example - public String getName() {return "";}
     * Example - public int add (int num1, int num2) {return num1 + num2; }
     */

    /**
     * STEPS TO REFERENCING XML VIEWS IN A LAYOUT
     * Declare the View - private MaterialTextView tvDisplay;
     * Initialize the view - tvDisplay = findViewByID(R.id.tv_display);
     * use the view - tvDisplay.setText("Hello World");
     * */
    private MaterialTextView outputDisplay;
    private MaterialTextView inputDisplay;
    private int inputValue;
    private int outputDisplayValue;


    final int[] numberButtonIDs = new int[] {R.id.button_1, R.id.button_2, R.id.button_3, R.id.button_4,
    R.id.button_5, R.id.button_6, R.id.button_7, R.id.button_8, R.id.button_9, R.id.button_0};
    private MaterialButton[] btnViews = new MaterialButton[10];
    final int[] operatorButtonIDS = new int[] {R.id.button_add, R.id.button_subtract, R.id.button_multiply, R.id.button_divide};
    private MaterialButton[] operatorViews = new MaterialButton[4];


    private int operation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        outputDisplay = findViewById(R.id.results_field);
        inputDisplay = findViewById(R.id.input_field);

        for (int i = 0; i < 10; i++)
        {
            final int iterator = i;
            btnViews[i] = findViewById(numberButtonIDs[i]);
            btnViews[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    inputDisplay.append(btnViews[iterator].getText().toString());
                }
            });
        }
        for (int j = 0; j < 4; j++){
            final int k = j;
            operatorViews[j] = findViewById(operatorButtonIDS[j]);
            operatorViews[j].setOnClickListener(new View.OnClickListener(){
               @Override
               public void onClick(View v) {
                   operation = k;
               }
            });
        }
        findViewById(R.id.button_equal).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputValue = Integer.parseInt(inputDisplay.getText().toString());
                outputDisplayValue = Integer.parseInt(outputDisplay.getText().toString());
                switch(operation)
                {
                    case 0:
                        outputDisplay.setText(String.valueOf(inputValue + outputDisplayValue));
                        inputDisplay.setText("");
                        break;
                    case 1:
                        outputDisplay.setText(String.valueOf(outputDisplayValue - inputValue));
                        inputDisplay.setText("");
                        break;
                    case 2:
                        outputDisplay.setText(String.valueOf(outputDisplayValue * inputValue));
                        inputDisplay.setText("");
                        break;
                    case 3:
                        outputDisplay.setText(String.valueOf(outputDisplayValue / inputValue));
                        inputDisplay.setText("");
                        break;
                    default:
                        break;
                }
            }
        });



    }
}