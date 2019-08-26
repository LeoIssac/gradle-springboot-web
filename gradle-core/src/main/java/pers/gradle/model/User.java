package pers.gradle.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * 用户信息实体
 * @Data 添加getter、setter方法
 * @NoArgsConstructor 添加无参构造器
 * @AllArgsConstructor 添加全参构造器
 * @AllArgsConstructor 添加链式调用
 * @ToString 添加toString
 * @author Leo
 * @date 11:53 2019/5/17
 * @param
 * @return
**/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ToString
public class User {
    private Long id;
    private String name;
    private Integer age;
}
