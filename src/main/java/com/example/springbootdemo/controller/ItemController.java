package com.example.springbootdemo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.springbootdemo.entity.Item;
import com.example.springbootdemo.dto.ItemResponse;
import com.example.springbootdemo.mapper.ItemMapper;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/item")
public class ItemController {
  
  @Autowired
  ItemMapper itemMapper;

  @GetMapping("/{id}")
  public ItemResponse findById(@PathVariable int id){
    // DBからidをキーにデータを取得
    Item item = itemMapper.findById(id);

    // Responseにデータを詰めてreturn
    ItemResponse itemResponse = new ItemResponse();
    BeanUtils.copyProperties(item, itemResponse);
    return itemResponse;
  }
  
}
