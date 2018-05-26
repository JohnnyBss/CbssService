package com.johnny.store.manager;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;
import com.johnny.store.common.XmlSerializeUtils;
import com.johnny.store.config.ResponseSetting;
import com.johnny.store.constant.ConfigFileConsts;

public class ConfigManager {
    private static List<ResponseSetting> responseSettingList;

    public static ResponseSetting getResponseSetting(String responseCode) throws FileNotFoundException, UnsupportedEncodingException{
        ResponseSetting resSetting = new ResponseSetting();
        if(responseSettingList == null){
            InputStream stream = ConfigManager.class.getClassLoader().getResourceAsStream(ConfigFileConsts.RESPONSE_SETTING_FILE);

            //String configPath = ConfigManager.class.getClassLoader().getResource(ConfigFileConsts.RESPONSE_SETTING_FILE).getFile();
            //configPath = java.net.URLDecoder.decode(configPath,"utf-8");
            responseSettingList = XmlSerializeUtils.deserializeToObject(stream);
        }
        for (ResponseSetting responseSetting : responseSettingList) {
            if(responseSetting.getResponseCode().equals(responseCode)){
                resSetting = responseSetting;
                break;
            }
        }

        return resSetting;
    }

    public static String getSystemSetting(String key){
        String value = "";
        try {
            //String configPath = java.net.URLDecoder.decode(LogUtils.class.getClassLoader().getResource(ConfigFileConsts.SYSTEM_SETTING).getFile(), "utf-8");
            InputStream stream = ConfigManager.class.getClassLoader().getResourceAsStream(ConfigFileConsts.SYSTEM_SETTING);
            Map<String, String> systemSetting = XmlSerializeUtils.deserializeToObject(stream);
            value = systemSetting.get(key);
        } catch (Exception e){

        }
        return value;
    }
}
