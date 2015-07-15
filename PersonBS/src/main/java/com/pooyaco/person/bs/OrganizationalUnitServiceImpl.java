package com.pooyaco.person.bs;

import com.pooyaco.gazelle.bs.BaseServiceImpl;
import com.pooyaco.person.da.impl.OrganizationalUnitDaoImpl;
import com.pooyaco.person.dto.OrganizationalUnitDto;
import com.pooyaco.person.entity.OrganizationalUnit;
import com.pooyaco.person.si.OrganizationalUnitService;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: h.rostami
 * Date: 28/01/15
 * Time: 02:44 م
 * To change this template use File | Settings | File Templates.
 */
@Service
public class OrganizationalUnitServiceImpl extends BaseServiceImpl<OrganizationalUnitDto, OrganizationalUnit, OrganizationalUnitDaoImpl> implements OrganizationalUnitService<OrganizationalUnitDto> {
}
