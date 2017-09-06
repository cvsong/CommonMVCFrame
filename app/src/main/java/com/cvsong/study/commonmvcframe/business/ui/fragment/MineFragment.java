package com.cvsong.study.commonmvcframe.business.ui.fragment;

import android.os.Bundle;

import com.cvsong.study.commonmvcframe.R;
import com.cvsong.study.commonmvcframe.business.base.AppBaseFragment;

/**
 * 我的Fragment
 * Created by chenweisong on 2017/9/6.
 */

public class MineFragment extends AppBaseFragment {

    public static MineFragment newInstance() {
        MineFragment fragment = new MineFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);

        return fragment;
    }

    @Override
    protected int getViewLayout() {
        return R.layout.fragment_mine;
    }

    @Override
    protected void initView() {
        toolbar.setTitle("我的");
    }

    @Override
    protected void loadData() {

    }
}
