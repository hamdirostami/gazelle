package com.pooyaco.person.web.controller;

import com.pooyaco.gazelle.web.bundle.GazelleResources;
import com.pooyaco.gazelle.web.controller.BaseController;
import com.pooyaco.gazelle.web.controller.GazelleLazyDataController;
import com.pooyaco.person.dto.OrganizationalUnitDto;
import com.pooyaco.person.dto.PersonDto;
import com.pooyaco.person.si.CityService;
import com.pooyaco.person.si.PersonService;
import com.pooyaco.person.web.model.PersonModel;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
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
@RequestScoped
public class PersonController extends BaseController<PersonService> {



    @Inject
    private transient CityService cityService;


    public void setCityService(CityService cityService) {
        this.cityService = cityService;
    }

    private PersonModel model;
    private GazelleLazyDataController<PersonDto> persons;


    @PostConstruct
    public void init() {
        model = new PersonModel();
        getAll();
        getAllCities();
        initializeModel();
    }

    public void initializeModel() {
        model.setSelectedPerson(new PersonDto());
    }

    public void initializePerson(){
        initializeModel();
        RequestContext.getCurrentInstance().execute("PF('personDialog').show()");
    }


    public void update() {
        if (model.getSelectedPerson().getPK() == null) {
            getService().persist(model.getSelectedPerson());

        } else
            getService().merge(model.getSelectedPerson());

        RequestContext.getCurrentInstance().execute("PF('personDialog').hide()");
        showMessage(FacesMessage.SEVERITY_INFO, GazelleResources.SUCCESS_SUMMARY.value(), GazelleResources.SUCCESS_DETAIL.value());
    }

    public void delete() {
        getService().remove(model.getSelectedPerson());
        showMessage(FacesMessage.SEVERITY_INFO, GazelleResources.SUCCESS_SUMMARY.value(), GazelleResources.SUCCESS_DETAIL.value());


    }

    public void selectAction(SelectEvent event) {
        OrganizationalUnitDto orgUnit = (OrganizationalUnitDto) event.getObject();
        model.getSelectedPerson().setOrganizationalUnit(orgUnit);
    }

    public PersonModel getModel() {
        return model;
    }


    public void setModel(PersonModel model) {
        this.model = model;
    }

    private void getAll() {
        if (getPersons() == null)
            setPersons(new GazelleLazyDataController(getService()));
    }

    private void getAllCities() {
        model.setCities(cityService.getAll());
    }




    public GazelleLazyDataController<PersonDto> getPersons() {
        return persons;
    }

    public void setPersons(GazelleLazyDataController<PersonDto> persons) {
        this.persons = persons;
    }

}
