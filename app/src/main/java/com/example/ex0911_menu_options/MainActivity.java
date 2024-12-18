package com.example.ex0911_menu_options;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView tV_result;
    EditText eT1, eT2;

    String inputET1_str = "", inputET2_str = "";
    double inputET1 = 0, inputET2 = 0, result = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tV_result = findViewById(R.id.tV_result);
        eT1 = findViewById(R.id.eT1);
        eT2 = findViewById(R.id.eT2);
    }

    public boolean getInputET()
    {
        inputET1_str = eT1.getText().toString();
        inputET2_str = eT2.getText().toString();

        if(isValidInput(inputET1_str) && isValidInput(inputET2_str))
        {
            inputET1 = Double.parseDouble(inputET1_str);
            inputET2 = Double.parseDouble(inputET2_str);
            return true;
        }
        else
        {
            tV_result.setText("Invalid input. Please enter a valid number.");
            return false;
        }
    }

    public boolean isValidInput(String input)
    {
        if (input.isEmpty())
        {
            return false;
        }
        // check if input is a single character and is not a digit
        else if ((input.length() == 1 || input.length() == 2) && !Character.isDigit(input.charAt(0)))
        {
            return false;
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu (menu);
    }

    public boolean onOptionsItemSelected (MenuItem item) {
        int id = item.getItemId();
        if(!getInputET() && !(id == R.id.menuC))
        {
            return false;
        }

        if (id == R.id.menuPlus) {
            result = inputET1 + inputET2;
        }
        else if (id == R.id.menuMinus) {
            result = inputET1 - inputET2;
        }
        else if (id == R.id.menuMul) {
            result = inputET1 * inputET2;
        }
        else if (id == R.id.menuDiv) {
            if(inputET2 == 0)
            {
                tV_result.setText("Error: Division by zero!");
                return false;
            }
            result = inputET1 / inputET2;
        }
        else if (id == R.id.menuC)
        {
            tV_result.setText("");
            eT1.setText("");
            eT2.setText("");
            return true;
        }
        else
        {
            return false;
        }

        if(result > 100000000 || result < -100000000)
        {
            tV_result.setText("Too big of a number");
            return false;
        }
        tV_result.setText(String.format("%11.3f", (result)));
        return true;
    }

}