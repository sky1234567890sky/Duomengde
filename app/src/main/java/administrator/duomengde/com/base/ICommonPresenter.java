package administrator.duomengde.com.base;

public interface ICommonPresenter<T> {
    void getData(int whichApi, T... t);
}
