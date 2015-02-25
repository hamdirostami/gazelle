package com.pooyaco.person.web.model;

import com.pooyaco.person.dto.CityDto;
import com.pooyaco.person.dto.PersonDto;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: h.rostami
 * Date: 28/01/15
 * Time: 05:00 م
 * To change this template use File | Settings | File Templates.
 */
public class PersonModel{

    public PersonModel() {
    }

    private List<PersonDto> persons;
    private PersonDto selectedPerson;
    private List<CityDto> cities;

    public List<CityDto> getCities() {
        return cities;
    }

    public void setCities(List<CityDto> cities) {
        this.cities = cities;
    }

    public PersonDto getSelectedPerson() {
        return selectedPerson;
    }

    public void setSelectedPerson(PersonDto selectedPerson) {
        this.selectedPerson = selectedPerson;
    }


    public List<PersonDto> getPersons() {
        return persons;
    }

    public void setPersons(List<PersonDto> persons) {
        this.persons = persons;
    }

}
