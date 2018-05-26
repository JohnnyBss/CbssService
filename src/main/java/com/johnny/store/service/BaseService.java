package com.johnny.store.service;

import com.johnny.store.vo.UnifiedResponse;

public interface BaseService<T, V, E> {
    UnifiedResponse findList(int pageNumber, int pageSize);

    UnifiedResponse find(int id);

    UnifiedResponse existCheck(String name);

    UnifiedResponse add(T dto);

    UnifiedResponse change(T dto);

    UnifiedResponse delete(int id);

    V convertEntityToVo(E entity);

    E convertDtoToEntity(T dto);
}