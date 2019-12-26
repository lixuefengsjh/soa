package com.lxf.enums;

import lombok.Getter;

/**
 * 用户
 * @author lxf
 */
@Getter
public enum OptionEnum {
    /**
     * 转出
     */
    ROLL_OUT(0,"转出"),
    /**
     * 转入
     */
    ROLL_IN(1,"转入");
    private Integer optionType;
    private String desc;
    OptionEnum(Integer optionType, String desc){
    this.optionType=optionType;
    this.desc=desc;
    }
    public static String getDesc(Integer optionType) {
        OptionEnum[] optionEnums = OptionEnum.values();
        String desc="";
        for (OptionEnum optionEnum : optionEnums) {
            if (optionEnum.getOptionType().equals(optionType)) {
                desc= optionEnum.getDesc();
                break;
            }

        }
        return  desc;
    }
    public  static OptionEnum getInstance(Integer optionType){
        OptionEnum[] optionEnums = OptionEnum.values();
        OptionEnum OptionEnums=null;
        for(OptionEnum optionEnum : optionEnums){
            if(optionEnum.getOptionType().equals(optionType)){
                OptionEnums=optionEnum;
            }
        }
        return OptionEnums;
    }
}

