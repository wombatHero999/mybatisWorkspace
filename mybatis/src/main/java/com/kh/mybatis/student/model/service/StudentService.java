package com.kh.mybatis.student.model.service;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.common.SqlSessionTemplate;
import com.kh.mybatis.student.model.dao.StudentDao;
import com.kh.mybatis.student.service.model.vo.Student;

public class StudentService {
	
	private StudentDao dao = new StudentDao();
	
	public int insertStudent(Student s) {
		SqlSession session = SqlSessionTemplate.getSession();
		int result = 0;
		try {
			result = dao.insertStudent(session, s);
			session.commit();			
		}catch(Exception e) {
			session.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
		return result;
	}

	public int insertStudentMap(Map<String, Object> param) {
		SqlSession session = SqlSessionTemplate.getSession();
		int result = dao.insertStudentMap(session, param);
		
		if(result > 0) {
			session.commit();
		}else {
			session.rollback();
		}
		session.close();
		return result;		
	}

}






