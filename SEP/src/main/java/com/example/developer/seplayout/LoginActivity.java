package com.example.developer.seplayout;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    Button loginBtn;
    TextView registerTv;
    EditText idEt, passwordEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        initView();
        setListener();
        if(getIntent() != null){
            Bundle bundle = getIntent().getBundleExtra("Bundle");
            if(bundle != null){
                String id = bundle.getString("ID");
                String password = bundle.getString("Password");
                idEt.setText(id);
                passwordEt.setText(password);
            }
        }
    }

    private void setListener() {
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).
                        show();
                startActivity(new Intent(LoginActivity.this, HomeActivity.class));
            }
        });

        CharSequence text = registerTv.getText();
        SpannableString spannableString = new SpannableString(text);
        spannableString.setSpan(new ClickableSpan() {

            @Override
            public void onClick(View widget) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        }, 23, text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        NoUnderlineSpan span = new NoUnderlineSpan();
        spannableString.setSpan(span, 23, text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        spannableString.setSpan(new ForegroundColorSpan(Color.rgb(95, 202, 243)), 23, text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        registerTv.setText(spannableString);
        registerTv.setMovementMethod(LinkMovementMethod.getInstance());

    }

    private void initView() {
        loginBtn = findViewById(R.id.loginBtn);
        registerTv = findViewById(R.id.registerTv);
        idEt = findViewById(R.id.editText2);
        passwordEt = findViewById(R.id.editText3);
    }

    public class NoUnderlineSpan extends UnderlineSpan {
        @Override
        public void updateDrawState(TextPaint ds) {
            ds.setUnderlineText(false);
        }
    }

}
