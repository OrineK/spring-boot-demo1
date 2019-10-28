package com.example.springbootdemo1.exception;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.springbootdemo1.constant.ResultCode;
import com.example.springbootdemo1.constant.ResultMsg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobeExcetion {

	private static Logger LOG = LoggerFactory.getLogger(GlobeExcetion.class);

	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public JSON runtimeExcetoin(Exception ex) {
		LOG.error("系统出现未知异常！", ex);
		JSONObject responseJson = new JSONObject();
		responseJson.put("message", ResultMsg.SYSTEM_FAIL);
		responseJson.put("code", ResultCode.SYSTEM_ERROR);
		return responseJson;
	}

	@ExceptionHandler(value = ParamException.class)
	@ResponseBody
	public JSON paramValideException(ParamException ex) {
		LOG.error("参数异常！", ex);
		String message = ex.getMessage();
		JSONObject responseJson = new JSONObject();
		responseJson.put("message", message);
		responseJson.put("code", ResultCode.FAIL);
		return responseJson;
	}

	@ExceptionHandler(value = BusinessException.class)
	@ResponseBody
	public JSON businessException(BusinessException ex) {
		LOG.error("业务异常！", ex);
		JSONObject responseJson = new JSONObject();
		responseJson.put("message", ex.getMessage());
		if ((ResultMsg.SESSION_USER_OVERDUE).equals(ex.getMessage())) {
			responseJson.put("code", ResultCode.NOT_ACCESS);
		} else {
			responseJson.put("code", ResultCode.FAIL);
		}
		return responseJson;
	}

	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	@ResponseBody
	public JSON validException(MethodArgumentNotValidException ex) {
		JSONObject responseJson = new JSONObject();
		responseJson.put("message", ex.getBindingResult().getFieldError().getDefaultMessage());
		responseJson.put("code", ResultCode.NOT_FOUND);
		return responseJson;
	}

}
