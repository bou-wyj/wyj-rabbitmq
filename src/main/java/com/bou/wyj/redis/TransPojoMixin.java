package com.bou.wyj.redis;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import lombok.Data;

import java.util.Map;

public abstract class TransPojoMixin {
    @JsonIgnore
    public abstract Map<String, String> getTransMap();
}
