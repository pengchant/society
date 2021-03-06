package cn.joongky.society.service;

import java.util.List;
import java.util.Map;

import cn.joongky.society.pojo.SocietyApply;

public interface SocietyApplyService {
	// 添加社团申请记录
	SocietyApply addApply(String societyName, String ImageUrl, String introduction, String typeId, String applyerId);

	// 查找总页数和总记录数
	Map<String, Integer> listTotalPage();
	
	// 根据状态查找总页数和总记录数
	Map<String, Integer> listTotalPageByStatus(String status);
	
	// 查找所有的社团类别
	List<SocietyApply> findAll();
	
	// 根据状态查找所有的社团类别
	List<SocietyApply> findAllByStatus(String status);

	// 分页查找所有社团申请记录
	List<SocietyApply> findWithRowBound(Integer page);
	
	// 分页查找所有社团申请记录
	List<SocietyApply> findWithRowBoundAndStatus(Integer page,String status);
	
	//通过id查找申请记录
	SocietyApply findById(String applyId);
	
	//审核通过修改信息
	int updateStatusById(String applyId,String feedBackId,String checkStatus);
	
	// 根据学号分页查找所有社团申请记录
	List<SocietyApply> findByStudentIdWithRowBound(Integer page,String studentId);
	
	//根据学号查找总页数和总记录数
	Map<String, Integer> listTotalPageByStudentId(String studentId);
	
	//修改社团申请信息
	SocietyApply updateApply(String societyApplyId,String societyName,String introduction);
	
	//根据编号删除社团申请信息
	int deleteById(String applyId);
}
