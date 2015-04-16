package com.pooyaco.person.web.controller;

import org.springframework.security.core.context.SecurityContextHolder;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * Created by s.taefi on 2015/03/12.
 */
@ManagedBean
@RequestScoped
public class AuthenticationBean {

    private String username;
    private String password;

    public String doLogin() throws ServletException, IOException {
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        RequestDispatcher dispatcher = ((ServletRequest) context.getRequest()).getRequestDispatcher("/j_spring_security_check?j_username="+username+"&j_password="+password);
        dispatcher.forward((ServletRequest) context.getRequest(),(ServletResponse) context.getResponse());
        FacesContext.getCurrentInstance().responseComplete();
        return null;
    }

    public String doLogout() throws ServletException, IOException{
        SecurityContextHolder.getContext().getAuthentication().setAuthenticated(false);
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        RequestDispatcher dispatcher = ((ServletRequest) context.getRequest()).getRequestDispatcher("/j_spring_security_logout");
        dispatcher.forward((ServletRequest) context.getRequest(),(ServletResponse) context.getResponse());
        FacesContext.getCurrentInstance().responseComplete();
        return null;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String doClear() {
        this.username = "";
        this.password = "";
        return null;
    }
}
