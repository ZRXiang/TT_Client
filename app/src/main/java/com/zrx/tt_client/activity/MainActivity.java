package com.zrx.tt_client.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.gn.groupon_client.R;
import com.example.gn.groupon_client.fragment.FragmentHome;
import com.example.gn.groupon_client.fragment.FragmentMy;
import com.example.gn.groupon_client.fragment.FragmentSearch;
import com.example.gn.groupon_client.fragment.FragmentTuan;
import com.lidroid.xutils.view.annotation.ViewInject;

public class MainActivity extends FragmentActivity implements RadioGroup.OnCheckedChangeListener {
    @ViewInject(R.id.main_bottom_tabs)
    private RadioGroup group;
    @ViewInject(R.id.main_home)
    private RadioButton main_home;
    private FragmentManager fm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        com.lidroid.xutils.ViewUtils.inject(this);
        fm = getSupportFragmentManager();
        main_home.setChecked(true);
        group.setOnCheckedChangeListener(this);
        changeFragment(new FragmentHome(),false);
    }


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){
            case R.id.main_home://首页
                changeFragment(new FragmentHome(),true);
                break;
            case R.id.main_my://我的
                changeFragment(new FragmentMy(),true);
                break;
            case R.id.main_search://发现
                changeFragment(new FragmentSearch(),true);
                break;
            case R.id.main_tuan://团购
                changeFragment(new FragmentTuan(),true);
                break;
        }
    }

    //切换不同的Fragment
    public void changeFragment(Fragment fragment,boolean isInit){
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.main_content,fragment);
        if(!isInit){
            ft.addToBackStack(null);
        }
        ft.commit();

    }
}
