package com.accu.controller;

import com.accu.entity.TGoods;
import com.accu.service.TGoodsService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/goods")
@RestController
public class HelloController {

    @Resource
    DiscoveryClient client;

     @Resource
    TGoodsService tGoodsService;

    @RequestMapping("/get")
    public List<TGoods> sayHello()
    {
        return tGoodsService.getGoods();
    }

    @RequestMapping(value = "/get/{id}",method = RequestMethod.GET)
//    @HystrixCommand(fallbackMethod = "processHystrix_get")
//     在serveice 统一处理
    public List<TGoods> getById(@PathVariable("id") Integer id)
    {
        List<TGoods> byId = tGoodsService.getById(id);
        if(byId.size()==0){
            throw new NullPointerException();
        }
        return byId;
    }
// 要写requestbody 才能接收到
// RequestBody 接收的是请求体里面的数据；只有post才能用
    @RequestMapping(value="/post")
    public boolean add(@RequestBody TGoods tGoods){
        return  tGoodsService.insert(tGoods);
    }


    @RequestMapping(value = "/discovery",method = RequestMethod.GET)
    public Object discovery(){
        List<String> services = client.getServices();
        System.out.println(services);
        List<ServiceInstance> goods = client.getInstances("goods");
        System.out.println(goods);
        return this.client;
    }

    public List<TGoods> processHystrix_get(@PathVariable("id") Integer id){
        TGoods tGoods = new TGoods();
        tGoods.setGoodsName("无此商品");
        List<TGoods> list = new ArrayList<>();
        list.add(tGoods);
        return  list;
    }

}
