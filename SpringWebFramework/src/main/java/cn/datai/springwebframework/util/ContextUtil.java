package cn.datai.springwebframework.util;

import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ContextUtil {
	
	private static String RESOURCE_NAME;
	private static String HOST_KEY = "web.host";
	
	private static Logger logger = Logger.getLogger(ContextUtil.class);

	/**
	 * 项目部署的绝对路径。
	 */
	public static String REAL_PATH = null;
	
	public static String CONTEXT_PATH = null;
	
	public static String HOST = null;
	
	private void init(){
		InputStream in = ContextUtil.class.getClassLoader().getResourceAsStream(RESOURCE_NAME);
		Properties props = new Properties();
		try {
			props.load(in);
		} catch (IOException e) {
			logger.error("加载[" + RESOURCE_NAME + "]失败",e);
		}
		
		HOST = props.getProperty(HOST_KEY);
	}
	
	private static List<String> VALID_URL = new ArrayList<String>();
	
	public void setInvalidUrl(List<String> list){
		VALID_URL = list;
	}
	
	public static boolean isHoldInCookieValid(String url){
		
		if(url==null) return true;
		
		for(String u : VALID_URL){
			if(url.contains(u)) return false;
		}
		
		return true;
	}
	
	/**
     * 获取用户的真实访问IP
     * @param request
     * @return
     */
    public static String getRealIp(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("http_client_ip");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        // 如果是多级代理，那么取第一个ip为客户ip
        if (ip != null && ip.indexOf(",") != -1) {
            ip = ip.substring(ip.lastIndexOf(",") + 1, ip.length()).trim();
        }
        return ip;
    }
	
	public void setResourceName(String resource){
		
		RESOURCE_NAME = resource;
		this.init();
	}
	//截取Organization
	public static String getOrganizationName(String str){
		
		if(str==null) return "";
		String[] strs = str.split("\\|");
		for(int i=0;i<strs.length;i++){
			if(i==strs.length-1){
				return strs[i];
			}
		}
		return "";
	}
}
