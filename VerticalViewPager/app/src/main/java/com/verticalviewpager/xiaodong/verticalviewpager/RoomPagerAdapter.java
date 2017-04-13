package com.verticalviewpager.xiaodong.verticalviewpager;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by xiaodong on 17/4/12.
 */
public class RoomPagerAdapter extends PagerAdapter {
    private final List<String> mImageViews;
    private final Context context;
    private LinkedList<View> mViewCache = null;
    private LayoutInflater mLayoutInflater;
    private ViewHolder viewHolder;

    public RoomPagerAdapter(Context context, List<String> mImageViews) {
        this.mImageViews = mImageViews;
        this.context = context;
        mLayoutInflater = LayoutInflater.from(context);
        mViewCache = new LinkedList<>();
    }

    @Override
    public int getCount() {
//        return mImageViews.size();
        return mImageViews.size() == 1 ? mImageViews.size() : Integer.MAX_VALUE;
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View contentView = (View) object;
        container.removeView(contentView);
        this.mViewCache.add(contentView);
    }
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        position %= mImageViews.size();
        if (position < 0) {
            position = mImageViews.size() + position;
        }
        View convertView;
        final ViewHolder viewHolderIn;
        if (mViewCache.size() == 0) {
            convertView = this.mLayoutInflater.inflate(R.layout.item_vp_liveroomnew_vertical_switch,
                    null, false);
            viewHolderIn = new ViewHolder(convertView);
            convertView.setTag(viewHolderIn);
        }else{
            convertView = mViewCache.removeFirst();
            viewHolderIn = (ViewHolder) convertView.getTag();
        }
        viewHolderIn.bimg_liveroom_switch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "你点击了中间", Toast.LENGTH_SHORT).show();
            }
        });
        this.viewHolder = viewHolderIn;
        String info = mImageViews.get(position);
        viewHolderIn.imageView.setAlpha(1.0f);
        Glide.with(context).load(info).placeholder(R.drawable.icon2).into(viewHolderIn.imageView);
        container.addView(convertView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        return convertView;
    }

    public class ViewHolder {
        private ImageView imageView;
        private ImageView bimg_liveroom_switch;
        private HorizatialSlideFrameLayout mHorizatialSlideFrameLayout;
        public ViewHolder(View convertView) {
            imageView = (ImageView) convertView.findViewById(R.id.img_liveroom_blurebg);
            bimg_liveroom_switch = (ImageView) convertView.findViewById(R.id.bimg_liveroom_switch);
            mHorizatialSlideFrameLayout = (HorizatialSlideFrameLayout) convertView.findViewById(R.id.mHorizatialSlideFrameLayout);
        }
    }

    public void setBlurBgAlp(float alp) {
        if (viewHolder != null)
            viewHolder.imageView.setAlpha(alp);
    }
}
