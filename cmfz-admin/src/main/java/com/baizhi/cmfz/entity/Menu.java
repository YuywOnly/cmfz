package com.baizhi.cmfz.entity;


import java.util.List;

public class Menu {

  private long menuId;
  private String menuName;
  private String menuCode;
  private String menuIcon;
  private String menuUrl;
  private long menuLevel;
  private long menuParentId;
  private List<Menu> menus;

  public Menu() {
  }

  public Menu(long menuId, String menuName, String menuCode, String menuIcon, String menuUrl, long menuLevel, long menuParentId, List<Menu> menus) {
    this.menuId = menuId;
    this.menuName = menuName;
    this.menuCode = menuCode;
    this.menuIcon = menuIcon;
    this.menuUrl = menuUrl;
    this.menuLevel = menuLevel;
    this.menuParentId = menuParentId;
    this.menus = menus;
  }

  public long getMenuId() {
    return menuId;
  }

  public void setMenuId(long menuId) {
    this.menuId = menuId;
  }

  public String getMenuName() {
    return menuName;
  }

  public void setMenuName(String menuName) {
    this.menuName = menuName;
  }

  public String getMenuCode() {
    return menuCode;
  }

  public void setMenuCode(String menuCode) {
    this.menuCode = menuCode;
  }

  public String getMenuIcon() {
    return menuIcon;
  }

  public void setMenuIcon(String menuIcon) {
    this.menuIcon = menuIcon;
  }

  public String getMenuUrl() {
    return menuUrl;
  }

  public void setMenuUrl(String menuUrl) {
    this.menuUrl = menuUrl;
  }

  public long getMenuLevel() {
    return menuLevel;
  }

  public void setMenuLevel(long menuLevel) {
    this.menuLevel = menuLevel;
  }

  public long getMenuParentId() {
    return menuParentId;
  }

  public void setMenuParentId(long menuParentId) {
    this.menuParentId = menuParentId;
  }

  public List<Menu> getMenus() {
    return menus;
  }

  public void setMenus(List<Menu> menus) {
    this.menus = menus;
  }

  @Override
  public String toString() {
    return "Menu{" +
            "menuId=" + menuId +
            ", menuName='" + menuName + '\'' +
            ", menuCode='" + menuCode + '\'' +
            ", menuIcon='" + menuIcon + '\'' +
            ", menuUrl='" + menuUrl + '\'' +
            ", menuLevel=" + menuLevel +
            ", menuParentId=" + menuParentId +
            ", menus=" + menus +
            '}';
  }
}
