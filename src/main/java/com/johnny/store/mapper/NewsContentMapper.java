package com.johnny.store.mapper;

import com.johnny.store.entity.NewsContentEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NewsContentMapper extends BaseMapper<NewsContentEntity> {
    List<NewsContentEntity> searchList4News(int newsID);
}
