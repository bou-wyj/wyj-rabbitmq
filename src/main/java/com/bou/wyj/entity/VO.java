package com.bou.wyj.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.lang.reflect.Field;
import java.util.*;

public interface VO {
    /**
     * 子类id字段缓存
     */
    @JsonIgnore
    Map<Class<?>, Field> ID_FIELD_CACHE_MAP = new HashMap<>();

    Set<Class> ID_ANNO = new HashSet<>();


    ThreadLocal<Map<String, Map<String, String>>> TRANS_MAP_CACHE = new ThreadLocal<>();

    default void clearTransCache() {
        //test
    }

    /**
     * 获取翻译map
     *
     * @return 翻译map
     */
    default Map<String, String> getTransMap() {
        //test
        return new HashMap<>();
    }

    /**
     * 获取主键
     *
     * @return 主键
     */
    @JsonIgnore
    @JSONField(serialize = false)
    default Object getPkey() {
        return null;
    }


}
