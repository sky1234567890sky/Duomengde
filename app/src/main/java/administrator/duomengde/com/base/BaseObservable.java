package administrator.duomengde.com.base;

import android.database.Observable;
import android.text.TextUtils;

import administrator.duomengde.com.api.APIService;
import administrator.duomengde.com.utils.NetInterceptor;
import io.reactivex.android.schedulers.AndroidSchedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class BaseObservable {
    private static BaseObservable sbaseObservable;
    public static BaseObservable getInstance() {
        if (sbaseObservable == null) {
            synchronized (BaseObservable.class) {
                if (sbaseObservable == null) {
                    sbaseObservable = new BaseObservable();
                }
            }
        }
        return sbaseObservable;
    }
    public <T> APIService getApiService(T... t) {

        return new Retrofit.Builder()
                .baseUrl(t != null && t.length != 0 && !TextUtils.isEmpty((String) t[0]) ? (String) t[0] : NetPort.BASEURL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(NetInterceptor.getNetInterceptor().getClientWithoutCache())
                .build()
                .create(APIService.class);
    }

    public <B> void getNetMessages(Observable<B> observable, final ICommonView publicview, final int type, final int objects) {
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver() {
                    @Override
                    protected void OnSuccess(Object o) {
                        publicview.onSuccess(type, o, objects);
                    }
                    @Override
                    protected void onFailer(Throwable e) {
                        publicview.onFaile(e);
                    }
                });
    }

    public <B> void getNetMessage(Observable<B> observable, final ICommonView publicview, final int type, final Object... objects) {
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver() {
                    @Override
                    protected void OnSuccess(Object o) {
                        publicview.onSuccess(type, o, objects);
                    }
                    @Override
                    protected void onFailer(Throwable e) {
                        publicview.onFaile(e);
                    }
                });
    }
}
