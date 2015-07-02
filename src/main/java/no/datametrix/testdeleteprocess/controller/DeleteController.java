/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.datametrix.testdeleteprocess.controller;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;
import no.datametrix.testdeleteprocess.ejb.SaveBean;
import no.datametrix.testdeleteprocess.entity.TSgZoneUser;
import no.datametrix.testdeleteprocess.repository.ZoneUserRepository;

/**
 *
 * @author Helge Waastad <helge.waastad@datametrix.no>
 */
@Named
@SessionScoped
public class DeleteController implements Serializable {

    private static final long serialVersionUID = 3862874475706330181L;
    private List<TSgZoneUser> users;
    private TSgZoneUser user;

    @Inject
    private SaveBean saveBean;
    @Inject
    private ZoneUserRepository zoneUserRepository;

    @PostConstruct
    public void init() {
        users = zoneUserRepository.findAll();
    }

    public void prepare(ActionEvent event) {
        user = new TSgZoneUser();
    }

    public void saveUser(ActionEvent event) {
//        TRadPostAuth p = new TRadPostAuth();
//        p.setName(user.getName());
//        p.setZoneUser(user);
//        user.getPostAuthCollection().add(p);
        user = saveBean.save(user);
        users.add(user);
    }

    public void delete(ActionEvent event) {
        saveBean.deleteUser(user);
        users.remove(user);
    }

    public TSgZoneUser getUser() {
        return user;
    }

    public List<TSgZoneUser> getUsers() {
        return users;
    }

    public void setUser(TSgZoneUser user) {
        this.user = user;
    }

    public void setUsers(List<TSgZoneUser> users) {
        this.users = users;
    }

}
