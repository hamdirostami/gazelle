package com.pooyaco.person.web.controller;

import com.pooyaco.gazelle.web.controller.BaseController;
import com.pooyaco.person.dto.CityDto;
import com.pooyaco.person.dto.OrganizationalUnitDto;
import com.pooyaco.person.dto.PersonDto;
import com.pooyaco.person.entity.OrganizationalUnit;
import com.pooyaco.person.si.CityService;
import com.pooyaco.person.si.PersonService;
import com.pooyaco.person.web.model.PersonModel;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
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
public class PersonController extends PersonBaseController {

    @Inject
    private transient PersonService personService;

    @Inject
    private transient CityService cityService;

    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }

    public void setCityService(CityService cityService) {
        this.cityService = cityService;
    }


    private PersonModel personModel;


    @PostConstruct
    public void init() {
        personModel = new PersonModel();
        getAll();
        getAllCities();
    }


    public void clear() {
        personModel.setSelectedPerson(new PersonDto());
    }


    public void update() {
        if (personModel.getSelectedPerson().getId() == null) {
            personService.persist(personModel.getSelectedPerson());
            getAll();
        } else
            personService.merge(personModel.getSelectedPerson());

        addMessage();
    }

    public void delete() {
        personService.remove(personModel.getSelectedPerson());
        getAll();
        addMessage();
    }

    public void onCitySelect(SelectEvent event) {
        CityDto city = (CityDto) event.getObject();
        personModel.getSelectedPerson().setCity(city);
    }


    private void addMessage() {
        FacesContext context = FacesContext.getCurrentInstance();

        context.addMessage(null, new FacesMessage("Successful", "Your message: " + "Transaction Completed successfully"));
    }

    public void test(SelectEvent event) {
        OrganizationalUnitDto orgUnit = (OrganizationalUnitDto)event.getObject();
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Org unit selected:", "Id:" + orgUnit.getId() );
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void selectOrgFromDialog(OrganizationalUnitDto orgUnit) {
        RequestContext.getCurrentInstance().closeDialog(orgUnit);
    }


    public PersonModel getPersonModel() {
        return personModel;
    }



    public void setPersonModel(PersonModel personModel) {
        this.personModel = personModel;
    }

    private void getAll() {
        personModel.setPersons(personService.getAll(50, 0));
    }

    private void getAllCities() {
        personModel.setCities(cityService.getAll(50, 0));
    }
}
