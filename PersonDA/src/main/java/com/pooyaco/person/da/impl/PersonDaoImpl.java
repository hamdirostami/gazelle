package com.pooyaco.person.da.impl;

import com.pooyaco.person.da.PersonDao;
import com.pooyaco.person.entity.Person;
import com.pooyaco.gazelle.da.impl.BaseDaoImpl;

import javax.inject.Named;

/**
 * Created with IntelliJ IDEA.
 * User: h.rostami
 * Date: 28/01/15
 * Time: 02:03 م
 * To change this template use File | Settings | File Templates.
 */
@Named
public class PersonDaoImpl extends BaseDaoImpl<Person> implements PersonDao{

}
