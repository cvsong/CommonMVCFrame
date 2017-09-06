package com.cvsong.study.commonmvcframe.business.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.cvsong.study.commonmvcframe.R;
import com.cvsong.study.commonmvcframe.business.base.AppBaseFragment;

/**
 * 首页Fragment
 * Created by chenweisong on 2017/9/6.
 */

public class HomeFragment extends AppBaseFragment {

    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);

        return fragment;
    }


    @Override
    protected int getViewLayout() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView() {
        toolbar.setTitle("首页");
    }

    @Override
    protected void loadData() {

    }
}
