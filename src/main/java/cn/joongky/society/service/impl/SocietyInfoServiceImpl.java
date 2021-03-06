package cn.joongky.society.service.impl;

import java.util.Date;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import cn.joongky.society.dao.SocietyInfoMapper;
import cn.joongky.society.pojo.SocietyApply;
import cn.joongky.society.pojo.SocietyInfo;
import cn.joongky.society.service.SocietyInfoService;

@Service("societyInfoService")
public class SocietyInfoServiceImpl implements SocietyInfoService{
	@Inject
	private SocietyInfoMapper sInfoMapper;
	@Override
	public SocietyInfo addByApply(String societyId, SocietyApply sa) {
		SocietyInfo si = new SocietyInfo();
		Date now = new Date();
		si.setSocietyId(societyId);
		si.setIntroduction(sa.getIntroduction());
		si.setSocietyName(sa.getSocietyName());
		si.setLogoUrl(sa.getLogoUrl());
		si.setCreatedTime(now);
		si.setTypeId(sa.getTypeId());
		sInfoMapper.insertSelective(si);
		return sInfoMapper.selectByPrimaryKey(societyId);
	}

	@Override
	public SocietyInfo findBySocietyId(String societyId) {
		return sInfoMapper.selectByPrimaryKey(societyId);
	}

	@Override
	public SocietyInfo updateMemberCount(String societyId, int membersCount) {
		SocietyInfo si = sInfoMapper.selectByPrimaryKey(societyId);
		si.setMembersCount(membersCount);
		sInfoMapper.updateByPrimaryKeySelective(si);
		return sInfoMapper.selectByPrimaryKey(societyId);
	}

	@Override
	public SocietyInfo updateById(String societyId,String societyName, String ImageUrl, String introduction, String typeId) {
		SocietyInfo si = sInfoMapper.selectByPrimaryKey(societyId);
		si.setSocietyName(societyName);
		si.setIntroduction(introduction);
		si.setLogoUrl(ImageUrl);
		System.out.println("typeId:" + typeId);
		si.setTypeId(typeId);
		sInfoMapper.updateByPrimaryKeySelective(si);
		return sInfoMapper.selectByPrimaryKey(societyId);
	}

	@Override
	public SocietyInfo updateByIdWithOutlogo(String societyId, String societyName, String introduction, String typeId) {
		SocietyInfo si = sInfoMapper.selectByPrimaryKey(societyId);
		si.setSocietyName(societyName);
		si.setIntroduction(introduction);
		si.setTypeId(typeId);
		System.out.println("typeId2:" + typeId);
		sInfoMapper.updateByPrimaryKeySelective(si);
		return sInfoMapper.selectByPrimaryKey(societyId);
	}
}
