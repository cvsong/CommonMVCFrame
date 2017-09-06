package com.cvsong.study.commonmvcframe.common.base;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.cvsong.study.commonmvcframe.R;

/**
 * 基础Activity
 * Created by chenweisong on 2017/9/5.
 */
public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
    }
}
