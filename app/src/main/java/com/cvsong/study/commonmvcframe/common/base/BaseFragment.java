package com.cvsong.study.commonmvcframe.common.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

/**BaseFragment
 * Created by chenweisong on 2017/9/6.
 */

public class BaseFragment extends Fragment {

    protected FragmentActivity activity;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = getActivity();
    }
}
