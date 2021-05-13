package com.hyb.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 @ConfigurationProperties作用：
 将配置文件中配置的每一个属性的值，映射到这个组件中；
 告诉SpringBoot将本类中的所有属性和配置文件中相关的配置进行绑定
 参数 prefix = “person” : 将配置文件中的person下面的所有属性一一对应

 jsr303校验
     空检查
         @Null       验证对象是否为null
         @NotNull    验证对象是否不为null, 无法查检长度为0的字符串
         @NotBlank   检查约束字符串是不是Null还有被Trim的长度是否大于0,只对字符串,且会去掉前后空格.
         @NotEmpty   检查约束元素是否为NULL或者是EMPTY.

     Booelan检查
         @AssertTrue     验证 Boolean 对象是否为 true
         @AssertFalse    验证 Boolean 对象是否为 false

     长度检查
         @Size(min=, max=) 验证对象（Array,Collection,Map,String）长度是否在给定的范围之内
         @Length(min=, max=) string is between min and max included.

     日期检查
         @Past       验证 Date 和 Calendar 对象是否在当前时间之前
         @Future     验证 Date 和 Calendar 对象是否在当前时间之后
         @Pattern    验证 String 对象是否符合正则表达式的规则

 .......等等
 除此以外，我们还可以自定义一些数据校验规则
 */
@Component
@ConfigurationProperties(prefix = "person")

/**javaConfig绑定我么配置文件的值，可以采取这些方式!
  * 加载指定的配置文件*/
//@PropertySource(value = "classpath:test.properties")
@Validated //数据校验
public class Person {

     //SPEL表达式取出配置文件的值
   //@Value("${name}")
    //@Email(message = "邮箱格式错误")
    private String name;
    private Integer age;
    private Boolean happy;
    private Date birth;
    private Map<String,Object> maps;
    private List<Object> lists;
    private Dog dog;

    public Person() {
    }

    public Person(String name, Integer age, Boolean happy, Date birth, Map<String, Object> maps, List<Object> lists, Dog dog) {
        this.name = name;
        this.age = age;
        this.happy = happy;
        this.birth = birth;
        this.maps = maps;
        this.lists = lists;
        this.dog = dog;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getHappy() {
        return happy;
    }

    public void setHappy(Boolean happy) {
        this.happy = happy;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Map<String, Object> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, Object> maps) {
        this.maps = maps;
    }

    public List<Object> getLists() {
        return lists;
    }

    public void setLists(List<Object> lists) {
        this.lists = lists;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", happy=" + happy +
                ", birth=" + birth +
                ", maps=" + maps +
                ", lists=" + lists +
                ", dog=" + dog +
                '}';
    }
}
