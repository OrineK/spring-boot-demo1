package com.example.springbootdemo1.constant;

/**
 * 常量
 * @author wuk
 *
 */
public final class Constant {
	/**
	 * 用户session
	 */
	public static final String SESSION_USER = "sessionUser";

	/**
	 * 在线用户
	 */
	public static final String ONLINE_USER = "onlineUser";

	/**
	 * 用户登录过期时间
	 */
	public static final int USER_LOGIN_EXPIRE_TIME = 2*60*60*1000; // 2 小时

	/**
	 * 状态-启用
	 */
	public static final int STATUS_ENABLE = 1;
	/**
	 * 状态-禁用
	 */
	public static final int STATUS_DISABLE = -1;
	/**
	 * 编码方式-UTF-8
	 */
	public static final String ENCODING = "UTF-8";
	/**
	 * http状态码200-成功
	 */
	public static final int HTTP_STATUS_OK = 200;

	/******************验证码常量**********************/
	/**
	 * 手机验证码过期时间(毫秒)
	 */
	public static final int SMS_CODE_TIMEOUT = 600000;
	/**
	 * 手机验证码允许输错次数
	 */
	public static final int SMS_CHECK_TIMES = 3;
	/**
	 * 短信发送成功
	 */
	public static final int SMS_SEND_SUCCESS = 1;
	/**
	 * 短信发送失败
	 */
	public static final int SMS_SEND_FAIL = 2;
	/**
	 * 消息类型，短信
	 */
	public static final int MESSAGE_TYPE_SMS = 1;

	/**
	 * 消息类型	通知类短信
	 */
	public static final int MESSAGE_SORT_SMS = 1;
	/**
	 * 消息类型  	验证码短信
	 */
	public static final int MESSAGE_CODE_SMS = 2;

	/**
	 * 图形验证码-常量
	 */
	public static final String VALID_CODE = "validCode";
	/**
	 * 图形验证码-错误次数
	 */
	public static final String VALID_ERROR_COUNT = "VALID_ERROR_COUNT";
	/**
	 * 图形验证码-错误次数最大错误次数
	 */
	public static final int VALID_ERROR_COUNT_MAX = 5;
	
	/******************用户常量**********************/
	/**
	 * 用户常量-状态-正常
	 */
	public static final int USER_STATUS_NORMAL = 1;
	/**
	 * 用户常量-状态-冻结
	 */
	public static final int USER_STATUS_FREEZE = 2;
	
}
