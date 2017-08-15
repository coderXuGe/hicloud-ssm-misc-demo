package com.huawei.hicloud.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.huawei.hicloud.pojo.Volume;

@RestController
public class TestController {

	private Logger logger = LoggerFactory.getLogger(TestController.class);


	@ModelAttribute(value = "region")
	public String modelAddAttr(@RequestParam(required = false, defaultValue = "CH") String region, HttpServletRequest request) {
		logger.info("Model Attribute test02 ... " + region);
		
		logger.info("--------------------------");
		
		return region + "#225";
	}

	@RequestMapping(value = "/test/volume", method = RequestMethod.POST)
	public Object testSampleVolume(Volume volume, @RequestParam String regionEm) {
		logger.info("POST volume sample: " + volume);
		logger.info("---- regionForm: " + regionEm);

		return volume;
	}
	
	@RequestMapping(value = "/test/volume/{region}", method = RequestMethod.POST)
	public Object testArgVolume(Volume volume, @ModelAttribute(value = "regionEm") String region) {
		logger.info("POST volume with path1: " + volume);
		logger.info("POST Request Attribute region: " + region);
		
		return volume;
	}

	/** list */
	@RequestMapping(value = "/test/volumes", method = RequestMethod.POST)
	public Object testVolumeList(VolumeForm volumeForm) {
		logger.info("POST volume with path2: " + volumeForm);
		
		return volumeForm;
	}

}

class VolumeForm {
	private Map<String, Volume> volumes;
	
	public Map<String, Volume> getVolumes() {
		return volumes;
	}

	public void setVolumes(Map<String, Volume> volumes) {
		this.volumes = volumes;
	}
}
