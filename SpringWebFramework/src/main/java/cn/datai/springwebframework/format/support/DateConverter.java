package cn.datai.springwebframework.format.support;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @description
 * @author H.CAAHN
 */
public class DateConverter implements Converter<String, Date> {
    
    private static Logger log                 = LoggerFactory.getLogger(DateConverter.class);
    
    private static String HHMMSS              = "HH:mm:ss";
    
    private static String yyyy_MM_dd          = "yyyy-MM-dd";
    
    private static String yyyy_MM_dd_HH_mm_ss = "yyyy-MM-dd HH:mm:ss";
    
    public Date convert(String source) {
        SimpleDateFormat df = null;
        if (StringUtils.isBlank(source)) {
            return null;
        }
        else if (source.length() == HHMMSS.length()) {
            df = new SimpleDateFormat(HHMMSS);
        }
        else if (source.length() == yyyy_MM_dd.length()) {
            df = new SimpleDateFormat(yyyy_MM_dd);
        }
        else if (source.length() == yyyy_MM_dd_HH_mm_ss.length()) {
            df = new SimpleDateFormat(yyyy_MM_dd_HH_mm_ss);
        }
        else {
            if (log.isDebugEnabled()) {
                log.debug("can not convert, the source string is {}", source);
            }
            return null;
        }
        try {
            return df.parse(source);
        }
        catch (ParseException e) {
            log.error("can not convert, the source string is " + source, e);
            return null;
        }
    }
}
