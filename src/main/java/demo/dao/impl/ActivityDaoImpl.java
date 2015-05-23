package demo.dao.impl;

import org.springframework.stereotype.Repository;

import demo.dao.ActivityDao;
import demo.model.Activity;

@Repository
public class ActivityDaoImpl extends GenericDaoImpl<Activity, Integer> implements ActivityDao {
}