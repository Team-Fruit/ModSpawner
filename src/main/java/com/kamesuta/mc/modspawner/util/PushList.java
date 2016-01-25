package com.kamesuta.mc.modspawner.util;

import java.util.Collection;
import java.util.LinkedList;

/**
 * 追加をすると逆から削除されていくリストです
 * @author Kamesuta
 * @param <E>
 */
public class PushList<E> extends LinkedList<E>
{
	/**
	 * 長さ
	 */
	protected int max;

	/**
	 * 長さ0で初期化します。
	 */
	public PushList() { }

	/**
	 * 長さを指定して初期化します
	 * @param max 長さ
	 */
	public PushList(int max)
	{
		this.max = max;
	}

	/**
	 * 長さを指定します
	 * @param max 長さ
	 */
	public void setMax(int max)
	{
		this.max = max;
	}

	/**
	 * 長さを返します
	 * @return 長さ
	 */
	public int max()
	{
		return this.max;
	}

	/**
	 * 先頭からオーバー分を除きます
	 */
	protected void cutFirst()
	{
		if (super.size()>this.max()) super.removeRange(0, super.size()-this.max());
	}

	/**
	 * 後尾からオーバー分を除きます
	 */
	protected void cutLast()
	{
		if (super.size()>this.max()) super.removeRange(this.max(), super.size());
	}

    public void addFirst(E e) {
        super.addFirst(e);
        this.cutLast();
    }

    public void addLast(E e) {
        super.addLast(e);
        this.cutFirst();
    }

    public boolean add(E e) {
        boolean b = super.add(e);
        this.cutFirst();
        return b;
    }

    public boolean addAll(Collection<? extends E> c) {
        boolean b = super.addAll(c);
        this.cutFirst();
        return b;
    }

    public boolean addAll(int index, Collection<? extends E> c) {
    	boolean b = super.addAll(index, c);
    	if (index == 0)
			this.cutLast();
    	else
    		this.cutFirst();
        return b;
    }

    public E set(int index, E element) {
    	E e = super.set(index, element);
    	if (index == 0)
			this.cutLast();
    	else
    		this.cutFirst();
        return e;
    }

    public void add(int index, E element) {
    	super.add(index, element);
    	if (index == 0)
			this.cutLast();
    	else
    		this.cutFirst();
    }

    public boolean offer(E e) {
    	boolean b = super.offer(e);
        this.cutFirst();
        return b;
    }

    public boolean offerFirst(E e) {
    	boolean b = super.offerFirst(e);
    	this.cutLast();
        return b;
    }

    public boolean offerLast(E e) {
    	boolean b = super.offerLast(e);
        this.cutFirst();
        return b;
    }

    public void push(E e) {
    	super.push(e);
    	this.cutLast();
    }
}
