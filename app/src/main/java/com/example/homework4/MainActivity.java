package com.example.homework4;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });

        TextView textViewEntrance = findViewById(R.id.text_entrance);
        TextView textViewEnter = findViewById(R.id.text_enter);
        EditText editTextEmail = findViewById(R.id.email);
        EditText editTextPassword = findViewById(R.id.password);
        Button buttonEnter = findViewById(R.id.button_enter);
        MaterialButton buttonForgot = findViewById(R.id.button_forgot);

        buttonEnter.setOnClickListener(view -> {
            if (editTextEmail.getText().toString().equals("admin") && editTextPassword.getText().toString().equals( "admin")){
                Toast.makeText(this, "Вы успешно зарегистрировались", Toast.LENGTH_LONG).show();
                textViewEntrance.setVisibility(View.GONE);
                textViewEnter.setVisibility(View.GONE);
                editTextEmail.setVisibility(View.GONE);
                editTextPassword.setVisibility(View.GONE);
                buttonEnter.setVisibility(View.GONE);
                buttonForgot.setVisibility(View.GONE);
            }else {
                Toast.makeText(this, "Неправильный логин и пароль", Toast.LENGTH_LONG).show();
            }
        });


        editTextEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
                buttonEnter.setEnabled(charSequence.length() > 0);
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
    }


}