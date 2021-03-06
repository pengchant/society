package cn.joongky.society.service;

import java.util.List;
import java.util.Map;

import cn.joongky.society.pojo.Institute;

public interface InstituteService {
		//添加学院
	  int addInstitute(String instituteName);
	  
	  //查找总页数和总记录数
	  Map<String,Integer> listTotalPage(); 
	  
	  //查找所有的学院
	  List<Institute> findAll();
	  
	  //分页查找所有学院
	  List<Institute> findWithRowBound(Integer page);
	  
	  //根据id删除课程
	  int deleteById(String instituteId);
	  
	  //根据id查找学院信息
	  Institute findById(String instituteId);
	  
	  //根据id修改学院信息
	  Institute updateById(String instituteId,String instituteName);
	  
}
