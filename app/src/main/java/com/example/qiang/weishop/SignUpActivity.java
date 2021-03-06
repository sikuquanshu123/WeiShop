package com.example.qiang.weishop;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    private Button local;
    private EditText phone_sum;
    private TextView manager_guifan;
    private TextView service_xieyi;
    private Button sign_up_main;

    void initial() {
        sign_up_main = (Button) findViewById(R.id.sign_up_main);
        local = (Button) findViewById(R.id.local_sum);
        phone_sum = (EditText) findViewById(R.id.phone_sum);
        manager_guifan = (TextView) findViewById(R.id.manager_guifan);
        service_xieyi = (TextView) findViewById(R.id.service_xieyi);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//设置返回
        getSupportActionBar().setDisplayShowTitleEnabled(false);//去掉原有标题

        initial();

        sign_up_main.setOnClickListener(this);
        sign_up_main.setClickable(false);
        local.setOnClickListener(this);
        phone_sum.setInputType(EditorInfo.TYPE_CLASS_NUMBER);
        phone_sum.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // TODO Auto-generated method stub
                int len_phone = s.length();
                if (len_phone > 0) {
                    sign_up_main.setClickable(true);
                    sign_up_main.setBackgroundResource(R.drawable.shape_dark);
                    sign_up_main.setTextColor((Color.parseColor("#FFFFFF")));

                } else {
                    sign_up_main.setClickable(false);
                    sign_up_main.setBackgroundResource(R.drawable.shape_light);
                    sign_up_main.setTextColor((Color.parseColor("#F6D8DB")));
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub

            }
        });
        manager_guifan.setClickable(true);
        manager_guifan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUpActivity.this, BaseWebViewActivity.class));
            }
        });
        service_xieyi.setClickable(true);
        service_xieyi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(SignUpActivity.this, BaseWebViewActivity.class));
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.local_sum:
                startActivityForResult(new Intent(SignUpActivity.this, CountryActivity.class), 0);
                break;

            case R.id.sign_up_main:

                int len_phone=phone_sum.getText().length();
                if (len_phone==11) {
                    Intent next = new Intent(SignUpActivity.this, SignUpNextActivity.class);
                    next.putExtra("phone", phone_sum.getText().toString());
                    startActivity(next);
                }
                else {
                    Toast.makeText(this,"请输入正确的手机号",Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Button local_sum = (Button) findViewById(R.id.local_sum);
        TextView local_title = (TextView) findViewById(R.id.local_title);
        if (data != null) {
            local_sum.setText(data.getStringExtra("name"));
            local_title.setText(data.getStringExtra("count"));
        }
    }

}
