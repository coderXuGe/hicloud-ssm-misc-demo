package com.huawei.hicloud.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.huawei.hicloud.common.ResponseResult;
import com.huawei.hicloud.pojo.Volume;
import com.huawei.hicloud.service.StorageService;

@RestController
public class VolumeController {
	@Autowired
	private StorageService storageService;
	
	@RequestMapping(value="/volume/add", method=RequestMethod.POST)
	public ResponseResult add(@RequestBody Volume volume) {
		try {
			System.out.println("Before: " + volume);
			storageService.add(volume);
			System.out.println("After: " + volume);
			return ResponseResult.ok(volume);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseResult.build(400, "Exceptionn @VolumeController.add", null);
		}
	}
	
	@RequestMapping(value="/volume/update", method=RequestMethod.PUT)
	public ResponseResult update(@RequestBody Volume volume) {
		try {
			storageService.update(volume);
			return ResponseResult.ok();
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseResult(400, "Exceptionn @VolumeController.update", null);
		}
	}
	
	@RequestMapping(value="/volume/delete", method=RequestMethod.DELETE)
	public ResponseResult delete(@RequestBody Volume volume) {
		try {
			storageService.delete(volume);
			return ResponseResult.ok();
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseResult(400, "Exceptionn @VolumeController.delete", null);
		}
	}
	
	@RequestMapping(value="/volume/findById/{id}", method=RequestMethod.GET)
	public ResponseResult findById(@PathVariable(value="id") Serializable id) {
		try {
			Volume volume = storageService.findById(id);
			return ResponseResult.ok(volume);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseResult(400, "Exceptionn @VolumeController.findById", null);
		}
	}
	
	@RequestMapping(value="/volume/findList", method=RequestMethod.GET)
	public ResponseResult findList(@RequestBody Volume volume) {
		try {
			List<Volume> list = storageService.findList(volume);
			return ResponseResult.ok(list);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseResult(400, "Exceptionn @VolumeController.findList", null);
		}
	}
	
	@RequestMapping(value="/volume/findAll", method=RequestMethod.GET)
	public ResponseResult findAll() {
		try {
			List<Volume> list = storageService.findAll();
			return ResponseResult.ok(list);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseResult(400, "Exceptionn @VolumeController.findAll", null);
		}
	}
	
	@RequestMapping(value="/volume/findPageList", method=RequestMethod.GET)
	public ResponseResult findPageList(Volume volume) {
		try {
			List<Volume> list = storageService.findPageList(volume);
			return ResponseResult.ok(list);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseResult(400, "Exceptionn @VolumeController.findAll", null);
		}
	}
	
}
