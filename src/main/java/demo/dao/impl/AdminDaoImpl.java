package demo.dao.impl;

import demo.model.Activity;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import demo.dao.AdminDao;
import demo.model.Admin;

import java.util.List;

@Repository
public class AdminDaoImpl extends GenericDaoImpl<Admin, Integer> implements AdminDao {
    @Override
    public Admin login(Admin admin) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        admin = sqlSession.selectOne("admin.login", admin);
        sqlSession.close();
        return admin;
    }

    @Override
    public List<Activity> queryEnrollInfo() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<Activity> activities = sqlSession.selectList("admin.queryEnrollInfo");
        sqlSession.close();
        return activities;
    }

    @Override
    public List<Activity> queryEnrollInfoByActivityId(int activityId) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<Activity> activities = sqlSession.selectList("admin.queryEnrollInfoByActivityId", activityId);
        sqlSession.close();
        return activities;
    }
}