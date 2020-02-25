package com.example.salesrestendpoint.service;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.HashMap;
import java.util.Map;

@Component
public class ResultMap {


    Map<String, DeferredResult> resMap;

    public ResultMap() {
        resMap = new HashMap<String, DeferredResult>();
    }

   public void put(String id, DeferredResult res){
        resMap.put(id,res);
    }

    public String get(String key){
       String value = String.valueOf(resMap.get(key));
       return value;
    }



}
