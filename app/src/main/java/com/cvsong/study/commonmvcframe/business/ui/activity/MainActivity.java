package com.cvsong.study.commonmvcframe.business.ui.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.cvsong.study.commonmvcframe.R;
import com.cvsong.study.commonmvcframe.business.base.AppBaseActivity;
import com.cvsong.study.commonmvcframe.business.ui.fragment.FootMarkFragment;
import com.cvsong.study.commonmvcframe.business.ui.fragment.HomeFragment;
import com.cvsong.study.commonmvcframe.business.ui.fragment.MineFragment;

import butterknife.BindView;

/**
 * 主Activity
 * Created by chenweisong on 2017/9/5.
 */
public class MainActivity extends AppBaseActivity {


    @BindView(R.id.fl_content)
    FrameLayout flContent;
    @BindView(R.id.rg_bottom)
    RadioGroup rgBottom;
    @BindView(R.id.rb_home)
    RadioButton rbHome;
    @BindView(R.id.rb_footmark)
    RadioButton rbFootmark;
    @BindView(R.id.rb_mine)
    RadioButton rbMine;
    private Fragment currentFragment;//当前Fragement
    private HomeFragment homeFragment;
    private FootMarkFragment footMarkFragment;
    private MineFragment mineFragment;

    @Override
    protected int getViewLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        toolbar.setVisibility(View.GONE);
        statusLayoutManager.showContent();

        homeFragment = new HomeFragment();
        footMarkFragment = new FootMarkFragment();
        mineFragment = new MineFragment();

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();


        transaction.add(R.id.fl_content, homeFragment)
                .add(R.id.fl_content, footMarkFragment)
                .add(R.id.fl_content, mineFragment)
                .hide(homeFragment).hide(footMarkFragment).hide(mineFragment)
                .show(homeFragment).commit();
        currentFragment = homeFragment;//指定当前Fragement
        rgBottom.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                switchFragment(i);//切换Fragment
            }
        });


    }

    /**
     * 切换Fragment
     *
     * @param childId
     */
    private void switchFragment(int childId) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        switch (childId) {
            case R.id.rb_home://首页
                if (currentFragment instanceof HomeFragment) {
                    return;
                }
                transaction.hide(currentFragment).show(homeFragment);
                currentFragment = homeFragment;
                break;
            case R.id.rb_footmark://足迹
                if (currentFragment instanceof FootMarkFragment) {
                    return;
                }
                transaction.hide(currentFragment).show(footMarkFragment);
                currentFragment = footMarkFragment;
                break;
            case R.id.rb_mine://我的
                if (currentFragment instanceof MineFragment) {
                    return;
                }

                transaction.hide(currentFragment).show(mineFragment);
                currentFragment=mineFragment;
                break;


        }

        transaction.commit();
    }

    @Override
    protected void loadData() {

    }


    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        //防止应用崩溃时重影
//        super.onSaveInstanceState(outState, outPersistentState);
    }
}
