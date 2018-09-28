package com.example.administrator.ttc;

/**
 * Created by Administrator on 2018/9/4/004.
 */

public class RequestUtils {

    //请求域名
    public static String REQUEST_HEAD = "http://192.168.0.16:8070/timetreaty_certification/";

    //登录接口
    public static String REQUEST_LOGIN = "api/reg/beautifulLogin";

    //获取注册验证码
    public static String REQUEST_GET_CODE = "api/banding/phoneCode";

    //验证注册验证码
    public static String REQUEST_CHECKED_CODE = "api/banding/affirmCode";

    //区块身份认证
    public static String SAVE_IDENTITY_CARD = "api/banding/saveIdentityCard";

    //设置密码
    public static String UPDATE_PWD = "api/banding/updatePwd";

    //找回密码验证ID
    public static String JUDGE_BLOCK_ID = "api/banding/judgeBlockId";

    //找回密码发送验证码
    public static String BLOCK_ID_PHONE_CODE = "api/banding/blockIdPhoneCode";

    //找回密码验证
    public static String FIND_PWD = "api/banding/findPwd";

    //找回区块ID获取验证码
    public static String FIND_BLOCK_ID_CODE = "api/banding/findBlockIdCode";

    //找回区块ID验证验证码
    public static String FIND_BLOCK_ID = "api/banding/findBlockId";

    //找回区块ID重置密码
    public static String FIND_UPDATE_PWD = "api/banding/updatePwd";

    //获取资产
    public static String GET_PROPERTY = "/app/api/content/getProperty";

}
