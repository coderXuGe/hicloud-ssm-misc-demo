package com.huawei.hicloud.pojo;

/**
 * 卷
 * @author dell
 *
 */
public class Volume {
	private Integer id;
	// 序列号
	private String serialNumber;
	// 容量
	private Integer capacity;
	// hdd,ssd
	private String diskType;
	// 区域
	private String region;
	// 描述
	private String description;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public Integer getCapacity() {
		return capacity;
	}
	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}
	public String getdiskType() {
		return diskType;
	}
	public void setdiskType(String diskType) {
		this.diskType = diskType;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "Volume [id=" + id + ", serialNumber=" + serialNumber + ", capacity=" + capacity + ", diskType=" + diskType
				+ ", region=" + region + ", description=" + description + "]";
	}
	
}
