package administrator.duomengde.com.utils;

import android.content.Context;
import android.util.Log;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import administrator.duomengde.com.base.BaseApp;
import administrator.duomengde.com.base.BaseObservable;
import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

import static administrator.duomengde.com.utils.NetworkUtils.isNetworkConnected;

public class NetInterceptor {
    private static volatile NetInterceptor sNetInterceptor;
    private HttpLoggingInterceptor.Level level;

    private NetInterceptor() {
    }
    public static NetInterceptor getNetInterceptor() {
        if (sNetInterceptor == null) {//考虑效率问题
            synchronized (BaseObservable.class) {
                if (sNetInterceptor == null) {//考虑多个线程问题
                    sNetInterceptor = new NetInterceptor();
                }
            }
        }
        return sNetInterceptor;
    }
    /**
     * 网络优先数据缓存拦截器
     *
     * @return 拦截器对象
     */
    public static Interceptor cacheInterceptor(final Context context) {
        Interceptor interceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();//获取请求
                //没有网络的时候强制使用缓存
                if (!isNetworkConnected(context)) {
                    request = request.newBuilder()
                            .cacheControl(CacheControl.FORCE_CACHE)
                            .build();
                }
                Response response = chain.proceed(request);
                if (isNetworkConnected(context)) {
                    return response.newBuilder()
                            .removeHeader("Pragma")
                            .header("Cache-Control", "public,max-age" + 0)
                            .build();
                }else{
                    int maxTime = 4 * 24 * 60 * 30;
                    return response.newBuilder()
                            .removeHeader("Pragma")
                            .header("Cache-Control", "public,only-if-cached,max-state=" + maxTime)
                            .build();
                }
            }
        };
        return interceptor;
    }

    /**
     * addInterceptor 添加拦截器
     * addNetworkInterceptor 添加网络拦截器，缓存拦截器需要在这个方法和addInterceptor这个里边同时添加
     * sslSocketFactory 信任所有ssl证书，相当于跳过证书
     *
     * @return
     */
    public OkHttpClient getClientWithoutCache() {
        return new OkHttpClient.Builder()
                .cache(new Cache(new File(BaseApp.getInstance().getCacheDir(), "NetCache07"), 10 * 1024 * 1024))
                .connectTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS)
                .addInterceptor(getLogInterceptor())
//                .addInterceptor(cacheInterceptor(BaseApp.getInstance()))
                .addNetworkInterceptor(cacheInterceptor(BaseApp.getInstance()))
                .sslSocketFactory(NetTrustManager.getNetTrustManager().createSSLSocketFactory()).hostnameVerifier(new NetTrustManager.TrustAllHostnameVerifier())
                .build();
    }

    /**
     * @return Log拦截器
     */

    private Interceptor getLogInterceptor() {
        //设置log拦截器拦截内容
        HttpLoggingInterceptor.Level level = HttpLoggingInterceptor.Level.BODY;
        //新建log拦截器
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.e("------buibangpui-------", message);
            }
        });
        loggingInterceptor.setLevel(level);
        return loggingInterceptor;
    }
}
