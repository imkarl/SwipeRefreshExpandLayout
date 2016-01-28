package com.alafighting.swipelayout;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

/**
 * 显示加载的控件
 * @author alafighting 16/01/27 封装简化
 * @author aspsine 15/11/7
 */
public class CircleLoadLayout extends FrameLayout implements SwipeTrigger, SwipeRefreshTrigger, SwipeLoadMoreTrigger {

    public enum Gravity {
        TOP, BOTTOM;
    }


    public static final int DEFAULT_FINALDRAG_OFFSET = (int) (Resources.getSystem().getDisplayMetrics().density * 150);
    public static final int DEFAULT_FINALOVER_OFFSET = (int) (Resources.getSystem().getDisplayMetrics().density * 80);

    private CircleImageView progressView;

    private int mTriggerOffset;
    private int mFinalOffset;

    private Gravity mGravity = Gravity.TOP;

    private int mColorScrolling = Color.parseColor("#4285F4");
    private int mColorLoading = Color.parseColor("#EA4335");
    private int mColorYellow = Color.parseColor("#34A853");
    private int mColorGreen = Color.parseColor("#FBBC05");

    public CircleLoadLayout(Context context) {
        this(context, null);
    }

    public CircleLoadLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CircleLoadLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mTriggerOffset = CircleLoadLayout.DEFAULT_FINALOVER_OFFSET;
        mFinalOffset = CircleLoadLayout.DEFAULT_FINALDRAG_OFFSET;
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ensureTarget();
    }

    /**
     * 确保ProgressView不为空
     */
    private void ensureTarget() {
        if (progressView == null) {
            for (int i = 0; i < getChildCount(); i++) {
                View child = getChildAt(i);
                if (child instanceof CircleImageView) {
                    progressView = (CircleImageView) child;
                    break;
                }
            }
        }
        progressView.setColorSchemeColors(mColorScrolling, mColorLoading, mColorYellow, mColorGreen);
        progressView.setStartEndTrim(0, (float) 0.75);
    }

    /**
     * 设置方向
     * @param gravity
     */
    public void setGravity(Gravity gravity) {
        this.mGravity = gravity;
    }

    @Override
    public void onLoadMore() {
        start();
    }

    @Override
    public void onRefresh() {
        start();
    }

    /**
     * 开始动画
     */
    public void start() {
        ensureTarget();
        progressView.start();
    }

    @Override
    public void onPrepare() {
        ensureTarget();
        progressView.setStartEndTrim(0, (float) 0.75);
    }

    @Override
    public void onSwipe(int y, boolean isComplete) {
        ensureTarget();
        if (mGravity == Gravity.BOTTOM) {
            y = -y;
        }
        float alpha = y / (float) mTriggerOffset;
        ViewCompat.setAlpha(progressView, alpha);
        if (!isComplete) {
            progressView.setProgressRotation(y / (float) mFinalOffset);
        }
    }

    @Override
    public void onRelease() {

    }

    @Override
    public void complete() {
        ensureTarget();
        progressView.stop();
    }

    @Override
    public void onReset() {
        ensureTarget();
        ViewCompat.setAlpha(progressView, 1f);
    }

}
