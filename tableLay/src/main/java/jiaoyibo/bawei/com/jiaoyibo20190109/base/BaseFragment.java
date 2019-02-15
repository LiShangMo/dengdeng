package jiaoyibo.bawei.com.jiaoyibo20190109.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * <p>文件描述：<p>
 * <p>作者：JYB<p>
 * <p>创建时间：2019/1/9<p>
 * <p>更改时间：2019/1/9<p>
 * <p>版本号：1<p>
 */
public abstract class BaseFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(getLayoutId(),container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        initView(view);
        initData();
    }

    protected abstract void initData();

    protected abstract void initView(View view);

    protected abstract int getLayoutId();
}
