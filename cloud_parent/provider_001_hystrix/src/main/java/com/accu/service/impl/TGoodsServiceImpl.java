package com.accu.service.impl;

import com.accu.entity.TGoods;
import com.accu.mapper.TGoodsMapper;
import com.accu.service.TGoodsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TGoodsServiceImpl implements TGoodsService {
    @Resource
    TGoodsMapper tGoodsMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public List<TGoods> getGoods() {
        List<TGoods> tGoods = tGoodsMapper.selectList();
        return tGoods;
    }

    @Override
    public List<TGoods> getById(Integer id) {
        return tGoodsMapper.selectById(id);

    }

    @Override
    public boolean insert(TGoods tGoods) {
        boolean add = tGoodsMapper.add(tGoods);
        return add;
    }
}
