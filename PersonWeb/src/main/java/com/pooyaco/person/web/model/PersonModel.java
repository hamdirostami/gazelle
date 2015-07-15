package com.pooyaco.person.web.model;

import com.pooyaco.gazelle.web.model.GazelleModel;
import com.pooyaco.person.dto.CityDto;
import com.pooyaco.person.dto.PersonDto;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: h.rostami
 * Date: 28/01/15
 * Time: 05:00 م
 * To change this template use File | Settings | File Templates.
 */
@Component
@Scope("view")
public class PersonModel extends GazelleModel implements Serializable {

    public PersonModel() {
        System.out.println("");
    }

    private PersonDto selectedPerson;
    private List<CityDto> cities;
    private Long personId;

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

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
}
