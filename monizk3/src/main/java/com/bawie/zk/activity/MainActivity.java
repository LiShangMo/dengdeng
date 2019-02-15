package com.bawie.zk.activity;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import com.bawie.zk.R;
import com.bawie.zk.frag.FragmentOne;
import com.bawie.zk.frag.FragmentThree;
import com.bawie.zk.frag.FragmentTwo;

public class MainActivity extends FragmentActivity {

    private FrameLayout frag;
    private RadioGroup group;
    private FragmentManager manager;
    private FragmentOne one;
    private FragmentTwo two;
    private FragmentThree three;
    private FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frag = findViewById(R.id.frag);
        group = findViewById(R.id.group);

        manager = getSupportFragmentManager();

        one = new FragmentOne();
        two = new FragmentTwo();
        three = new FragmentThree();

        transaction = manager.beginTransaction();

        transaction.add(R.id.frag,one);
        transaction.add(R.id.frag,two);
        transaction.add(R.id.frag,three);

        transaction.show(one).hide(two).hide(three);

        transaction.commit();

        group.check(group.getChildAt(0).getId());

        //fragment选中页面切换
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                FragmentTransaction transaction1 = manager.beginTransaction();
                switch (checkedId){
                    case R.id.q1:
                        transaction1.show(one).hide(two).hide(three);
                        break;
                    case R.id.q2:
                        transaction1.show(two).hide(one).hide(three);
                        break;
                    case R.id.q3:
                        transaction1.show(three).hide(one).hide(two);
                        break;
                }
                transaction1.commit();
            }
        });


    }
}
