package administrator.duomengde.com.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseMvpActivity<M> extends BaseActivity implements ICommonView{
    protected CommonPresenter mPresenter;
    public M mModel;
    protected Unbinder mBind;
    private CommonPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        mBind = ButterKnife.bind(this);
        mPresenter = getPresenter();
        mModel = getModel();
        if (mPresenter!=null)mPresenter.attach(this,(ICommonModel)mModel);
        initView();
        initData();
    }

    protected abstract void initData();

    protected abstract void initView();

    protected abstract M getModel();

    protected abstract int getLayoutId();

    public CommonPresenter getPresenter() {
        return new CommonPresenter();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mBind.unbind();
        mPresenter.detach();
    }
}
