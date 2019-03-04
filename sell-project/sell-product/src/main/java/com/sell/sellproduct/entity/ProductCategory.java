package com.sell.sellproduct.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Administratoron 2019/2/24
 **/
@Entity
@Table(name = "product_category")
// 提供全参的构造方法
@AllArgsConstructor
// 提供无参的构造方法
@NoArgsConstructor
// 提供get、set方法
@Data
// 提供链式风格的方法调用
@Accessors(chain = true)
public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;

    //类目名字
    private String categoryName;

    //类目编号
    private Integer categoryType;

    //创建时间
    private Date createTime;

    //修改时间
    private Date updateTime;
}
