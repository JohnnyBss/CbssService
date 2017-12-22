package com.johnny.store.manager;

import com.johnny.store.common.LogUtils;
import com.johnny.store.config.ResponseSetting;
import com.johnny.store.constant.ResponseCodeConsts;
import com.johnny.store.dto.UnifiedResponse;
import com.johnny.store.enums.ResponseOptionEnum;
import com.johnny.store.enums.ResponseTypeEnum;

public class UnifiedResponseManager {
    public static <T> UnifiedResponse buildSuccessResponse(T data){
        try{
            UnifiedResponse<T> unifiedResponse = new UnifiedResponse<>();
            ResponseSetting responseSetting = ConfigManager.getResponseSetting(ResponseCodeConsts.SUCCESS);
            unifiedResponse.setResponseCode(responseSetting.getResponseCode());
            unifiedResponse.setResponseMessage(responseSetting.getResponseMessage());
            unifiedResponse.setResult(responseSetting.isResult());
            unifiedResponse.setResponseType(responseSetting.getResponseType());
            unifiedResponse.setResponseOption(responseSetting.getResponseOption());
            unifiedResponse.setResponseData(data);
            return unifiedResponse;
        }catch (Exception ex){
            LogUtils.processExceptionLog(ex);
            return buildErrorResponse(ResponseCodeConsts.BuildResponseException);
        }
    }

    public static <T> UnifiedResponse buildSuccessResponse(int totalCount, T data){
        try{
            UnifiedResponse<T> unifiedResponse = new UnifiedResponse<>();
            ResponseSetting responseSetting = ConfigManager.getResponseSetting(ResponseCodeConsts.SUCCESS);
            unifiedResponse.setResponseCode(responseSetting.getResponseCode());
            unifiedResponse.setResponseMessage(responseSetting.getResponseMessage());
            unifiedResponse.setResult(responseSetting.isResult());
            unifiedResponse.setResponseType(responseSetting.getResponseType());
            unifiedResponse.setResponseOption(responseSetting.getResponseOption());
            unifiedResponse.setTotalCount(totalCount);
            unifiedResponse.setResponseData(data);
            return unifiedResponse;
        }catch (Exception ex){
            LogUtils.processExceptionLog(ex);
            return buildErrorResponse(ResponseCodeConsts.BuildResponseException);
        }
    }

    public static <T> UnifiedResponse buildSuccessResponse(int affectCount){
        try{
            UnifiedResponse<T> unifiedResponse = new UnifiedResponse<>();
            ResponseSetting responseSetting = ConfigManager.getResponseSetting(ResponseCodeConsts.SUCCESS);
            unifiedResponse.setResponseCode(responseSetting.getResponseCode());
            unifiedResponse.setResponseMessage(responseSetting.getResponseMessage());
            unifiedResponse.setResult(responseSetting.isResult());
            unifiedResponse.setResponseType(responseSetting.getResponseType());
            unifiedResponse.setResponseOption(responseSetting.getResponseOption());
            unifiedResponse.setAffectCount(affectCount);
            return unifiedResponse;
        }catch (Exception ex){
            LogUtils.processExceptionLog(ex);
            return buildErrorResponse(ResponseCodeConsts.BuildResponseException);
        }
    }

    public static <T> UnifiedResponse buildFailedResponse(String responseCode){
        try{
            UnifiedResponse<T> unifiedResponse = new UnifiedResponse<>();
            ResponseSetting responseSetting = ConfigManager.getResponseSetting(responseCode);
            unifiedResponse.setResponseCode(responseSetting.getResponseCode());
            unifiedResponse.setResponseMessage(responseSetting.getResponseMessage());
            unifiedResponse.setResult(responseSetting.isResult());
            unifiedResponse.setResponseType(responseSetting.getResponseType());
            unifiedResponse.setResponseOption(responseSetting.getResponseOption());
            unifiedResponse.setResponseData(null);
            return unifiedResponse;
        }catch (Exception ex){
            LogUtils.processExceptionLog(ex);
            return buildErrorResponse(ResponseCodeConsts.BuildResponseException);
        }
    }

    private static <T> UnifiedResponse buildErrorResponse(String responseCode){
        UnifiedResponse<T> unifiedResponse = new UnifiedResponse<>();
        unifiedResponse.setResponseCode(responseCode);
        unifiedResponse.setResponseMessage("build unified response exception");
        unifiedResponse.setResult(false);
        unifiedResponse.setResponseType(ResponseTypeEnum.Exception);
        unifiedResponse.setResponseOption(ResponseOptionEnum.Admin);
        unifiedResponse.setResponseData(null);
        return unifiedResponse;
    }
}