package qdx.bezierviewpager_compile.vPage;

import android.support.v4.view.ViewPager;
import android.support.v7.widget.CardView;
import android.view.View;


public class ShadowTransformer implements ViewPager.OnPageChangeListener, ViewPager.PageTransformer {
    private String TAG = "QDX";
    private CardAdapter mAdapter;

    private float mScaleRatio = 0.1f;

    public void attachViewPager(ViewPager viewPager, CardAdapter adapter) {
        viewPager.addOnPageChangeListener(this);
        mAdapter = adapter;

    }

    /**
     * 设置放大倍数，自身为基数。
     */
    public void setZoomIn(float scaleRatio) {
        mScaleRatio = scaleRatio;
    }


    private float mLastOffset;

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        int realCurrentPosition;
        int nextPosition;
        float realOffset;
        boolean goingLeft = mLastOffset > positionOffset;

        // If we're going backwards, onPageScrolled receives the last position
        // instead of the current one
        if (goingLeft) {
            realCurrentPosition = position + 1;
            nextPosition = position;
            realOffset = 1 - positionOffset;
        } else {
            nextPosition = position + 1;
            realCurrentPosition = position;
            realOffset = positionOffset;
        }


        // Avoid crash on overscroll
        if (nextPosition > mAdapter.getCount() - 1 || realCurrentPosition > mAdapter.getCount() - 1) {
            return;
        }

        CardView currentCard = mAdapter.getCardViewAt(realCurrentPosition);
        // This might be null if a fragment is being used
        // and the views weren't created yet
        if (currentCard != null) {
            currentCard.setScaleX((1 + mScaleRatio * (1 - realOffset)));
            currentCard.setScaleY((1 + mScaleRatio * (1 - realOffset)));
            currentCard.setCardElevation(mAdapter.getMaxElevationFactor() * (1 - realOffset));
        }
        CardView nextCard = mAdapter.getCardViewAt(nextPosition);
        // We might be scrolling fast enough so that the next (or previous) card
        // was already destroyed or a fragment might not have been created yet
        if (nextCard != null) {
            nextCard.setScaleX((1 + mScaleRatio * (realOffset)));
            nextCard.setScaleY((1 + mScaleRatio * (realOffset)));
            nextCard.setCardElevation(mAdapter.getMaxElevationFactor() * (realOffset));
        }


        if (realOffset == 1) {  //适用于：pos从0->3 ,过程中realOffset并不能至于0，所以伸缩会受到影响
            CardView cardView = null;
            if (goingLeft && nextPosition + 2 < mAdapter.getCount()) {
                cardView = mAdapter.getCardViewAt(nextPosition + 2);
            } else if (goingLeft && nextPosition - 2 > 0) {
                cardView = mAdapter.getCardViewAt(nextPosition - 2);
            }
            if (cardView != null) {
                cardView.setCardElevation(0);
                cardView.setScaleX((1));
                cardView.setScaleY((1));
            }
        }

        mLastOffset = positionOffset;
    }


    @Override
    public void transformPage(View page, float position) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
