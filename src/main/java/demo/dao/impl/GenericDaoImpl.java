package demo.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import demo.dao.GenericDao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

/**
 * @author mingfei.net@Gmail.com
 *         22:25, 4/16/15.
 */
public class GenericDaoImpl<M extends Serializable, ID extends Serializable> implements GenericDao<M, ID> {

    @Autowired
    protected SqlSessionFactory sqlSessionFactory;

    private String namespace;

    @SuppressWarnings("unchecked")
    public GenericDaoImpl() {
        Class<M> modelClass = (Class<M>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        namespace = modelClass.getSimpleName().toLowerCase();
    }

    @Override
    public void add(M model) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        sqlSession.insert(namespace.concat(".add"), model);
        sqlSession.close();
    }

    @Override
    public M query(M model) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        model = sqlSession.selectOne(namespace.concat(".query"), model);
        sqlSession.close();
        return model;
    }

    @Override
    public M search(ID id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        M model = sqlSession.selectOne(namespace.concat(".search"), id);
        sqlSession.close();
        return model;
    }

    @Override
    public List<M> fuzzy(Map params) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<M> models = sqlSession.selectList(namespace.concat(".fuzzy"), params);
        sqlSession.close();
        return models;
    }

    @Override
    public List<M> list() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<M> models = sqlSession.selectList(namespace.concat(".list"));
        sqlSession.close();
        return models;
    }

    @Override
    public void modify(M model) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        sqlSession.update(namespace.concat(".modify"), model);
        sqlSession.close();
    }

    @Override
    public void remove(ID id) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        sqlSession.delete(namespace.concat(".remove"), id);
        sqlSession.close();
    }
}
