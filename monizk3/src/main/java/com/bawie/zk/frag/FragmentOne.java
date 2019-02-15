package com.bawie.zk.frag;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bawie.zk.R;
import com.bawie.zk.fragment.Frag1;
import com.bawie.zk.fragment.Frag2;
import com.bawie.zk.fragment.Frag3;
import com.bawie.zk.fragment.Frag4;
import com.bawie.zk.fragment.Frag5;

import java.util.ArrayList;

public class FragmentOne extends Fragment {

    private TabLayout tab1;
    private ViewPager pager1;
    private ArrayList<String> strings;
    private ArrayList<Fragment> list;
    private FragmentOne.base base;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.frag1,container,false);

        tab1 = (TabLayout) view.findViewById(R.id.tab1);
        pager1 = (ViewPager) view.findViewById(R.id.pager1);

        strings = new ArrayList<String>();
        list = new ArrayList<Fragment>();

        list.add(new Frag1());
        list.add(new Frag2());
        list.add(new Frag3());
        list.add(new Frag4());
        list.add(new Frag5());

        for (int i = 0; i < 5; i++) {
            strings.add("东北虎");
            strings.add("山西虎");
            strings.add("虎平");
            strings.add("山西虎");
            strings.add("东北虎");
        }
        base = new base(getChildFragmentManager());
        pager1.setAdapter(base);

        tab1.setupWithViewPager(pager1);

        return view;
    }

    private class base extends FragmentPagerAdapter {

        public base(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            return list.get(i);
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return strings.get(position);
        }
    }
}
