package com.johnny.store.vo;

public class BlockVO extends BaseVO {
    private int blockID;
    private String blockName;
    private int moduleID;
    private ModuleVO moduleVO;

    public int getBlockID() {
        return blockID;
    }

    public void setBlockID(int blockID) {
        this.blockID = blockID;
    }

    public String getBlockName() {
        return blockName;
    }

    public void setBlockName(String blockName) {
        this.blockName = blockName;
    }

    public int getModuleID() {
        return moduleID;
    }

    public void setModuleID(int moduleID) {
        this.moduleID = moduleID;
    }

    public ModuleVO getModuleVO() {
        return moduleVO;
    }

    public void setModuleVO(ModuleVO moduleVO) {
        this.moduleVO = moduleVO;
    }
}
