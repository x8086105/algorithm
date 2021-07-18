package com.example;

public enum TypeEnum {
    Stratey(1,"策略1"),
    Straey2(2,"策略2");
    private Integer type;
    private String desc;
    TypeEnum(Integer type, String desc){
        this.type = type;
        this.desc = desc;
    }

}
