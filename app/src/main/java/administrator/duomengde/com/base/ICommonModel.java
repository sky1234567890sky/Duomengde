package administrator.duomengde.com.base;

public interface ICommonModel<T> {
    void getData(ICommonView view,int whitchApi,T...ts);
}
