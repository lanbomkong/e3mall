package cn.biosh.e3mall.dal.model;


import cn.biosh.e3mall.dal.base.BaseModel;
import java.util.Date;

public class TbItemDesc extends BaseModel {

    private Date created;

    private Date updated;

    private String itemDesc;

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

    public String getItemDesc() {
        return itemDesc;
    }

    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc == null ? null : itemDesc.trim();
    }
}