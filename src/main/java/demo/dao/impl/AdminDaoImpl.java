package demo.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import demo.dao.AdminDao;
import demo.model.Admin;

@Repository
public class AdminDaoImpl extends GenericDaoImpl<Admin, Integer> implements AdminDao {
    @Override
    public Admin login(Admin admin) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        admin = sqlSession.selectOne("admin.login", admin);
        sqlSession.close();
        return admin;
    }
}