package com.example.dell.toolbardrawerlayout_dome;

import android.graphics.Color;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private DrawerLayout drawerLayout_left;
    private ListView listView_left;
    private ActionBarDrawerToggle actionBarDrawerToggle;//改变Android返回键的图标，是控制DrawerLayout的控制开关，本身自带有android.R.id.home的动画效果。
    private ArrayAdapter arrayAdapter_left;
    private TextView textView;
    private String [] content_left = {"list1","list2","list3"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar=(Toolbar)findViewById(R.id.toolbar);
        listView_left=(ListView)findViewById(R.id.list_item_left);
        textView=(TextView)findViewById(R.id.text);
        drawerLayout_left=(DrawerLayout)findViewById(R.id.drawable_layout);

        toolbar.setTitle("Toolbar");    //如果不加这句，标题栏显示的一直是我们项目的名字(Toolbar+DrawerLayout_Dome),这显然不是我们想让用户看到的。
        toolbar.setTitleTextColor(Color.parseColor("#ffffff"));

        setSupportActionBar(toolbar);   //注意这里的Activity必须是继承自AppCompatActivity,只有这个兼容类中有toolbar.
        getSupportActionBar().setHomeButtonEnabled(true);       //设置返回键可用，这两个方法共同起作用.
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);      //给左上角图标的左边加上一个返回的图标.

        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout_left,toolbar,R.string.open,R.string.close){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                textView.setText("Hellow");
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                textView.setText("Hellow Word");
            }
        };
        actionBarDrawerToggle.syncState();      //表示actionBarDrawerToggle与DrawerLayout状态同步
        drawerLayout_left.addDrawerListener(actionBarDrawerToggle);//注意setDrawerListener(actionBarDrawerToggle); 这个已经过时

        arrayAdapter_left=new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,content_left);
        listView_left.setAdapter(arrayAdapter_left);

    }

}