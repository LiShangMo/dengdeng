package com.example.zhangshilong20190115;

import android.support.annotation.NonNull;
import android.support.v4.app.FragmentTransaction;

import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.zhangshilong20190115.base.BaseActivity;
import com.example.zhangshilong20190115.fragment.FragmentOne;
import com.example.zhangshilong20190115.fragment.FragmentThree;
import com.example.zhangshilong20190115.fragment.FragmentTwo;

public  class ShowActivity extends BaseActivity {



    private RadioGroup radio;
    private FragmentOne fragmentOne;
    private FragmentTwo fragmentTwo;
    private FragmentThree fragmentThree;
    private FragmentTransaction fragmentTransaction;
    private FrameLayout frage;
    private DrawerLayout drawer;


    @Override
    protected void initDate() {
        radio.check(radio.getChildAt(0).getId());
        radio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                switch (checkedId){
                    case R.id.but1:
                        transaction.show(fragmentOne).hide(fragmentTwo).hide(fragmentThree).commit();
                        break;
                    case R.id.but2:
                        transaction.show(fragmentTwo).hide(fragmentOne).hide(fragmentThree).commit();
                        break;
                    case R.id.but3:
                        transaction.show(fragmentThree).hide(fragmentTwo).hide(fragmentOne).commit();
                        break;
                }
            }
        });
        drawer.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(@NonNull View view, float v) {

            }

            @Override
            public void onDrawerOpened(@NonNull View view) {
                Toast.makeText(ShowActivity.this,"侧拉菜单打开了",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDrawerClosed(@NonNull View view) {
                Toast.makeText(ShowActivity.this,"侧拉菜单关闭了",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDrawerStateChanged(int i) {

            }
        });

    }

    @Override
    protected void initView() {
        frage = (FrameLayout) findViewById(R.id.frage);
        radio = (RadioGroup) findViewById(R.id.radio);
        drawer = (DrawerLayout) findViewById(R.id.drawer);

        fragmentOne = new FragmentOne();
        fragmentTwo = new FragmentTwo();
        fragmentThree = new FragmentThree();

        //开启事务
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.frage,fragmentOne);
        fragmentTransaction.add(R.id.frage,fragmentTwo);
        fragmentTransaction.add(R.id.frage,fragmentThree);


        fragmentTransaction.show(fragmentOne).hide(fragmentTwo).hide(fragmentThree).commit();
        initDate();
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_show;
    }
}
