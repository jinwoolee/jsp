package student.dao;

import mybatis.SqlMapSessionFactory;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import student.model.StudentVo;

public class StudentDaoMybatis implements IStudentDao {
	
	private SqlSessionFactory sqlSessionFactory;
	
	public StudentDaoMybatis(){
		sqlSessionFactory = SqlMapSessionFactory.getSqlMapSessionFactory();
	}
	
	@Override
	public StudentVo getLottoStudent() {
		SqlSession sqlSession	=	sqlSessionFactory.openSession();
		return sqlSession.selectOne("student.getLottoStudent", null);
	}

}
