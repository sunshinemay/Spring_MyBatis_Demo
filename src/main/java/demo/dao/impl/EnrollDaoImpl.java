package demo.dao.impl;

import org.springframework.stereotype.Repository;

import demo.dao.EnrollDao;
import demo.model.Enroll;

@Repository
public class EnrollDaoImpl extends GenericDaoImpl<Enroll, Integer> implements EnrollDao {
}