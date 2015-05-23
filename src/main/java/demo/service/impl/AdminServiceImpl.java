package demo.service.impl;

import demo.dao.AdminDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import demo.dao.GenericDao;
import demo.model.Admin;
import demo.service.AdminService;

@Service
public class AdminServiceImpl extends GenericServiceImpl<Admin, Integer> implements AdminService {

    @Override
    @Autowired
    @Qualifier("adminDaoImpl")
    public void setGenericDao(GenericDao<Admin, Integer> genericDao) {
        super.genericDao = genericDao;
    }

    @Override
    public Admin login(Admin admin) {
        return ((AdminDao) genericDao).login(admin);
    }
}