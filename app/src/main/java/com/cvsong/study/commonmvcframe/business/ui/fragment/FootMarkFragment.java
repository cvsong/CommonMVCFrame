package com.cvsong.study.commonmvcframe.business.ui.fragment;

import android.os.Bundle;

import com.cvsong.study.commonmvcframe.R;
import com.cvsong.study.commonmvcframe.business.base.AppBaseFragment;

/**
 * 足迹Fragment
 * Created by chenweisong on 2017/9/6.
 */

public class FootMarkFragment extends AppBaseFragment {

    public static FootMarkFragment newInstance() {
        FootMarkFragment fragment = new FootMarkFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);

        return fragment;
    }

    @Override
    protected int getViewLayout() {
        return R.layout.fragment_footmark;
    }

    @Override
    protected void initView() {
        toolbar.setTitle("足迹");
    }

    @Override
    protected void loadData() {
        Bundle data = this.getArguments();


    }
}
