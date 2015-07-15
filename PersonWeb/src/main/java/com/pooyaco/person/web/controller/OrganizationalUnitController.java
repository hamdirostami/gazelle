package com.pooyaco.person.web.controller;

import com.pooyaco.gazelle.web.controller.BaseController;
import com.pooyaco.person.si.OrganizationalUnitService;
import com.pooyaco.person.web.model.OrganizationalUnitModel;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created with IntelliJ IDEA.
 * User: h.rostami
 * Date: 28/01/15
 * Time: 04:57 م
 * To change this template use File | Settings | File Templates.
 */
@Named
@ViewScoped
public class OrganizationalUnitController extends BaseController<OrganizationalUnitService> {



    private OrganizationalUnitModel organizationalUnitModel;


    @PostConstruct
    public void init() {
        organizationalUnitModel = new OrganizationalUnitModel();
        getAllOrgUnits();
    }

    private void getAllOrgUnits() {
        organizationalUnitModel.setOrgUnits(getService().getAll());
    }



    public OrganizationalUnitModel getOrganizationalUnitModel() {
        return organizationalUnitModel;
    }

    public void setOrganizationalUnitModel(OrganizationalUnitModel organizationalUnitModel) {
        this.organizationalUnitModel = organizationalUnitModel;
    }
}
