package cn.mldn.travel.service.back.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.mldn.travel.dao.IDeptDAO;
import cn.mldn.travel.dao.IEmpDAO;
import cn.mldn.travel.service.back.IDeptServiceBack;
import cn.mldn.travel.service.back.abs.AbstractService;
import cn.mldn.travel.vo.Dept;
@Service
public class DeptServiceBackImpl extends AbstractService
		implements
			IDeptServiceBack {
	@Resource
	private IDeptDAO deptDAO;
	@Resource
	private IEmpDAO empDAO;
	
	@Override
	public boolean edit(Dept vo) {
		return this.deptDAO.doUpdate(vo);
	} 

	@Override
	public Map<String, Object> list() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("allDepts", this.deptDAO.findAll()) ;
		map.put("allEmps", this.empDAO.findAllManager()) ;
		return map;
	}

}
