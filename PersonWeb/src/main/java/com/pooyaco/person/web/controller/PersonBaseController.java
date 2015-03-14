package com.pooyaco.person.web.controller;

import com.pooyaco.gazelle.web.controller.BaseController;
import com.pooyaco.person.dto.CityDto;
import com.pooyaco.person.dto.PersonDto;
import com.pooyaco.person.si.CityService;
import com.pooyaco.person.si.OrganizationalUnitService;
import com.pooyaco.person.si.PersonService;
import com.pooyaco.person.web.model.PersonLovModel;
import com.pooyaco.person.web.model.PersonModel;
import org.primefaces.event.SelectEvent;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
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
public class PersonBaseController extends BaseController {

    @Inject
    private transient OrganizationalUnitService organizationalUnitService;

    public void setOrganizationalUnitService(OrganizationalUnitService organizationalUnitService) {
        this.organizationalUnitService = organizationalUnitService;
    }

    private PersonLovModel personLovModel;


    @PostConstruct
    public void init() {
        personLovModel = new PersonLovModel();
        getAllOrgUnits();
    }

    private void getAllOrgUnits() {
        personLovModel.setOrgUnits(organizationalUnitService.getAll(50, 0));
    }



    public PersonLovModel getPersonLovModel() {
        return personLovModel;
    }

    public void setPersonLovModel(PersonLovModel personLovModel) {
        this.personLovModel = personLovModel;
    }
}
