package com.bou.wyj.redis;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Map;

public interface DeviceEntityMixin {
    @JsonIgnore
    Map<String, String> getTransMap();

}
