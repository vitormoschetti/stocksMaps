package br.com.stocksmaps.core.adapter;

public abstract class BaseAdapter<TTarget> implements IAdapter<TTarget> {

    protected TTarget to;

    protected BaseAdapter(TTarget to) {
        this.to = to;
    }
}
