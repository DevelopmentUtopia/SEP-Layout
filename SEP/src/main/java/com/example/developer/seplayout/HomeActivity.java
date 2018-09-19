package com.example.developer.seplayout;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity{
    CardView cardView1;
    TextView CW1_tv;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        initView();
        setListener();
    }

    private void setListener() {
        CharSequence text = CW1_tv.getText();
        SpannableString spannableString = new SpannableString(text);
        spannableString.setSpan(new ClickableSpan() {

            @Override
            public void onClick(View widget) {
                Toast.makeText(HomeActivity.this, "Subscribe success!", Toast.LENGTH_SHORT).show();
            }
        }, 0, text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        NoUnderlineSpan span = new NoUnderlineSpan();
        spannableString.setSpan(span, 0, text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        spannableString.setSpan(new ForegroundColorSpan(Color.rgb(95, 202, 243)), 0, text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        CW1_tv.setText(spannableString);
        CW1_tv.setMovementMethod(LinkMovementMethod.getInstance());
    }

    private void initView() {
        cardView1 = findViewById(R.id.CW1);
        CW1_tv = findViewById(R.id.CW1_tv1);
    }

    public class NoUnderlineSpan extends UnderlineSpan {
        @Override
        public void updateDrawState(TextPaint ds) {
            ds.setUnderlineText(false);
        }
    }
}
