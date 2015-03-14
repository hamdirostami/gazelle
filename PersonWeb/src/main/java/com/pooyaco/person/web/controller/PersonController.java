package com.pooyaco.person.web.controller;

import com.pooyaco.gazelle.web.model.GazelleLazyDataModel;
import com.pooyaco.person.dto.CityDto;
import com.pooyaco.person.dto.OrganizationalUnitDto;
import com.pooyaco.person.dto.PersonDto;
import com.pooyaco.person.si.CityService;
import com.pooyaco.person.si.PersonService;
import com.pooyaco.person.web.model.PersonModel;
import org.primefaces.event.SelectEvent;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

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
        clear();
    }


    public void clear() {
        personModel.setSelectedPerson(new PersonDto());
    }


    public void update() {
        if (personModel.getSelectedPerson().getId() == null) {
            personService.persist(personModel.getSelectedPerson());

        } else
            personService.merge(personModel.getSelectedPerson());

        getAll();
        addMessage();
    }

    public void delete() {
        personService.remove(personModel.getSelectedPerson());
        getAll();
        addMessage();
    }


    public void selectAction(SelectEvent event) {
        OrganizationalUnitDto orgUnit = (OrganizationalUnitDto)event.getObject();
        personModel.getSelectedPerson().setOrganizationalUnit(orgUnit);
    }

    public PersonModel getPersonModel() {
        return personModel;
    }



    public void setPersonModel(PersonModel personModel) {
        this.personModel = personModel;
    }

    private void getAll() {
        personModel.setPersons(new GazelleLazyDataModel(personService.getAll(50,0)));
    }

    private void getAllCities() {
        personModel.setCities(cityService.getAll(50, 0));
    }

}
