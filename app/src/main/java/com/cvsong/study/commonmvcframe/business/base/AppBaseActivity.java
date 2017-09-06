package com.cvsong.study.commonmvcframe.business.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.LayoutInflaterCompat;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;

import com.cvsong.study.commonmvcframe.R;
import com.cvsong.study.commonmvcframe.business.app.AppApplication;
import com.cvsong.study.commonmvcframe.business.ui.activity.MainActivity;
import com.cvsong.study.commonmvcframe.common.base.BaseActivity;
import com.cvsong.study.commonmvcframe.common.wiget.statuslayout.OnRetryListener;
import com.cvsong.study.commonmvcframe.common.wiget.statuslayout.OnShowHideViewListener;
import com.cvsong.study.commonmvcframe.common.wiget.statuslayout.StatusLayoutManager;
import com.mikepenz.iconics.context.IconicsLayoutInflater;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 应用级BaseActivity
 * Created by chenweisong on 2017/9/5.
 */
public abstract class AppBaseActivity extends BaseActivity {

    protected Toolbar toolbar;
    FrameLayout viewContent;
    protected StatusLayoutManager statusLayoutManager;
    private Unbinder unbinder;
    protected AppApplication appApplication;
    protected String TAG;//日志TAG标记

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //设置字体图标库
        LayoutInflaterCompat.setFactory(getLayoutInflater(), new IconicsLayoutInflater(getDelegate()));

        super.onCreate(savedInstanceState);
        setThemStyle();//设置主题样式
        setContentView(R.layout.activity_app_base);
        viewContent = (FrameLayout) findViewById(R.id.view_content);
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        TAG = this.getClass().getSimpleName();
        appApplication = (AppApplication) getApplication();

        initStatusLayout();//初始化多状态布局
        unbinder = ButterKnife.bind(this);//绑定黄油刀


        initToolbar();//初始化toolbar

        initView();//初始化View

        loadData();//加载数据

    }

    /**
     * 初始化多状态布局
     */
    private void initStatusLayout() {
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
