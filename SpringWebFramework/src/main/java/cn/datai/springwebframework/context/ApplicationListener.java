package cn.datai.springwebframework.context;

import cn.datai.springwebframework.util.ContextUtil;
import org.springframework.web.context.ContextLoaderListener;

import javax.servlet.ServletContextEvent;

/**
 * Created by zhangyutao on 2016/1/29.
 */
public class ApplicationListener extends ContextLoaderListener {


    public ApplicationListener() {
        super();
    }
    /**
     * 重载应用上下文初始化方法，多加一个设置绝对路径的值。
     */
    public void contextInitialized(ServletContextEvent sce){
        super.contextInitialized(sce);
        ContextUtil.CONTEXT_PATH = sce.getServletContext().getContextPath();
        ContextUtil.REAL_PATH = sce.getServletContext().getRealPath("/");

    }
}
