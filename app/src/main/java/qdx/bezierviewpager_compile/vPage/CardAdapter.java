package qdx.bezierviewpager_compile.vPage;


import android.support.v7.widget.CardView;

interface CardAdapter {
    CardView getCardViewAt(int position);

    int getCount();

    int getMaxElevationFactor();

    void setMaxElevationFactor(int MaxElevationFactor);
}
