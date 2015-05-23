package demo.dao;

import demo.model.Admin;

public interface AdminDao extends GenericDao<Admin, Integer> {
    Admin login(Admin admin);
}