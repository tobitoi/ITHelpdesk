package com.backend.util.model;

import com.alibaba.fastjson.JSONObject;

import java.util.List;
import java.util.Set;

/**
 * Created by Tobitoi on 12/21/17.
 */
public class One2Many extends JSONObject {
    private Set<String> roleList;
    private Set<String> menuList;
    private Set<String> permissionList;
    private Set<Integer> permissionIds;
    private List<JSONObject> picList;
    private List<JSONObject> menus;
    private List<JSONObject> users;
    private List<JSONObject> permissions;

    public Set<Integer> getPermissionIds() {
        return permissionIds;
    }

    public void setPermissionIds(Set<Integer> permissionIds) {
        this.permissionIds = permissionIds;
    }

    public List<JSONObject> getPicList() {
        return picList;
    }

    public void setPicList(List<JSONObject> picList) {
        this.picList = picList;
    }

    public List<JSONObject> getMenus() {
        return menus;
    }

    public void setMenus(List<JSONObject> menus) {
        this.menus = menus;
    }

    public List<JSONObject> getUsers() {
        return users;
    }

    public void setUsers(List<JSONObject> users) {
        this.users = users;
    }

    public List<JSONObject> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<JSONObject> permissions) {
        this.permissions = permissions;
    }

    public Set<String> getRoleList() {
        return roleList;
    }

    public void setRoleList(Set<String> roleList) {
        this.roleList = roleList;
    }

    public Set<String> getMenuList() {
        return menuList;
    }

    public void setMenuList(Set<String> menuList) {
        this.menuList = menuList;
    }

    public Set<String> getPermissionList() {
        return permissionList;
    }

    public void setPermissionList(Set<String> permissionList) {
        this.permissionList = permissionList;
    }
}
