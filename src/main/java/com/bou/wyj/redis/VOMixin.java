package com.bou.wyj.redis;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Map;

public abstract class VOMixin {
    @JsonIgnore
    public abstract Map<String, String> getTransMap();
}
