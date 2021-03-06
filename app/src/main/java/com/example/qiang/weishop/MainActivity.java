package com.example.qiang.weishop;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import static android.preference.PreferenceManager.getDefaultSharedPreferences;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView textView_user_id;
    private ViewPager viewPager;
    private ArrayList<View> pageview;

    //包裹点点的LinearLayout
    private ViewGroup group;
    private ImageView dotView;
    private ImageView[] dotViews;

    private ImageView imageView_kaidangonglue;
    private ImageView imageView_setting;
    private ImageView imageView_notification;

    public SharedPreferences pref_default;
    public SharedPreferences.Editor editor;
    public SharedPreferences pref;

    int main_items[] = {R.layout.main_item1, R.layout.main_item2};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        //查找布局文件用LayoutInflater.inflate
        LayoutInflater inflater = getLayoutInflater();
        pageview = new ArrayList<>();
        for (int i = 0; i < main_items.length; i++) {
            //将view装入数组
            pageview.add(inflater.inflate(main_items[i], null));
        }
        group = (ViewGroup) findViewById(R.id.viewgroup);
        dotViews = new ImageView[pageview.size()];
        for (int i = 0; i < pageview.size(); i++) {
            dotView = new ImageView(MainActivity.this);
            dotView.setLayoutParams(new ViewGroup.LayoutParams(35, 15));
            dotView.setPadding(0, 0, 0, 0);
            dotViews[i] = dotView;

            // 默认进入程序后第一张图片被选中;
            if (i == 0) {
                dotViews[i].setBackgroundResource(R.drawable.switch_3);
            } else {
                dotViews[i].setBackgroundResource(R.drawable.switch_4);
            }
            group.addView(dotViews[i]);
        }

        initial();

        pref_default = getDefaultSharedPreferences(this);
        editor = getSharedPreferences("default", MODE_PRIVATE).edit();
        pref = getSharedPreferences("default", MODE_PRIVATE);

        textView_user_id.setText(pref.getString("user_id", ""));
        imageView_kaidangonglue.setOnClickListener(this);
        imageView_notification.setOnClickListener(this);
        imageView_setting.setOnClickListener(this);

        //数据适配器
        PagerAdapter mPagerAdapter = new PagerAdapter() {

            @Override
            //获取当前窗体界面数
            public int getCount() {
                // TODO Auto-generated method stub
                return pageview.size();
            }

            @Override
            //断是否由对象生成界面
            public boolean isViewFromObject(View arg0, Object arg1) {
                // TODO Auto-generated method stub
                return arg0 == arg1;
            }

            //是从ViewGroup中移出当前View
            public void destroyItem(View arg0, int arg1, Object arg2) {
                ((ViewPager) arg0).removeView(pageview.get(arg1));
            }

            //返回一个对象，这个对象表明了PagerAdapter适配器选择哪个对象放在当前的ViewPager中
            public Object instantiateItem(View arg0, int arg1) {
                ((ViewPager) arg0).addView(pageview.get(arg1));
                return pageview.get(arg1);
            }
        };
        //  dotview = (ViewGroup) inflater.inflate(R.layout.login_dot, null);
        // group是R.layou.main中的负责包裹小圆点的LinearLayout.

        //绑定适配器
        viewPager.setAdapter(mPagerAdapter);
        //设置监听
        viewPager.setOnPageChangeListener(new MyListener());
        //绑定监听事件
    }

    void initial() {
        imageView_kaidangonglue = (ImageView) findViewById(R.id.main_kaidangonglue);
        imageView_setting = (ImageView) findViewById(R.id.main_setting);
        imageView_notification = (ImageView) findViewById(R.id.main_tongzhi);
        textView_user_id = (TextView) findViewById(R.id.user_id);
    }

    public void main_button_note_click(View view) {
        startActivity(new Intent(MainActivity.this, MainNoteActivity.class));
    }

    public void main_button_commodity_click(View view) {
        startActivity(new Intent(MainActivity.this, MainCommodityActivity.class));
    }

    public void main_button_Order_click(View view) {
        startActivity(new Intent(MainActivity.this, MainOrderActivity.class));
    }

    public void main_button_statistics_click(View view) {
        startActivity(new Intent(MainActivity.this, MainStatisticsActivity.class));
    }

    public void main_button_client_click(View view) {
        startActivity(new Intent(MainActivity.this, MainClientActivity.class));
    }

    public void main_button_income_click(View view) {
        startActivity(new Intent(MainActivity.this, MainIncomeActivity.class));
    }

    public void main_button_Promotion_click(View view) {
        startActivity(new Intent(MainActivity.this, MainPromotionActivity.class));
    }

    public void main_button_service_click(View view) {
        startActivity(new Intent(MainActivity.this, MainServiceActivity.class));
    }

    public void main_button_Supply_from_click(View view) {
        startActivity(new Intent(MainActivity.this, MainSupplyFromActivity.class));
    }

    public void main_button_Supply_to_click(View view) {
        startActivity(new Intent(MainActivity.this, MainSupplyToActivity.class));
    }

    public void main_button_community_click(View view) {
        startActivity(new Intent(MainActivity.this, MainCommunityActivity.class));
    }

    public void main_button_Punch_click(View view) {
        startActivity(new Intent(MainActivity.this, MainPunchActivity.class));
    }

    public void top_click(View view){
        Intent intent=new Intent(MainActivity.this,ManagerActivity.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.main_kaidangonglue:
                startActivity(new Intent(MainActivity.this, RaidersActivity.class));
                break;
            case R.id.main_setting:
                startActivity(new Intent(MainActivity.this, SettingActivity.class));
                break;
            case R.id.main_tongzhi:
                startActivity(new Intent(MainActivity.this, WelcomeActivity.class));
                break;
            default:
                break;
        }
    }

    class MyListener implements ViewPager.OnPageChangeListener {

        //当滑动状态改变时调用
        @Override
        public void onPageScrollStateChanged(int arg0) {
            // TODO Auto-generated method stub
            //arg0=arg0%list.size();

        }

        //当当前页面被滑动时调用
        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {
            // TODO Auto-generated method stub

        }

        int[] dot_id = {R.drawable.switch_3, R.drawable.switch_4};

        //当新的页面被选中时调用
        @Override
        public void onPageSelected(int arg0) {

            arg0 = arg0 % pageview.size();

            int c_id = arg0;
            Log.d("MainActivity", "index:" + String.valueOf(c_id));
            for (int i = 0; i < pageview.size(); i++) {
                dotViews[arg0]
                        .setBackgroundResource(dot_id[0]);
                if (arg0 != i) {
                    dotViews[i]
                            .setBackgroundResource(dot_id[1]);
                }
            }

            Log.d("qiang", "当前是第" + c_id + "页");
        }
    }
}

