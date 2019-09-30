package administrator.duomengde.com;

import android.content.Context;
import android.os.Bundle;
import android.transition.Transition;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;
import com.zhouwei.mzbanner.MZBannerView;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.annotations.NonNull;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.home_sourch_iv)
    ImageView homeSourchIv;
    @BindView(R.id.mz_banner)
    Banner mz_banner;
    @BindView(R.id.home_color_rendition_iv)
    ImageView homeColorRenditionIv;
    @BindView(R.id.home_integral_gifts_iv)
    ImageView homeIntegralGiftsIv;
    @BindView(R.id.home_coach_iv)
    ImageView homeCoachIv;
    @BindView(R.id.home_dive_log_iv)
    ImageView homeDiveLogIv;
    @BindView(R.id.bnve)
    BottomNavigationViewEx bnve;
    @BindView(R.id.mz_banner)
    MZBannerView mzBanner;

    private String TAG = MainActivity.class.getName();
    private Button mTime;
    private PopupWindow popupWindow;
    private View inflate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
//        mTime = findViewById(R.id.time);
////        inflate = View.inflate(MainActivity.this, R.layout.pop_picker, null);
//        //弹窗
//        popupWindow = new PopupWindow(inflate,ViewGroup.LayoutParams.MATCH_PARENT,R.dimen.dp_189_5);
//        mTime.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                popupWindow.showAsDropDown(mTime);
//                long drawingTime = inflate.getDrawingTime();
//                Log.i(TAG, "drawingTime: "+drawingTime);
//            }
//        });
//        popupWindow.setBackgroundDrawable(new ColorDrawable());
//        popupWindow.setOutsideTouchable(true);
        initView();
        initData();
        initBNVE();
        initEvent();
    }

    private void initEvent() {
        bnve.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            private int previousPosition = -1;

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int position = 0;
                switch (menuItem.getItemId()) {
                    case R.id.menu_home_startpage1:
                        position = 0;
                        break;
                    case R.id.menu_home_club2:
                        position = 1;
                        break;
                    case R.id.menu_home_fb3:
                        position = 2;
                        //此处return false且在FloatingActionButton没有自定义点击事件时 会屏蔽点击事件
                        //return false;
                        break;
                    case R.id.menu_home_me4:
                        position = 3;
                        break;
                    case R.id.menu_home_personal5:
                        position = 4;
                        break;
                    default:
                        break;
                }
                switchType(position);
                return true;
            }
        });
    }

    private void switchType(int type) {

    }

    private void initBNVE() {
        bnve.enableAnimation(false);
        bnve.enableShiftingMode(false);
        bnve.enableItemShiftingMode(false);
    }

    private void initData() {

    }

    private void initView() {
        mz_banner.setImages(null).setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {

            }
        }).setBannerAnimation(Transformer.RotateUp)
                .isAutoPlay(true)
                .setBannerTitles(null)
                .setDelayTime(4000)
                .setOnBannerListener(new OnBannerListener() {
                    @Override
                    public void OnBannerClick(int position) {

                    }
                }).start();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onResult: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy: ");
    }
}
