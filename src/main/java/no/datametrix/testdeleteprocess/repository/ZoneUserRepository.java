/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.datametrix.testdeleteprocess.repository;

import no.datametrix.testdeleteprocess.entity.TSgZoneUser;
import org.apache.deltaspike.data.api.AbstractEntityRepository;
import org.apache.deltaspike.data.api.Repository;

/**
 *
 * @author Helge Waastad <helge.waastad@datametrix.no>
 */
@Repository
public abstract class ZoneUserRepository extends AbstractEntityRepository<TSgZoneUser, String> {

}
