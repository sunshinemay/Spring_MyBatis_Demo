package demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import demo.dao.GenericDao;
import demo.model.Activity;
import demo.service.ActivityService;

@Service
public class ActivityServiceImpl extends GenericServiceImpl<Activity, Integer> implements ActivityService {

    @Override
    @Autowired
    @Qualifier("activityDaoImpl")
    public void setGenericDao(GenericDao<Activity, Integer> genericDao) {
        super.genericDao = genericDao;
    }
}