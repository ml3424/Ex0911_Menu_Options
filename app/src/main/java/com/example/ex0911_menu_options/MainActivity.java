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
    int inputET1 = 0, inputET2 = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tV_result = findViewById(R.id.tV_result);
        eT1 = findViewById(R.id.eT1);
        eT2 = findViewById(R.id.eT2);
    }


    @Override
    public boolean onCreateOptionsMenu (Menu menu) {

        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu (menu);
    }


    public boolean onOptionsItemSelected (MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.menuPlus) {
            tV_result.setText("%.3f" + (inputET1 + inputET2));
            return true;
        }
        else if (id == R.id.menuMinus) {
            tV_result.setText("%.3f" + (inputET1 - inputET2));
            return true;
        }
        else if (id == R.id.menuMul) {
            tV_result.setText("%.3f" + (inputET1 * inputET2));
            return true;
        }
        else if (id == R.id.menuDiv) {
            if(inputET2 == 0)
            {
                tV_result.setText("Error: Division by zero!");
                return false;
            }
            tV_result.setText("%.3f" + (inputET1 / inputET2));
            return true;
        }

        return false;
    }

}