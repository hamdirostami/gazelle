package com.pooyaco.person.bs;

import com.pooyaco.gazelle.bs.BaseServiceImpl;
import com.pooyaco.person.da.PersonDao;
import com.pooyaco.person.dto.PersonDto;
import com.pooyaco.person.entity.Person;
import com.pooyaco.person.si.PersonService;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: h.rostami
 * Date: 28/01/15
 * Time: 02:44 م
 * To change this template use File | Settings | File Templates.
 */
@Service
public class PersonServiceImpl extends BaseServiceImpl<PersonDto, Person, PersonDao> implements PersonService<PersonDto> {

}
