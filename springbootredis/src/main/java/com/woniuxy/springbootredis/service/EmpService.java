package com.woniuxy.springbootredis.service;

import com.woniuxy.springbootredis.pojo.Emp;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Cacheable 表示该方法的返回结果会被缓存到redis中，再次查询时会直接调用缓存中的结果
 * value：缓存的名称，在 spring 配置文件中定义，必须指定至少一个
 * key：缓存的 key，可以为空，如果指定要按照 SpEL 表达式编写，如果不指定，则缺省按照方法的所有参数进行组合
 * condition：缓存的条件，可以为空，使用 SpEL 编写，返回 true 或者 false，只有为 true 才进行缓存
 * @CachePut @CachePut标注的方法在执行前不会去检查缓存中是否存在之前执行过的结果，而是每次都会执行该方法，
 * 并将执行结果以键值对的形式存入指定的缓存中。
 * @CacheEvict 是用来标注在需要清除缓存元素的方法或类上的。当标记在一个类上时表示其中所有的方法的执行都会
 * 触发缓存的清除操作。@CacheEvict可以指定的属性有value、key、condition、allEntries和beforeInvocation。
 * 其中value、key和condition的语义与@Cacheable对应的属性类似。
 */
@Service
public class EmpService {
//  模拟查询单个结果
//  执行后，在redis中添加缓存名为emp的文件夹，缓存的key可以为空，此处的key为（value::empno）的组合，#empno引用自方法参数
    @Cacheable(value = "emp",key = "#empno",condition = "#empno!=1002")
    public Emp findByEmpno(Integer empno){
        System.out.println("访问数据库");
        Emp emp = new Emp(empno,"hello",new Date());
        return emp;
    }
//  模拟查询多个结果，返回List
//  有两种key的命名方式，一个是以（value::当前方法名）组合出key的名称
//  另一个是使用（value::当前被调用的方法使用的Cache）组合出key的名称
//  如果不指定key则key名为（value::SimpleKey[]）
//  @Cacheable(value = "emps",key = "#root.methodName")
    @Cacheable(value = "emps",key = "caches[0].name")
    public List<Emp> findEmps(){
        List list = new ArrayList();
        System.out.println("访问MySQL数据库");
        list.add(new Emp(1,"aa",new Date()));
        list.add(new Emp(2,"bb",new Date()));
        list.add(new Emp(3,"cc",new Date()));
        return  list;
    }

//  模拟保存
//  此处指定emp中的empno作为key的组合因子
//  @CachePut指定的value与查询一致,key为emp.empno，正好与查询的key组合方式一致才能保证对应
    @CachePut(value = "emp",key = "#emp.empno")
    public Emp saveEmp(Emp emp){
        System.out.println("保存员工数据到MySQL");
        return emp;
    }

    @CachePut(value = "emp",key = "#emp.empno")
    public Emp updateEmp(Emp emp){
        emp.setEname("helloss");
        System.out.println("更新员工数据");
        return emp;
    }

//  @CacheEvict为删除，指定value和key与查询等一致即可
//  beforeInvocation为是否提前执行缓存操作，默认为false。保证不会因为中途报错而导致缓存和数据库不一致
    @CacheEvict(value = "emp",key = "#empno",beforeInvocation = false)
    public void deleteEmp(int empno){
        System.out.println("MySQL删除员工"+empno);
    }
}
