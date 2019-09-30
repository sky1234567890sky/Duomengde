package administrator.duomengde.com.api;

import administrator.duomengde.com.bean.HomePageDataBean;
import io.reactivex.Observable;
import retrofit2.http.GET;

public interface APIService {
    //接口主机名
//    http://gank.io/api/data/%E7%A6%8F%E5%88%A9/20/1

    @GET(NetPort.HomeFuliUrl)
    Observable<HomePageDataBean> getFuliData();
}
