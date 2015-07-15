package com.pooyaco.person.web.controller;

import com.pooyaco.gazelle.si.BaseService;
import com.pooyaco.gazelle.web.controller.GazelleLazyDataController;
import com.pooyaco.person.dto.PersonDto;
import com.pooyaco.person.si.PersonService;
import org.primefaces.model.SortOrder;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Created by h.rostami on 2015/03/12.
 */
@Component
@Scope("view")
public class PersonLazyDataController extends GazelleLazyDataController<PersonDto> {

    private transient PersonService<PersonDto> personService;

    public PersonLazyDataController(PersonService personService) {
        this.personService = personService;
    }

    public PersonService<PersonDto> getPersonService() {
        return personService;
    }

    public void setPersonService(PersonService<PersonDto> personService) {
        this.personService = personService;
    }

    @Override
    public List<PersonDto> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
        return super.load(first, pageSize, sortField, sortOrder, filters);
    }

    @Override
    public BaseService getService() {
        return getPersonService();
    }
}
