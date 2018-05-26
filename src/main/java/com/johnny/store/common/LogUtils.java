package com.johnny.store.common;
import com.johnny.store.config.SystemLogSetting;
import com.johnny.store.constant.ConfigFileConsts;
import com.johnny.store.constant.ResponseCodeConsts;
import com.johnny.store.enums.PriorityEnum;
import com.johnny.store.enums.ResponseOptionEnum;
import com.johnny.store.enums.ResponseTypeEnum;
import com.johnny.store.manager.ConfigManager;
import java.io.PrintWriter;
import java.io.StringWriter;

public class LogUtils {
    /**
     * 处理系统异常
     * @param ex 异常对象
     */
    public static void processExceptionLog(Exception ex){
        try{
            System.out.println("process exception log: " + getStackTrace(ex));
            SystemLogSetting systemLogSetting = new SystemLogSetting();
            String logDateTime = DateUtils.getCurrentDateTime();
            String logDir = ConfigManager.getSystemSetting(ConfigFileConsts.SYSTEM_SETTING_KEY_FILE_DIR);
            String logName = logDateTime.replace('-', ' ').replace(':', ' ').concat(".json");
            String logPath = logDir.concat("\\").concat(logName);

            systemLogSetting.setPriority(PriorityEnum.High.toString());
            systemLogSetting.setErrorTime(logDateTime);
            systemLogSetting.setErrorCode(ResponseCodeConsts.UnKnownException);
            systemLogSetting.setErrorType(ResponseTypeEnum.Exception.toString());
            systemLogSetting.setErrorOption(ResponseOptionEnum.Admin.toString());
            systemLogSetting.setErrorMessage(ex.getMessage());
            systemLogSetting.setErrorDetail(getStackTrace(ex));

            String log4Json = JsonUtils.serializeToJson(systemLogSetting);
            FileUtils.createFolder(logDir);
            FileUtils.createFile(logPath, log4Json);
        }catch (Exception e){
            System.out.println("process exception log error: " + getStackTrace(e));
        }
    }

    /**
     * 处理自定义异常
     * @param ex 自定义异常类
     */
    public static void processExceptionLog(StoreException ex){
        try{
            System.out.println("process exception log: " + getStackTrace(ex));
            SystemLogSetting systemLogSetting = new SystemLogSetting();
            String logDateTime = DateUtils.getCurrentDateTime();
            String logDir = ConfigManager.getSystemSetting(ConfigFileConsts.SYSTEM_SETTING_KEY_FILE_DIR);
            String logName = logDateTime.replace('-', ' ').replace(':', ' ').concat(".json");
            String logPath = logDir.concat(logName);

            systemLogSetting.setPriority(PriorityEnum.Normal.toString());
            systemLogSetting.setErrorTime(DateUtils.getCurrentDateTime());
            systemLogSetting.setErrorCode(ex.getErrorCode());
            systemLogSetting.setErrorType(ResponseTypeEnum.Exception.toString());
            systemLogSetting.setErrorOption(ResponseOptionEnum.Admin.toString());
            systemLogSetting.setErrorMessage(ex.getMessage());
            systemLogSetting.setErrorDetail(getStackTrace(ex));

            String log4Json = JsonUtils.serializeToJson(systemLogSetting);
            FileUtils.createFolder(logDir);
            FileUtils.createFile(logPath, log4Json);
        }catch (Exception e){
            System.out.println("process exception log error: " + getStackTrace(e));
        }
    }

    private static String getStackTrace(Exception ex) {
        StringWriter sw = new StringWriter();
        try (PrintWriter pw = new PrintWriter(sw)) {
            ex.printStackTrace(pw);
            return sw.toString();
        }
    }
}
