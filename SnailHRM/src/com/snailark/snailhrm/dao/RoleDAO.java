package com.snailark.snailhrm.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.snailark.snailhrm.model.DepartmentVO;
import com.snailark.snailhrm.model.RoleVO;
import com.snailark.snailhrm.util.HibernateUtils;



public class RoleDAO extends DataAccessObject {
	public RoleDAO() {
		super(RoleVO.class);
	}

	public RoleVO searchByRoleName(RoleVO roleVO) {
		RoleVO savedVO  = null;
		Session session = HibernateUtils.getFactoryObject().getCurrentSession();
		Criteria criteria = session.createCriteria(RoleVO.class);
		Criterion criterion = Restrictions.ilike("roleName", roleVO.getRoleName());
	    criteria.add(criterion);
	    List<RoleVO> roleVOList = criteria.list();
	    if(!roleVOList.isEmpty()){
	    	savedVO = roleVOList.get(0);
	    }
	    return savedVO;
	}
}
