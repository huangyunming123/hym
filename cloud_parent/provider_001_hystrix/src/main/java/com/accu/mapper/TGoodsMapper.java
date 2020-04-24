package com.accu.mapper;

import com.accu.entity.TGoods;
import com.accu.entity.TGoodsExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TGoodsMapper {

    List<TGoods> selectList();

    List<TGoods> selectById(Integer id);

    boolean add(@Param("tGoods") TGoods tGoods);


    long countByExample(TGoodsExample example);

    int deleteByExample(TGoodsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TGoods record);

    int insertSelective(TGoods record);

    List<TGoods> selectByExampleWithBLOBs(TGoodsExample example);

    List<TGoods> selectByExample(TGoodsExample example);

    TGoods selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TGoods record, @Param("example") TGoodsExample example);

    int updateByExampleWithBLOBs(@Param("record") TGoods record, @Param("example") TGoodsExample example);

    int updateByExample(@Param("record") TGoods record, @Param("example") TGoodsExample example);

    int updateByPrimaryKeySelective(TGoods record);

    int updateByPrimaryKeyWithBLOBs(TGoods record);

    int updateByPrimaryKey(TGoods record);
}