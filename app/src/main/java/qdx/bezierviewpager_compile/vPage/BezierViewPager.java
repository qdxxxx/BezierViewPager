package qdx.bezierviewpager_compile.vPage;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;


public class BezierViewPager extends ViewPager {
    private boolean touchable = true;
    private ShadowTransformer cardShadowTransformer;

    public BezierViewPager(Context context) {
        super(context);
    }

    public BezierViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setTouchable(boolean isCanScroll) {
        this.touchable = isCanScroll;
    }

    @Override
    public void scrollTo(int x, int y) {
        super.scrollTo(x, y);
    }

    @Override
    public boolean onTouchEvent(MotionEvent arg0) {
        if (touchable) {
            return super.onTouchEvent(arg0);
        } else {
            return false;
        }

    }

    @Override
    public void setCurrentItem(int item, boolean smoothScroll) {
        super.setCurrentItem(item, smoothScroll);
    }

    @Override
    public void setCurrentItem(int item) {
        super.setCurrentItem(item);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent arg0) {
        if (touchable) {
            return super.onInterceptTouchEvent(arg0);
        } else {
            return false;
        }

    }

    public void showTransformer(float zoomIn) {
        if (CardAdapter.class.isInstance(getAdapter())) {
            if (cardShadowTransformer == null) {
                cardShadowTransformer = new ShadowTransformer();
                cardShadowTransformer.attachViewPager(this, (CardAdapter) getAdapter());
            }
            cardShadowTransformer.setZoomIn(zoomIn);

        }
    }

}
