package administrator.duomengde.com.base;

import android.util.Log;

public class CommonPresenter extends BasePresenter implements ICommonPresenter,ICommonView {

    @Override
    public void getData(int whichApi, Object... t) {
        if (getModel() != null)
            getModel().getData(this, whichApi, t);
        else Log.e("----------", "请求数据时未找到绑定的model------------------");
    }
    @Override
    public void onErrer(int whitchApi, Throwable e) {
        Log.e("---网络请求发生错误：",whitchApi+":"+e != null ? PopupLogUtil.getCrashInfo(e) : "net error————————————");
        if (getView() != null)getView().onErrer(whitchApi, e);
    }

    @Override
    public void onResponce(int whitchApi, Object[] t) {
        if (getView() != null)
            getView().onResponce(whitchApi, t);
        else Log.e("----------", "回传数据时未查询到绑定视图------------------");

    }
}
