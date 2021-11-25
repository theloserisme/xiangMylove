package com.pikachu.utils.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

import com.pikachu.utils.utils.ViewBindingUtils;

import java.util.ArrayList;
import java.util.List;


/**
 * @author pkpk.run
 * @project 通用工程
 * @package com.pikachu.utils.adapter
 * @date 2021/9/9
 * @description
 *
 * 支持多Time布局
 */
public abstract class BaseAdapter<T> extends RecyclerView.Adapter<BaseAdapter.ViewHolder> {
    private List<T> data;

    /**
     * 布局传入
     *
     * @param parent 父控件
     * @param viewType viewType
     * @return ViewBinding class
     */
    public abstract Class<? extends ViewBinding> onCreateView(ViewGroup parent, int viewType);



    /**
     * 业务逻辑
     *
     * @param binding      布局文件 记得强转
     * @param itemData     当前 item 的数据
     * @param position     当前 item 的游标
     * @param itemViewType 当前 item 的类型
     * @param data         所有数据
     */
    public abstract void onBindView(ViewBinding binding, T itemData, int position, int itemViewType, List<T> data);



    public BaseAdapter(List<T> data) {
        if (data == null){
            this.data = new ArrayList<>();
            return;
        }
        this.data = data;
    }

    public BaseAdapter() {
        this(null);
    }

    @NonNull
    @Override
    public BaseAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(ViewBindingUtils.createCls(onCreateView(parent, viewType), LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull BaseAdapter.ViewHolder holder, int position) {
        onBindView(holder.binding, data.get(position), position,  getItemViewType(position), data);
    }


    @Override
    public int getItemCount() {
        return data.size();
    }




    /**
     * 刷新
     */
    public void refresh() {
        notifyDataSetChanged();
    }


    /**
     * 更新数据
     * 自动刷新
     *
     * @param data 数据
     */
    public void refreshData(List<T> data) {
        if (data == null) return;
        this.data.clear();
        this.data = null;
        this.data = new ArrayList<>(data);
        notifyDataSetChanged();
    }


    /**
     * 添加数据
     * 自动刷新
     *
     * @param data 数据
     */
    public void addDataAll(List<T> data) {
        if (data == null) return;
        this.data.addAll(data);
        notifyDataSetChanged();
    }


    /**
     * 添加数据
     * 自动刷新
     *
     * @param data 数据
     */
    public void addDataAll(T data) {
        if (data == null) return;
        this.data.add(data);
        notifyDataSetChanged();
    }




    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ViewBinding binding;
        public View rootView;
        public ViewHolder(ViewBinding view) {
            super(view.getRoot());
            binding = view;
            rootView = view.getRoot();
        }
    }





    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }










    /**
     * 设置 独占一行
     *
     * @param gridLayoutManager 网格管理器
     * @param itemType          需要占一行的item position
     */
    public void setSpanCount(GridLayoutManager gridLayoutManager, int... itemType) {
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                for (int it : itemType) {
                    if (getItemViewType(position) == it)
                        return gridLayoutManager.getSpanCount();
                }
                return 1;
            }
        });
    }


    /**
     * 设置 独占一行
     *
     * @param gridLayoutManager 网格管理器
     * @param positionStart     开始item的 position
     * @param positionEnd       结束item的 position
     */
    public void setSpanCount(GridLayoutManager gridLayoutManager, int positionStart, int positionEnd) {
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (position >= positionStart && position <= positionEnd)
                    return gridLayoutManager.getSpanCount();
                return 1;
            }
        });
    }


}
