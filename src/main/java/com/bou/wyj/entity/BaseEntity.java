package com.bou.wyj.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * Entity基类
 *
 * @author 阿沐 babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
@Data
public abstract class BaseEntity {
    /**
     * id
     */
    private Long id;

    /**
     * 创建者
     */
    private Long  createUser;

    /**
     * 创建时间
     */

    private LocalDateTime createTime;

    /**
     * 更新者
     */

    private Long  updateUser;

    /**
     * 更新时间
     */

    private LocalDateTime updateTime;

    /**
     * 删除标记
     */
    private Boolean isDelete;
}
