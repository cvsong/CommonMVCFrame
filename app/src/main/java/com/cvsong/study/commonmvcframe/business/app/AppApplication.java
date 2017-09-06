package com.cvsong.study.commonmvcframe.business.app;

import android.app.Application;

import com.blankj.utilcode.util.Utils;

/**
 * 应用Application
 * Created by chenweisong on 2017/9/6.
 */

public class AppApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Utils.init(this);//初始化常用工具包

    }
}
