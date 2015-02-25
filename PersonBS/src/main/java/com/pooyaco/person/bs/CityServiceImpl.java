package com.pooyaco.person.bs;

import com.pooyaco.gazelle.bs.BaseServiceImpl;
import com.pooyaco.person.da.impl.CityDaoImpl;
import com.pooyaco.person.dto.CityDto;
import com.pooyaco.person.entity.City;
import com.pooyaco.person.si.CityService;

import javax.inject.Named;

/**
 * Created with IntelliJ IDEA.
 * User: h.rostami
 * Date: 28/01/15
 * Time: 02:44 م
 * To change this template use File | Settings | File Templates.
 */
@Named
public class CityServiceImpl extends BaseServiceImpl<CityDto, City, CityDaoImpl> implements CityService<CityDto> {
}
