/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.datametrix.testdeleteprocess.ejb;

import javax.ejb.Stateless;
import javax.inject.Inject;
import no.datametrix.testdeleteprocess.entity.TSgZoneUser;
import no.datametrix.testdeleteprocess.repository.ZoneUserRepository;

/**
 *
 * @author Helge Waastad <helge.waastad@datametrix.no>
 */
@Stateless
public class SaveBean {

    @Inject
    private ZoneUserRepository zoneUserRepository;

    public TSgZoneUser save(TSgZoneUser user) {
        return zoneUserRepository.save(user);
    }

    public void deleteUser(TSgZoneUser user) {
        user = zoneUserRepository.findBy(user.getId());
        zoneUserRepository.remove(user);
    }
}
