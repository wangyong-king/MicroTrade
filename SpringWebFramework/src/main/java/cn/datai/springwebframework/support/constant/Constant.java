package cn.datai.springwebframework.support.constant;

public class Constant {

	//json请求使用的viewName
	public final static String JSON = "json";
	
	
	public final static String ACTION_NAME = "actionName";
	public final static String METHOD_NAME = "methodName";
	public final static String POSTFIX = "postfix";
	
	public final static String BASE_REQUEST_MAPPING = "/{"+ACTION_NAME+"}/{"+METHOD_NAME+"}";
	
	//所有请求使用的jsp中jstl数据的根名称
	public final static String VIEWS = "views";
	public final static String SELECTED_MENU = "selectedMenu";
	public final static String SELECTED_TOP_MENU = "selectedTopMenu";
	
	//请求数据的名称
	public final static String REQ_MESSAGE = "request_message";
	
	//文件传输过程中用的变量名。
	public final static String FILES_INFO = "_files_info";
	
	public final static String IP = "__ip";
	public final static String URL = "__url";
	
	public final static String PARAMETERS = "parameters";
}
