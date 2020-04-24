package com.accu.service;

import com.accu.entity.TGoods;

import java.util.List;

public interface TGoodsService {
public List<TGoods> getGoods();

public List<TGoods> getById(Integer id);

public boolean insert(TGoods tGoods);

}
