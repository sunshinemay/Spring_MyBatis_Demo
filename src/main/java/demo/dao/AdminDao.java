package demo.dao;

import demo.model.Activity;
import demo.model.Admin;

import java.util.List;

public interface AdminDao extends GenericDao<Admin, Integer> {
    Admin login(Admin admin);

    List<Activity> queryEnrollInfo();
    List<Activity> queryEnrollInfoByActivityId(int activityId);
}