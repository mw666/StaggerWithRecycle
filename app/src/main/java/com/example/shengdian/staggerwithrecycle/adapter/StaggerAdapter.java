package com.example.shengdian.staggerwithrecycle.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;


import com.example.shengdian.staggerwithrecycle.R;
import com.example.shengdian.staggerwithrecycle.utils.DipUtils;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * Created by wangyu on 2019/7/8.
 */

public class StaggerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Integer> lists;
    private Context mContext;
    private int type_one = 0x001;
    private int type_two = 0x002;
    private int type_three = 0x003;
    private int mWidth;
    private int eachValue;
    private int padding = 15;

    public StaggerAdapter(Context mContext, int mWidth, List<Integer> lists) {
        this.mContext = mContext;
        this.mWidth = mWidth;
        this.lists = lists;
        int padding_px = DipUtils.dip2px(mContext, padding);
        eachValue = (mWidth - padding_px * 3) / 3;
        Log.d("===", eachValue + "eachValue");
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == type_one) {
            View inflate = LayoutInflater.from(mContext).inflate(R.layout.item_one, parent, false);
            return new ViewHolderOne(inflate);
        } else if (viewType == type_two) {
            View inflate = LayoutInflater.from(mContext).inflate(R.layout.item_two, parent, false);
            return new ViewHolderTwo(inflate);
        } else {
            View inflate = LayoutInflater.from(mContext).inflate(R.layout.item_three, parent, false);
            return new ViewHolderThree(inflate);
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Integer pic1 = 0;
        Integer pic2 = 0;
        Integer pic3 = 0;
        int num=(position+1)/3;
        int currentPosition=num*7;

        if (holder instanceof ViewHolderOne) {
            if (currentPosition <= lists.size()-1) {
                pic1 = lists.get(currentPosition);
            }
            if (currentPosition+ 1 <= lists.size()-1) {
                pic2 = lists.get(currentPosition+ 1);
            }
            if (currentPosition + 2 <= lists.size()-1) {
                pic3 = lists.get(currentPosition + 2);
            }
            ViewHolderOne viewHolderOne = (ViewHolderOne) holder;
            ViewGroup.LayoutParams layoutParams = viewHolderOne.oneLeft.getLayoutParams();
            layoutParams.width = eachValue * 2;
            layoutParams.height = eachValue * 2;
            viewHolderOne.oneLeft.setLayoutParams(layoutParams);
            viewHolderOne.oneLeft.requestLayout();
            if (pic1 != 0) {
                viewHolderOne.oneLeft.setImageResource(pic1);
            } else {
                viewHolderOne.oneLeft.setImageResource(0);
            }
            ViewGroup.LayoutParams right_layout_p = viewHolderOne.oneRightLayout.getLayoutParams();
            right_layout_p.height = eachValue * 2;
            viewHolderOne.oneRightLayout.setLayoutParams(right_layout_p);
            viewHolderOne.oneRightLayout.requestLayout();
            if (pic2 != 0) {
                viewHolderOne.oneRight1.setImageResource(pic2);
            } else {
                viewHolderOne.oneRight1.setImageResource(0);
            }
            if (pic3 != 0) {
                viewHolderOne.oneRight2.setImageResource(pic3);
            } else {
                viewHolderOne.oneRight2.setImageResource(0);
            }
        } else if (holder instanceof ViewHolderTwo){
            if (currentPosition+3<= lists.size()-1) {
                pic1 = lists.get(currentPosition+3);
            }
            if (currentPosition+ 4 <= lists.size()-1) {
                pic2 = lists.get(currentPosition+ 4);
            }
            if (currentPosition + 5 <= lists.size()-1) {
                pic3 = lists.get(currentPosition + 5);
            }

            ViewHolderTwo viewHolderTwo = (ViewHolderTwo) holder;
            ViewGroup.LayoutParams layoutParams = viewHolderTwo.twoLeftLayout.getLayoutParams();
            layoutParams.width = eachValue;
            layoutParams.height = eachValue * 2;
            viewHolderTwo.twoLeftLayout.setLayoutParams(layoutParams);
            viewHolderTwo.twoLeftLayout.requestLayout();

            viewHolderTwo.twoLeft1.setImageResource(pic1);
            viewHolderTwo.twoLeft2.setImageResource(pic2);

            ViewGroup.LayoutParams two_right_lp = viewHolderTwo.twoRight.getLayoutParams();
            two_right_lp.height = eachValue * 2;
            viewHolderTwo.twoRight.setLayoutParams(two_right_lp);
            viewHolderTwo.twoRight.requestLayout();
            viewHolderTwo.twoRight.setImageResource(pic3);
        }else {
            ViewHolderThree viewHolderThree= (ViewHolderThree) holder;
            ViewGroup.LayoutParams item_three_lp = viewHolderThree.itemTwoIv.getLayoutParams();
            item_three_lp.height=eachValue;
            viewHolderThree.itemTwoIv.setLayoutParams(item_three_lp);
            viewHolderThree.itemTwoIv.requestLayout();
            viewHolderThree.itemTwoIv.setImageResource(lists.get(currentPosition-1));
        }
    }

    @Override
    public int getItemCount() {
        int out_num = lists.size() / 7;
        int last_num = lists.size() % 7;
        int int_num = (int) Math.ceil((double) last_num / 3);

        //  Log.d("===",(int) Math.ceil((double)lists.size()/3)+"count");
        return out_num * 3 + int_num;

    }

    @Override
    public int getItemViewType(int position) {
        int i = position % 3;
        if (i == 0) {
            return type_one;
        } else if (i == 1) {
            return type_two;
        } else {
            return type_three;
        }
    }

    static class ViewHolderOne extends RecyclerView.ViewHolder {
        @Bind(R.id.one_left)
        ImageView oneLeft;
        @Bind(R.id.one_right1)
        ImageView oneRight1;
        @Bind(R.id.one_right2)
        ImageView oneRight2;
        @Bind(R.id.one_rightLayout)
        LinearLayout oneRightLayout;

        ViewHolderOne(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    static class ViewHolderTwo extends RecyclerView.ViewHolder {
        @Bind(R.id.two_left1)
        ImageView twoLeft1;
        @Bind(R.id.two_left2)
        ImageView twoLeft2;
        @Bind(R.id.two_leftLayout)
        LinearLayout twoLeftLayout;
        @Bind(R.id.two_right)
        ImageView twoRight;

        ViewHolderTwo(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    static class ViewHolderThree extends RecyclerView.ViewHolder {
        @Bind(R.id.item_twoIv)
        ImageView itemTwoIv;

        ViewHolderThree(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
