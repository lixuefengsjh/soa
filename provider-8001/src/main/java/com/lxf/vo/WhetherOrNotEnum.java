package com.lxf.vo;

import lombok.Data;
import lombok.Getter;

@Getter
public enum WhetherOrNotEnum {
    YES(0,"允许入党"),
    NO(1,"不允许入党");
    private Integer i;
    private String desc;
    WhetherOrNotEnum(Integer i, String desc) {
        this.i=i;
        this.desc=desc;
    }
    public static WhetherOrNotEnum getInstance(Integer i){
        WhetherOrNotEnum[] items= WhetherOrNotEnum.values();
        for(WhetherOrNotEnum item :items){
            if(item.getI().equals(i)){
                    return item;
            }
        }
        return null;
    }
    public static Integer getI(WhetherOrNotEnum whetherOrNotEnum){
        WhetherOrNotEnum[] items= WhetherOrNotEnum.values();
        for(WhetherOrNotEnum item :items){
            if(item.equals(whetherOrNotEnum)){
                return item.getI();
            }
        }
        return null;
    }
}
