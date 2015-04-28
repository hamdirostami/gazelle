package com.pooyaco.person.web.controller;

import org.primefaces.event.MenuActionEvent;
import org.primefaces.model.menu.*;

import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 * Created by s.taefi on 2015/04/22.
 */
@Named
@ViewScoped
public class MainMenuBarController {
    private MenuModel model;
    private String selectedPageName = "AnotherPage.xhtml";

    public MainMenuBarController() {
        model = new DefaultMenuModel();

        //First submenu
        DefaultSubMenu firstSubMenu = new DefaultSubMenu("Dynamic Submenu");

        DefaultMenuItem item = new DefaultMenuItem("External");
        item.setUrl("http://www.primefaces.org");
        item.setIcon("ui-icon-home");
        firstSubMenu.addElement(item);

        model.addElement(firstSubMenu);

        //Second submenu
        DefaultSubMenu secondSubMenu = new DefaultSubMenu("Dynamic Actions");

        item = new DefaultMenuItem("Save");
        item.setIcon("ui-icon-disk");
        item.setCommand("#{menuBean.save}");
        secondSubMenu.addElement(item);

        item = new DefaultMenuItem("اطلاعات اشخاص");
        item.setId("personsMenuItemId");
        item.setIcon("ui-icon-close");
        item.setUpdate(":centercontent");
        item.setParam("SELECTED_PAGE","persons.xhtml");
        item.setCommand("#{mainMenuBarController.redirect}");
        secondSubMenu.addElement(item);

        item = new DefaultMenuItem("صفحه دیگر");
        item.setId("anotherPageMenuItemId");
        item.setIcon("ui-icon-search");
        item.setUpdate(":centercontent");
        item.setParam("SELECTED_PAGE","AnotherPage.xhtml");
        item.setCommand("#{mainMenuBarController.redirect}");
        secondSubMenu.addElement(item);

        model.addElement(secondSubMenu);
    }

    public MenuModel getModel() {
        return model;
    }

    public String getSelectedPageName() {
        return selectedPageName;
    }

    public void setSelectedPageName(String selectedPageName) {
        this.selectedPageName = selectedPageName;
    }

    public String redirect(ActionEvent event){
        MenuItem menuItem = ((MenuActionEvent) event).getMenuItem();
        this.selectedPageName = menuItem.getParams().get("SELECTED_PAGE") == null ? "" : menuItem.getParams().get("SELECTED_PAGE").get(0).toString();
        return null;
    }
}
