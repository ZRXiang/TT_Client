package com.zrx.tt_client.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gn.groupon_client.R;

import java.util.ArrayList;

/**
 * Created by GN on 2017/2/3.
 */
public class PagerActivity  extends Activity{
    private ViewPager mViewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainviewpage);

        mViewpager = (ViewPager) findViewById(R.id.viewpager);

        //将要分页显示的view装入数组中
        LayoutInflater mlayout = LayoutInflater.from(this);
        View view1 = mlayout.inflate(R.layout.viewpager_item1, null);
        View view2 = mlayout.inflate(R.layout.viewpager_item2,null);
        View view3 = mlayout.inflate(R.layout.viewpager_item3,null);

        final ArrayList<View> views = new ArrayList<View>();
        views.add(view1);
        views.add(view2);
        views.add(view3);

        PagerAdapter mpageadapter = new PagerAdapter() {
            //确定页面的个数
            @Override
            public int getCount() {
                return views.size();
            }
            //确定
            @Override
            public boolean isViewFromObject(View arg0, Object arg1) {
                return arg0==arg1;
            }
            //确定需要加载的页面
            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                ((ViewPager)container).addView(views.get(position));
                return views.get(position);
            }
            //确定需要删除的页面
            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                ((ViewPager)container).removeView(views.get(position));
            }
        };
        //给viewpager添加适配器
        mViewpager.setAdapter(mpageadapter);
    }

    public void actionclick(View v){
        new android.os.Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                Intent intent=new Intent(PagerActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        },3000);

    }
}
