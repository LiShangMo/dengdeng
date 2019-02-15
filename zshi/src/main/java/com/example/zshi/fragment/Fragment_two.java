package com.example.zshi.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.andy.library.ChannelActivity;
import com.andy.library.ChannelBean;
import com.example.zshi.R;
import com.example.zshi.base.BaseFragment;
import com.example.zshi.tab.BlanKFragt;
import com.example.zshi.tab.Tabone;
import com.example.zshi.tab.Tabthree;
import com.example.zshi.tab.Tabtwo;

import java.util.ArrayList;
import java.util.List;

public class Fragment_two extends BaseFragment {

    private TabLayout tab;
    private ViewPager page;
    private Button button;
    private List<Fragment> fragments=new ArrayList<>();
    private ArrayList<ChannelBean> beanArrayList=new ArrayList<>();

    @Override
    protected void initDate() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChannelActivity.startChannelActivity((AppCompatActivity)getActivity(),beanArrayList);
            }
        });
        beanArrayList.add(new ChannelBean("马"+"",true));
        beanArrayList.add(new ChannelBean("梦"+"",true));
        beanArrayList.add(new ChannelBean("茹"+"",true));
        beanArrayList.add(new ChannelBean("女"+"",true));
        beanArrayList.add(new ChannelBean("神"+"",true));

        for (int i=0;i<beanArrayList.size();i++){
            if (beanArrayList.get(i).isSelect()){
                String name = beanArrayList.get(i).getName();
                tab.addTab(tab.newTab().setText(name));
                if(i==0){
                    fragments.add(new Tabone());
                }else if (i==1){
                    fragments.add(new Tabtwo());
                }else if (i==2){
                    fragments.add(new Tabthree());
                }else {
                    fragments.add(new BlanKFragt());
                }
            }
        }

    }

    @Override
    protected void initView(View view) {
        tab = (TabLayout) view.findViewById(R.id.tab);
        page = (ViewPager) view.findViewById(R.id.page);
        button = (Button) view.findViewById(R.id.button);


    }

    @Override
    protected int getlayoutId() {
        return R.layout.fragmenttwo;
    }


}
