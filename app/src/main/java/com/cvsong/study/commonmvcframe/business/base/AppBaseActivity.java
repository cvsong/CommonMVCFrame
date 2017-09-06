package com.cvsong.study.commonmvcframe.business.base;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;

import com.cvsong.study.commonmvcframe.R;
import com.cvsong.study.commonmvcframe.common.base.BaseActivity;
import com.cvsong.study.commonmvcframe.common.wiget.statuslayout.OnRetryListener;
import com.cvsong.study.commonmvcframe.common.wiget.statuslayout.OnShowHideViewListener;
import com.cvsong.study.commonmvcframe.common.wiget.statuslayout.StatusLayoutManager;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 应用BaseActivity
 * Created by chenweisong on 2017/9/5.
 */
public abstract class AppBaseActivity extends BaseActivity {


    protected Toolbar toolbar;
    FrameLayout viewContent;
    protected StatusLayoutManager statusLayoutManager;
    private Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setThemStyle();//设置主题样式

        setContentView(R.layout.activity_app_base);
        viewContent = (FrameLayout) findViewById(R.id.view_content);
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        statusLayoutManager = StatusLayoutManager.newBuilder(this)
                .contentView(getViewLayout())
                .emptyDataView(R.layout.layout_status_emptydata)
                .errorView(R.layout.layout_status_error)
                .loadingView(R.layout.layout_status_loading)
                .netWorkErrorView(R.layout.layout_status_networkerror)
                .retryViewId(R.id.button_retry)
                .onShowHideViewListener(new OnShowHideViewListener() {
                    @Override
                    public void onShowView(View view, int id) {
                    }

                    @Override
                    public void onHideView(View view, int id) {
                    }
                }).onRetryListener(new OnRetryListener() {
                    @Override
                    public void onRetry() {

                    }
                }).build();

        //将多状态布局添加到内容布局中
        viewContent.addView(statusLayoutManager.getRootLayout(), 0);
        unbinder = ButterKnife.bind(this);//绑定黄油刀


        initToolbar();//初始化toolbar

        initView();//初始化View

        loadData();//加载数据

    }

    /**
     * 设置主题样式
     */
    protected void setThemStyle() {

    }


    /**
     * 初始化Toolbar
     */
    private void initToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }


    /**
     * 获取布局Layout
     */
    protected abstract int getViewLayout();

    /**
     * 初始化View
     */
    protected abstract void initView();

    /**
     * 加载数据
     */
    protected abstract void loadData();


    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (unbinder != Unbinder.EMPTY) {
            unbinder.unbind();//解除绑定
        }

    }
}
