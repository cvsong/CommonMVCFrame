package com.cvsong.study.commonmvcframe.business.ui.activity;

import android.widget.TextView;

import com.cvsong.study.commonmvcframe.R;
import com.cvsong.study.commonmvcframe.business.base.AppBaseActivity;

import butterknife.BindView;

/**
 * 主Activity
 * Created by chenweisong on 2017/9/5.
 */
public class MainActivity extends AppBaseActivity {

    @BindView(R.id.tv_content)
    TextView tvContent;

    @Override
    protected int getViewLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        toolbar.setTitle("主项目");
        statusLayoutManager.showContent();
        tvContent.setText("This Firsh Project");
    }

    @Override
    protected void loadData() {

    }


}
