package administrator.duomengde.com.design;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.Image;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import administrator.duomengde.com.R;

/**
 * 加載圖片工具類
 */
@SuppressLint("AppCompatCustomView")
public class ProgressImageView extends ImageView {
    private Animation animation;

    public ProgressImageView(Context context) {
        super(context);
    }

    public ProgressImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ProgressImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        animation = AnimationUtils.loadAnimation(getContext(), R.anim.progress);
        if (getVisibility() == VISIBLE)
            setAnimation(animation);
        super.onFinishInflate();
    }
    @Override
    public void setVisibility(int visibility) {
        if (visibility == VISIBLE) {
            startAnimation(animation);
        } else {
            clearAnimation();
        }
        super.setVisibility(visibility);
    }

}
