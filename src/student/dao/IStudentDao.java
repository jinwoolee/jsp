package student.dao;

import student.model.StudentVo;

public interface IStudentDao {
	StudentVo getLottoStudent();
	
	//구현체 이름 : StudentDaoMybatis.java
	//sqlmapper : mybatis/student.xml
	//mybatis/SqlMapConfig.xml에 sqlmapper 추가 필요
}
