package com.example.belcurafaelstefanapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import org.mariuszgromada.math.mxparser.*;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

public class Calculator extends AppCompatActivity {

    private EditText displaycalculation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        displaycalculation = findViewById(R.id.calculations);
        displaycalculation.setShowSoftInputOnFocus(false);
        displaycalculation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ("Enter a value".equals(displaycalculation.getText().toString())) ;
                displaycalculation.setText("");

            }
        });

        CardView cardview = (CardView) findViewById(R.id.fiscalitycardview);

        cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Calculator.this, Fiscality.class);
                startActivity(intent);
            }
        });

        CardView cardview1 = (CardView) findViewById(R.id.cardview);
        cardview1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(Calculator.this, Json.class);
                startActivity(intent2);
            }
        });
    }

    private void updatetheText(String strToAdd) {
        String oldString = displaycalculation.getText().toString();
        int cursorPosition = displaycalculation.getSelectionStart();
        String leftString = oldString.substring(0, cursorPosition);
        String rightString = oldString.substring(cursorPosition);
        if (getString(R.string.displaycalculation).equals(displaycalculation.getText().toString())) {
            displaycalculation.setText(strToAdd);
            displaycalculation.setSelection(cursorPosition + 1);
        } else {
            displaycalculation.setText(String.format("%s%s%s", leftString, strToAdd, rightString));
            displaycalculation.setSelection(cursorPosition + 1);
        }

    }

    public void clickonequalButton(View view) {
        String userExpression = displaycalculation.getText().toString();
        userExpression = userExpression.replaceAll("÷", "/");
        userExpression = userExpression.replaceAll("×", "*");

        Expression expression = new Expression(userExpression);
        String theResult = String.valueOf(expression.calculate());

        displaycalculation.setText(theResult);
        displaycalculation.setSelection(theResult.length());
    }

    public void clickonbackspaceButton(View view) {
        int cursorPosition = displaycalculation.getSelectionStart();
        int textLength = displaycalculation.getText().length();
        if (cursorPosition != 0 && textLength != 0) {
            SpannableStringBuilder theSelection = (SpannableStringBuilder) displaycalculation.getText();
            theSelection.replace(cursorPosition - 1, cursorPosition, "");
            displaycalculation.setText(theSelection);
            displaycalculation.setSelection(cursorPosition - 1);
        }
    }

    public void clickonparenthesisButton(View view) {
        int cursorPosition = displaycalculation.getSelectionStart();
        int openParenthesis = 0;
        int closedParenthesis = 0;
        int textLength = displaycalculation.getText().length();
        for (int i = 0; i < cursorPosition; i++) {
            if (displaycalculation.getText().toString().substring(i, i + 1).equals("(")) {
                openParenthesis += 1;
            }
            if (displaycalculation.getText().toString().substring(i, i + 1).equals(")")) {
                closedParenthesis += 1;
            }

        }
        if (openParenthesis == closedParenthesis || displaycalculation.getText().toString().substring(textLength - 1, textLength).equals("(")) {
            updatetheText("(");
            displaycalculation.setSelection(cursorPosition + 1);
        }
        else if(closedParenthesis < openParenthesis && !displaycalculation.getText().toString().substring(textLength -1, textLength).equals("(")) {

            updatetheText(")");
        }
        displaycalculation.setSelection(cursorPosition + 1);
    }

    public void clickonpointButton(View view) {
        updatetheText(".");
    }

    public void clickonzeroButton(View view) {
        updatetheText("0");
    }

    public void clickononeButton(View view) {
        updatetheText("1");
    }

    public void clickontwoButton(View view) {
        updatetheText("2");
    }

    public void clickonthreeButton(View view) {
        updatetheText("3");
    }

    public void clickonfourButton(View view) {
        updatetheText("4");
    }

    public void clickonfiveButton(View view) {
        updatetheText("5");
    }

    public void clickonsixButton(View view) {
        updatetheText("6");
    }

    public void clickonsevenButton(View view) {
        updatetheText("7");
    }

    public void clickoneightButton(View view) {
        updatetheText("8");
    }

    public void clickonnineButton(View view) {
        updatetheText("9");
    }

    public void clickonmultiplyButton(View view) {
        updatetheText("×");
    }

    public void clickondivideButton(View view) {
        updatetheText("÷");
    }

    public void clickonsubtractButton(View view) {
        updatetheText("-");
    }

    public void clickonaddButton(View view) {
        updatetheText("+");
    }

    public void clickonclearButton(View view) {
        displaycalculation.setText("");
    }

    public void clickonexpButton(View view) {
        updatetheText("^");
    }

    public void clickonplusMinusButton(View view) {
        updatetheText("-");
    }

}
