package com.johnny.store.vo;

import java.util.List;

public class AdvertiseVO extends NewBaseVO {
    private Integer moduleID;
    private String moduleName;
    private List<AdvertiseDetailVO> advertiseDetailList4Text;
    private List<AdvertiseDetailVO> advertiseDetailList4Image;
    private List<AdvertiseDetailVO> advertiseDetailList4Video;
    private List<AdvertiseDetailVO> advertiseDetailList4Audio;

    public Integer getModuleID() {
        return moduleID;
    }

    public void setModuleID(Integer moduleID) {
        this.moduleID = moduleID;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public List<AdvertiseDetailVO> getAdvertiseDetailList4Text() {
        return advertiseDetailList4Text;
    }

    public void setAdvertiseDetailList4Text(List<AdvertiseDetailVO> advertiseDetailList4Text) {
        this.advertiseDetailList4Text = advertiseDetailList4Text;
    }

    public List<AdvertiseDetailVO> getAdvertiseDetailList4Image() {
        return advertiseDetailList4Image;
    }

    public void setAdvertiseDetailList4Image(List<AdvertiseDetailVO> advertiseDetailList4Image) {
        this.advertiseDetailList4Image = advertiseDetailList4Image;
    }

    public List<AdvertiseDetailVO> getAdvertiseDetailList4Video() {
        return advertiseDetailList4Video;
    }

    public void setAdvertiseDetailList4Video(List<AdvertiseDetailVO> advertiseDetailList4Video) {
        this.advertiseDetailList4Video = advertiseDetailList4Video;
    }

    public List<AdvertiseDetailVO> getAdvertiseDetailList4Audio() {
        return advertiseDetailList4Audio;
    }

    public void setAdvertiseDetailList4Audio(List<AdvertiseDetailVO> advertiseDetailList4Audio) {
        this.advertiseDetailList4Audio = advertiseDetailList4Audio;
    }
}
