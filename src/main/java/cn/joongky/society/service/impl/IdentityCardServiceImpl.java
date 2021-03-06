package cn.joongky.society.service.impl;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import cn.joongky.society.dao.IdentityCardMapper;
import cn.joongky.society.pojo.IdentityCard;
import cn.joongky.society.pojo.IdentityCardExample;
import cn.joongky.society.service.IdentityCardService;
import cn.joongky.society.util.BasicSysUtil;

@Service("identityCardService")
public class IdentityCardServiceImpl implements IdentityCardService {
	@Inject
	private IdentityCardMapper icMapper;

	@Override
	public int addCard(String ImageUrl, String studentId, String type) {
		IdentityCard ic1 = new IdentityCard();
		Date now = new Date();
		ic1.setIdentityCardId(BasicSysUtil.getUUID());
		ic1.setCardUrl(ImageUrl);
		ic1.setStudentId(studentId);
		ic1.setCreatedTime(now);
		ic1.setUpdatedTime(now);
		ic1.setType(type);
		int result1 = icMapper.insertSelective(ic1);
		return result1;
	}

	@Override
	public List<IdentityCard> getIdList(String studentId) {
		IdentityCardExample example = new IdentityCardExample();
		example.or().andStudentIdEqualTo(studentId);
		return icMapper.selectByExample(example);
	}

	@Override
	public int updateCard(String ImageUrl, String studentId, String type) {
		Date now = new Date();
		IdentityCardExample example = new IdentityCardExample();
		example.or().andStudentIdEqualTo(studentId).andTypeEqualTo(type);
		IdentityCard idCard = icMapper.selectByExample(example).get(0);
		idCard.setCardUrl(ImageUrl);
		idCard.setUpdatedTime(now);
		icMapper.updateByPrimaryKeySelective(idCard);
		return icMapper.updateByPrimaryKeySelective(idCard);
	}

	@Override
	public IdentityCard getByTypeAndId(String studentId, String type) {
		IdentityCardExample example = new IdentityCardExample();
		example.or().andStudentIdEqualTo(studentId).andTypeEqualTo(type);
		if (icMapper.selectByExample(example).size()>0) {
			IdentityCard idCard = icMapper.selectByExample(example).get(0);
			return idCard;
		}else{
			return null;
		}

		
	}

}
