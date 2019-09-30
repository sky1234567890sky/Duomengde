package administrator.duomengde.com.base;

public interface ICommonView<T> {
    void onErrer(int whitchApi,Throwable e);
    void onResponce(int whitchApi, T...t);
}
