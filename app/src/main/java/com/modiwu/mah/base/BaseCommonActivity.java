package com.modiwu.mah.base;

import android.annotation.SuppressLint;
import android.support.annotation.LayoutRes;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import top.jplayer.baseprolibrary.mvp.contract.IContract;
import top.jplayer.baseprolibrary.ui.SuperBaseActivity;
import top.jplayer.baseprolibrary.widgets.MultipleStatusView;


/**
 * Created by Obl on 2018/1/9.
 * top.jplayer.zhenggejia.base
 */

@SuppressLint("Registered")
public abstract class BaseCommonActivity extends SuperBaseActivity implements IContract.IView {
    public View addRootView;
    public MultipleStatusView mMultipleStatusView;
    public SmartRefreshLayout smartRefreshLayout;

    @Override
    public void initSuperData(FrameLayout mFlRootView) {
        mBaseActivity = this;
        mFlRootView.removeAllViews();
        mFlRootView.addView(setBaseInflate(mFlRootView));
        initBaseData();
    }

    private View setBaseInflate(FrameLayout mFlRootView) {
        addRootView = LayoutInflater.from(this).inflate(setBaseLayout(), mFlRootView, false);
        return addRootView;
    }

    public abstract @LayoutRes
    int setBaseLayout();

    public abstract void initBaseData();

    @Override
    public void showError() {
        if (mMultipleStatusView != null) {
            mMultipleStatusView.showError();
        }
        if (smartRefreshLayout != null && smartRefreshLayout.isRefreshing()) {
            smartRefreshLayout.finishRefresh();
        }
    }

    @Override
    public void showLoading() {
        if (mMultipleStatusView != null) {
            mMultipleStatusView.showLoading();
        }
    }

    @Override
    public void showEmpty() {
        if (mMultipleStatusView != null) {
            mMultipleStatusView.showEmpty();
        }
        if (smartRefreshLayout != null && smartRefreshLayout.isRefreshing()) {
            smartRefreshLayout.finishRefresh();
        }
    }
}
