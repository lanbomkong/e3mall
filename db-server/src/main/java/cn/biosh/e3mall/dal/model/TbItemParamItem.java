package cn.biosh.e3mall.dal.model;


import cn.biosh.e3mall.dal.base.BaseModel;
import java.util.Date;

public class TbItemParamItem extends BaseModel {

    private Long itemId;

    private Date created;

    private Date updated;

    private String paramData;

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public String getParamData() {
        return paramData;
    }

    public void setParamData(String paramData) {
        this.paramData = paramData == null ? null : paramData.trim();
    }
}