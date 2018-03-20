package project.dajver.com.carouselview.view;

import android.view.View;

import com.gtomato.android.ui.manager.CarouselLayoutManager;
import com.gtomato.android.ui.widget.CarouselView;

/**
 * Created by gleb on 3/20/18.
 */

public class FlatMarryGoRoundSyndTransformer implements CarouselView.ViewTransformer {

    private int mNumPies = 3;
    private double mPieRad = Math.PI * 2.0 / mNumPies;

    private double mHorizontalViewPort = 0.55;
    private double mViewPerspective = -0.6;
    private double mFarScale = 0.55;

    @Override
    public void onAttach(CarouselLayoutManager layoutManager) {
        layoutManager.setDrawOrder(CarouselView.DrawOrder.CenterFront);
    }

    @Override
    public void transform(View view, float position) {
        int parentWidth = ((View) view.getParent()).getMeasuredWidth();
        int parentHeight = ((View) view.getParent()).getMeasuredHeight();

        double rotateRad = Math.PI * 1.5 + position * mPieRad;
        double a = parentWidth * mHorizontalViewPort / 2.0;
        double b = parentHeight * mViewPerspective / 3;

        double x = a * Math.cos(rotateRad);
        double y = b * (1 - Math.sin(rotateRad));

        double maxY = 2 * b;

        double scale = Math.max(0, (mFarScale - 1) * (y - maxY) / (0 - maxY) + 1);

        y -= maxY;

        view.setTranslationX((float) x);
        view.setTranslationY((float) y);
        view.setScaleX((float) scale);
        view.setScaleY((float) scale);
    }
}