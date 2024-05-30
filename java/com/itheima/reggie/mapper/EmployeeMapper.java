package com.itheima.reggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.reggie.entity.Employee;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author
 * @Date 2024/5/24 12:06
 * @Version 1.0
 */

@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {

}
