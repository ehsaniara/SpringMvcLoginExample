package com.exapot;

import com.exapot.mudel.Customer;
import com.exapot.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.jsf.FacesContextUtils;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by Ehsaniara
 * From https://www.exapot.com
 */
@ManagedBean
@SessionScoped
public class CustomerBean implements Serializable {

    private static final Logger LOG = LoggerFactory.getLogger(CustomerBean.class);

    @Autowired
    private LoginService loginService;


    private Locale locale;
    private final ResourceBundle rb = ResourceBundle.getBundle("multiLingualText", getLocale());
    private String username;
    private String password;

    @PostConstruct
    private void init() {
        FacesContextUtils
                .getRequiredWebApplicationContext(FacesContext.getCurrentInstance())
                .getAutowireCapableBeanFactory().autowireBean(this);
    }

    public String loginCheck() {
        try {
            Customer customer = loginService.loginCheck();
            if (customer != null) {

                return "index";
            } else {

                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_FATAL,
                                rb.getString("Error"),
                                rb.getString("InvalidLogin")));
                return null;
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_FATAL,
                            rb.getString("Error"),
                            e.getMessage()));
            return null;
        }
    }

    //Setters & Getters

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }
}
