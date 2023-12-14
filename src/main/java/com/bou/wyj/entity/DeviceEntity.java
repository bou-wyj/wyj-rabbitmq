package com.bou.wyj.entity;
import java.io.Serializable;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 商户设备表
 * 
 * @author xiaoquan
 * @email 1070704388@qq.com
 * @date 2023-07-13 08:12:42
 */
@Data
@Accessors(chain = true)
public class DeviceEntity extends BaseEntity implements Serializable , TransPojo {
	private static final long serialVersionUID = 1L;
	/**
	 * 设备名称
	 */
	private String name;
						
						
	/**
	 * 设备号
	 */
	private String deviceSn;
						
						
	/**
	 * // 设备二维码数据
	 */
	private String deviceCode;
						
						
	/**
	 * // 设备二维码URL
	 */
	private String deviceCodeUrl;
						
						
	/**
	 * 绑定的车牌识别设备编码
	 */
	private String cameraCode;
						
						
	/**
	 * 0 不支持 1 支持
	 */
	private Integer timePayment;
						
						
	/**
	 * 1 正常 0 禁用
	 */
	private Boolean status;
						
						
	/**
	 * 1 狮子座模式  2 其他模式  默认0
	 */
	private Integer deviceModeType;
						
						
	/**
	 * 
	 */
	private Long storeId;
						
						
	/**
	 * 所属站点
	 */
	private Long shopId;
						
						
	/**
	 * 
	 */
	private Long siteId;
						
						
	/**
	 * 设备运行状态
	 */
	private Integer runStatus;
						
						
	/**
	 * 小程序码
	 */
	private String minprogramCodeUrl;
						
						
	/**
	 * 小程序码code
	 */
	private String minprogramCode;

	/**
	 * 收款码
	 */
	private String paymentCode;


	/**
	 * 收款码地址
	 */
	private String paymentCodeUrl;
						
						
	/**
	 * 存放复位状态
	 */
	private Boolean isReset;
						
						
	/**
	 * 
	 */
	private String valVer;
						
						
	/**
	 * 分成比例
	 */
	private Integer shareProportion;
						
						
	/**
	 * 设备运行中
	 */
	private Boolean isRun;
						
						
	/**
	 * 扫码可用支付方式
	 */
	private String payTypes;
						
						
	/**
	 * 0无车 ， 1有车
	 */
	private Boolean isCarStop;
						
						
	/**
	 * 0无排队，1排队中
	 */
	private Integer isQueue;


							
											
}
