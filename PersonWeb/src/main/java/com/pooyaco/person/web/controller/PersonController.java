package com.pooyaco.person.web.controller;

import com.pooyaco.gazelle.web.bundle.GazelleResources;
import com.pooyaco.gazelle.web.controller.BaseController;
import com.pooyaco.gazelle.web.controller.GazelleLazyDataController;
import com.pooyaco.person.dto.CityDto;
import com.pooyaco.person.dto.OrganizationalUnitDto;
import com.pooyaco.person.dto.PersonDto;
import com.pooyaco.person.si.CityService;
import com.pooyaco.person.si.PersonService;
import com.pooyaco.person.web.model.PersonModel;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.component.StateHelper;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: h.rostami
 * Date: 28/01/15
 * Time: 04:57 م
 * To change this template use File | Settings | File Templates.
 */
@Component
@Scope("view")
public class PersonController extends BaseController<PersonService> {
    public PersonController() {
        System.out.println("g");
    }

    @Autowired
    private transient PersonService<PersonDto> personService;

    private transient Integer counter = 0;

    private transient Integer counter2 = 0;


    public void setPersonService(PersonService<PersonDto> personService) {
        this.personService = personService;
    }

    @Autowired
    private transient CityService<CityDto> cityService;


    public void setCityService(CityService<CityDto> cityService) {
        this.cityService = cityService;
    }

    @Autowired
    private PersonModel model;

    private GazelleLazyDataController persons;


    @PostConstruct
    public void init() {
//        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
//        ServletContext servletContext = (ServletContext) externalContext.getContext();
//        WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext).
//                getAutowireCapableBeanFactory().
//                autowireBean(this);

        getAll();
        getAllCities();
        initializeModel();
    }

    public void initializeModel() {
        model.setSelectedPerson(new PersonDto());
    }

    public void initializePerson() {
        initializeModel();
        RequestContext.getCurrentInstance().execute("PF('personDialog').show()");
    }


    public void update() {
        if (model.getSelectedPerson().getPK() == null) {
            personService.persist(model.getSelectedPerson());

        } else
            personService.merge(model.getSelectedPerson());

        RequestContext.getCurrentInstance().execute("PF('personDialog').hide()");
        showMessage(FacesMessage.SEVERITY_INFO, GazelleResources.SUCCESS_SUMMARY.value(), GazelleResources.SUCCESS_DETAIL.value());
    }

    public void delete() {
        Map<String, String> params =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String action = params.get("personId");
        personService.remove(model.getSelectedPerson());
        showMessage(FacesMessage.SEVERITY_INFO, GazelleResources.SUCCESS_SUMMARY.value(), GazelleResources.SUCCESS_DETAIL.value());


    }

    public void fetchPerson(ActionEvent event) {
        Map<String, String> params =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Long personId = Long.valueOf(params.get("personId"));
        PersonDto selectedPerson = personService.find(personId);
        model.setSelectedPerson(selectedPerson);
    }


    public void selectAction(SelectEvent event) {
        OrganizationalUnitDto orgUnit = (OrganizationalUnitDto) event.getObject();
        model.getSelectedPerson().setOrganizationalUnit(orgUnit);
    }

    public PersonModel getModel() {
//        if (model == null) {
//            if (FacesContext.getCurrentInstance() != null) {
//                StateHelper stateHelper = (StateHelper) FacesContext.getCurrentInstance().getViewRoot().getTransientStateHelper();
//                Object stateModel = stateHelper.get("model");
//                if (stateModel != null)
//                    model = (PersonModel) stateModel;
//                else {
//                    model = new PersonModel();
//                    init();
//                }
//            } else {
//                model = new PersonModel();
//                init();
//            }
//        }

        return model;
    }


    public void setModel(PersonModel model) {
        this.model = model;
    }

    private void getAll() {
        if (getPersons() == null)
            setPersons(new GazelleLazyDataController(personService));
    }

    private void getAllCities() {
        model.setCities(cityService.getAll());
    }

    public GazelleLazyDataController getPersons() {
        return persons;
    }

    public void setPersons(GazelleLazyDataController persons) {
        this.persons = persons;
    }

    public void beforePhase(PhaseEvent event) {
        if (PhaseId.RENDER_RESPONSE.equals(event.getPhaseId())) {
            StateHelper stateHelper = (StateHelper) event.getFacesContext().getViewRoot().getTransientStateHelper();
            stateHelper.put("model", model);
        }
    }

    public void afterPhase(PhaseEvent event) {
    }

    public Integer getCounter() {
        return counter;
    }

    public void setCounter(Integer counter) {
        this.counter = counter;
    }

    public void increaseNumber(ActionEvent event) {
        Integer a = getCounter2() + 1;
        setCounter(a);
        setCounter2(a);
        System.out.println(getCounter2());
    }

    public Integer getCounter2() {
        return counter2;
    }

    public void setCounter2(Integer counter2) {
        this.counter2 = counter2;
    }
}
