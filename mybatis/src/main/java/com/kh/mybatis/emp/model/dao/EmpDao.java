package com.kh.mybatis.emp.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public class EmpDao {

	public List<Map<String, Object>> selectAll(SqlSession session) {
		return session.selectList("emp.selectAll");
	}

	public List<Map<String, Object>> search1(SqlSession session, Map<String, Object> param) {
		return session.selectList("emp.search1", param);
	}

}







