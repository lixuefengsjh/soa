package com.lxf.enums;

import lombok.Getter;

@Getter
public enum OptionEnum {
    ROLL_OUT(0,"转入"),
    ROLL_IN(1,"转出");
    OptionEnum(int optionType,String desc){
        this.optionType=optionType;
        this.desc=desc;
    }
    private int optionType;
    private String desc;
public static OptionEnum getInstance(int optionType){
    OptionEnum[] optionEnums=OptionEnum.values();
    OptionEnum instance=null;
    for(OptionEnum optionEnum:optionEnums){
        if(optionEnum.getOptionType()==optionType){
            instance=optionEnum;
            break;
        }
    }
    return instance;
}
}
