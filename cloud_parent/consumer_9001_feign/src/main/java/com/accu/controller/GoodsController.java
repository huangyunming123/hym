package com.accu.controller;

import com.accu.entity.TGoods;
import com.accu.service.GoodsClientService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@RestController
public class GoodsController {

//    private static final String url = "http://localhost:8001";
    private static final String url = "http://goods";



// 参数    url  requestmap  responseClass
    @Resource
    private GoodsClientService goodsClientService;


    @RequestMapping("/goods/get")
    public List<TGoods> findAll(){
        return goodsClientService.findAll();
    }

    @RequestMapping("/goods/getById/{id}")
    public  List<TGoods> getById(@PathVariable("id") Integer id){

        return goodsClientService.getById(id);
    }

//    @RequestMapping("/goods/add")
//  public  boolean add(TGoods tGoods){
//     return    restTemplate.postForObject(url+"/goods/post",tGoods,Boolean.class);
//}
//
//    @RequestMapping("/goods/discovery")
//    public  Object getdiscovery(){
//        return   restTemplate.getForObject(url+"/goods/discovery",Object.class);
//    }

}
