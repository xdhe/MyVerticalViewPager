package com.verticalviewpager.xiaodong.verticalviewpager;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private VerticalViewPager mVerticalViewPager;
    private  RoomPagerAdapter pagerAdapter;
    private List<String> mImageViews = new ArrayList<>();
    private String[] images = {"http://img2.imgtn.bdimg.com/it/u=3093785514,1341050958&fm=21&gp=0.jpg",
            "http://img2.3lian.com/2014/f2/37/d/40.jpg",
            "http://img2.3lian.com/2014/f2/37/d/39.jpg",
            "http://www.8kmm.com/UploadFiles/2012/8/201208140920132659.jpg",
            "http://f.hiphotos.baidu.com/image/h%3D200/sign=1478eb74d5a20cf45990f9df460b4b0c/d058ccbf6c81800a5422e5fdb43533fa838b4779.jpg",
            "http://f.hiphotos.baidu.com/image/pic/item/09fa513d269759ee50f1971ab6fb43166c22dfba.jpg"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mVerticalViewPager = (VerticalViewPager) findViewById(R.id.vp_liveroom_switch);
        initData();
        pagerAdapter = new RoomPagerAdapter(this,mImageViews);
        mVerticalViewPager.setAdapter(pagerAdapter);

    }
    public int currentItem;
    private void initData() {
        mImageViews = Arrays.asList(images);
//        mImageViews.add(R.drawable.icon1);
        mVerticalViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (position < currentItem) {
                    pagerAdapter.setBlurBgAlp((positionOffset) * 3);
                }
            }
            @Override
            public void onPageSelected(int position) {
                currentItem = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
