package com.example.developer.seplayout;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity{
    EditText idEt, passwordEt;
    Button registerBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        initView();
        setListener();
    }

    private void setListener() {
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                String id = idEt.getText().toString();
                String password = passwordEt.getText().toString();
                Bundle bundle = new Bundle();
                bundle.putString("ID", id);
                bundle.putString("Password", password);
                intent.putExtra("Bundle", bundle);
                startActivity(intent);
            }
        });
    }

    private void initView() {
        idEt = findViewById(R.id.editText);
        passwordEt = findViewById(R.id.editText4);
        registerBtn = findViewById(R.id.button);
    }
}
