package com.johnny.store.entity;

/**
 * 宣传广告模块实体
 * @author zhangqiang
 */
public class AdvertiseModuleEntity extends NewBaseEntity{
    private int moduleID;
    private String moduleName;

    public int getModuleID() {
        return moduleID;
    }

    public void setModuleID(int moduleID) {
        this.moduleID = moduleID;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }
}
