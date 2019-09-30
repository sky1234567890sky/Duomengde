package administrator.duomengde.com.base;

import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import administrator.duomengde.com.R;
import administrator.duomengde.com.api.NormalConfig;
import administrator.duomengde.com.utils.LoadingDialogWithContent;
import administrator.duomengde.com.utils.NetBroadcastReceiver;
import administrator.duomengde.com.utils.NetStatusBroadCast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import static administrator.duomengde.com.utils.NetworkUtils.NETWORK_MOBILE;
import static administrator.duomengde.com.utils.NetworkUtils.NETWORK_NONE;
import static administrator.duomengde.com.utils.NetworkUtils.NETWORK_WIFI;
import static com.scwang.smartrefresh.layout.util.DensityUtil.px2dp;

public class BaseActivity extends AppCompatActivity implements NetStatusBroadCast.NetStatusListener {


    private BaseApp mApplication;
    private LoadingDialogWithContent mDialog;
    private LinearLayoutManager mManager;
    private NetStatusBroadCast mNetStatusBroadCast;




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mApplication = (BaseApp)getApplication();
        mDialog = new LoadingDialogWithContent(this, getString(R.string.loading));
    }
    //进度条
    public void showLoadingDialog() {
        if (!mDialog.isShowing()) mDialog.show();
    }

    public void hideLoadingDialog() {
        if (mDialog.isShowing()) mDialog.dismiss();
    }

    public void showLog(Object content) {
        Log.e(NormalConfig.log1, content.toString());
    }

    public void showLog(boolean content) {
        Log.e(NormalConfig.log1, "" + content);
    }

    //网络状态
    public void registerNetWorkStatus() {
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        mNetStatusBroadCast = new NetStatusBroadCast();
        mNetStatusBroadCast.setNetStatusListener(this);
        registerReceiver(mNetStatusBroadCast, filter);
    }

    //定义刷新
    public void initRecycleView(RecyclerView recyclerView, RefreshLayout refreshLayout) {
        mManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mManager);
        if (refreshLayout != null) {
            refreshLayout.setHeaderHeight(px2dp(120));
            refreshLayout.setFooterHeight(px2dp(100));
            refreshLayout.setOnRefreshListener(new OnRefreshListener() {
                @Override
                public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                    refresh();
                }
            });
            refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
                @Override
                public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                    loadMore();
                }
            });
        }
    }

    private void loadMore() {

    }

    private void refresh() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mDialog!=null)
            if (mDialog.isShowing())mDialog.cancel();
    }

    protected int getLoadType(Object[] t) {
        return (int) ((Object[]) t[1])[0];
    }

    public void showToast(Object content) {
        Toast.makeText(getApplicationContext(), content.toString(), Toast.LENGTH_SHORT).show();
    }

    public void showLongToast(String content) {
        Toast.makeText(getApplicationContext(), content, Toast.LENGTH_LONG).show();
    }

    //监听网络变化
    @Override
    public void onNetChanged(int state) {
        if (state == NETWORK_MOBILE || state == NETWORK_WIFI){
            onNetConnected();
        }else if (state == NETWORK_NONE || state == NETWORK_WIFI){
            onNetDisConnected();
        }
    }

    private void onNetDisConnected() {

    }

    private void onNetConnected() {

    }
}
