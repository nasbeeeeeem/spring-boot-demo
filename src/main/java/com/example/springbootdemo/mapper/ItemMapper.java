package com.example.springbootdemo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.springbootdemo.entity.Item;

@Mapper
public interface ItemMapper {
  Item findById(int id);
}
