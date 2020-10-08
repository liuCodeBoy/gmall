package com.lxq.gmall.bean;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
public class BaseAttrInfo implements Serializable {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @Column
    private String attrName;
    @Column
    private String catalog3Id;

    //baseAttrValue 集合
    @Transient //表示当前字段不是表中的字段，是业务需要
    private List<BaseAttrValue> attrValueList;

}