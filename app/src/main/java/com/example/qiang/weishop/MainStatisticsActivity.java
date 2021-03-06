package com.example.qiang.weishop;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static android.preference.PreferenceManager.getDefaultSharedPreferences;

public class MainStatisticsActivity extends AppCompatActivity implements View.OnClickListener {

    public SharedPreferences pref_default;
    public SharedPreferences.Editor editor;
    public SharedPreferences pref;

    private TextView textView_statistics_user_id;
private Button button_statistics_bottom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_statistics);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//设置返回
        getSupportActionBar().setDisplayShowTitleEnabled(false);//去掉原有标题

        initial();
        textView_statistics_user_id.setText(pref.getString("user_id", ""));
        button_statistics_bottom.setBackgroundColor(getResources().getColor(R.color.statistics_bottom_button));
        button_statistics_bottom.setOnClickListener(this);
    }

    void initial(){

        pref_default = getDefaultSharedPreferences(this);
        editor = getSharedPreferences("default", MODE_PRIVATE).edit();
        pref = getSharedPreferences("default", MODE_PRIVATE);

        textView_statistics_user_id=(TextView)findViewById(R.id.statistics_user_id);
        button_statistics_bottom=(Button)findViewById(R.id.statistics_bottom);
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
        switch (v.getId()){
            case R.id.statistics_bottom:
                startActivity(new Intent(MainStatisticsActivity.this,RaidersActivity.class));
                break;
        }
    }
}
