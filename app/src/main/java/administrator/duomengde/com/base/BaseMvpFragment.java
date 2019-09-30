package administrator.duomengde.com.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseMvpFragment<M> extends BaseFragment implements ICommonView  {

    private View inflate;
    private Unbinder mBind;
    public CommonPresenter mPresenter;
    public M mModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        inflate = inflater.inflate(getLayoutId(), null);
        mBind = ButterKnife.bind(this, inflate);
        initView();
        mPresenter = getPresenter();
        mModel = getModel();
        if (mPresenter != null && mModel != null) mPresenter.attach(this, (ICommonModel) mModel);
        initData();
        return inflate;
    }

    protected abstract void initData();


    protected abstract M getModel();

    protected abstract void initView();

    public CommonPresenter getPresenter() {
        return new CommonPresenter();
    }

    protected abstract int getLayoutId();
    @Override
    public void onDestroy() {
        super.onDestroy();
        mBind.unbind();
        mPresenter.detach();
    }

    protected int getLoadType(Object[] t){
        return  t != null && t.length>1 ? (int) t[1] : 0;
    }
}
