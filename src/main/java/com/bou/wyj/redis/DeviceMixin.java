package com.bou.wyj.redis;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Map;
@JsonIgnoreProperties("transMap")
public abstract class DeviceMixin {
    // @JsonIgnore
    // private  Map<String, String> transMap;
}
