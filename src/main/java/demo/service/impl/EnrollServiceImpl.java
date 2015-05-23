package demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import demo.dao.GenericDao;
import demo.model.Enroll;
import demo.service.EnrollService;

@Service
public class EnrollServiceImpl extends GenericServiceImpl<Enroll, Integer> implements EnrollService {

    @Override
    @Autowired
    @Qualifier("enrollDaoImpl")
    public void setGenericDao(GenericDao<Enroll, Integer> genericDao) {
        super.genericDao = genericDao;
    }
}