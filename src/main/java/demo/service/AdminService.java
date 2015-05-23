package demo.service;

import demo.model.Activity;
import demo.model.Admin;

import java.util.List;

public interface AdminService extends GenericService<Admin, Integer> {
    Admin login(Admin admin);
    public List<Activity> queryEnrollInfo();
    public List<Activity> queryEnrollInfoByActivityId(int activityId);
}