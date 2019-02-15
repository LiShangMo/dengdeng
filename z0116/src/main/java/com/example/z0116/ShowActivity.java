package com.example.z0116;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.z0116.base.BaseActivity;
import com.example.z0116.fragment.FragmentOne;
import com.example.z0116.fragment.FragmentThree;
import com.example.z0116.fragment.FragmentTwo;

public class ShowActivity extends BaseActivity {


    private FrameLayout framg;
    private RadioGroup radiog;
    private FragmentOne fragmentOne;
    private FragmentTwo fragmentTwo;
    private FragmentThree fragmentThree;
    private FragmentTransaction fragmentTransaction;
    private DrawerLayout drawer;

    @Override
    protected void intitDate() {
        radiog.check(radiog.getChildAt(0).getId());
        radiog.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                FragmentTransaction fragmentTransaction1 = getSupportFragmentManager().beginTransaction();
                switch (checkedId){
                    case R.id.but1:
                        fragmentTransaction1.show(fragmentOne).hide(fragmentTwo).hide(fragmentThree).commit() ;
                        break;
                    case R.id.but2:
                        fragmentTransaction1.show(fragmentTwo).hide(fragmentOne).hide(fragmentThree).commit() ;
                        break;
                    case R.id.but3:
                        fragmentTransaction1.show(fragmentThree).hide(fragmentTwo).hide(fragmentOne).commit() ;
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
        framg = (FrameLayout) findViewById(R.id.frag);
        radiog = (RadioGroup) findViewById(R.id.radiog);
        drawer = (DrawerLayout) findViewById(R.id.drawer);

        fragmentOne = new FragmentOne();
        fragmentTwo = new FragmentTwo();
        fragmentThree = new FragmentThree();

        fragmentTransaction = getSupportFragmentManager().beginTransaction();

        fragmentTransaction.add(R.id.frag,fragmentOne);
        fragmentTransaction.add(R.id.frag,fragmentTwo,"FragmentTwo");
        fragmentTransaction.add(R.id.frag,fragmentThree);
        fragmentTransaction.show(fragmentOne).hide(fragmentTwo).hide(fragmentThree).commit();
        intitDate();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_show;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Fragment fragmentTwo = getSupportFragmentManager().findFragmentByTag("FragmentTwo");

        fragmentTwo.onActivityResult(requestCode,resultCode,data);
    }
}
