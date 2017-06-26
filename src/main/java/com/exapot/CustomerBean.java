package com.exapot;

import com.exapot.mudel.CustomerImpl;
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
import java.util.ResourceBundle;

/**
 * Created by Ehsaniara
 * From http://www.ehsaniara.com
 */
@ManagedBean
@SessionScoped
public class CustomerBean extends CustomerImpl implements Serializable {

    private static final Logger LOG = LoggerFactory.getLogger(CustomerBean.class);
    private final ResourceBundle rb = ResourceBundle.getBundle("multiLingualText", getLocale());

    @Autowired
    private LoginService loginService;
    private boolean login = false;

    @PostConstruct
    private void init() {
        FacesContextUtils
                .getRequiredWebApplicationContext(FacesContext.getCurrentInstance())
                .getAutowireCapableBeanFactory().autowireBean(this);
    }


    public String loginCheck() {
        try {

            //basic control
            if (getUsername() == null || getUsername().trim().equals("")) {
                throw new Exception(rb.getString("InvalidUsername"));
            }

            if (getPassword() == null || getPassword().trim().equals("")) {
                throw new Exception(rb.getString("InvalidPassword"));
            }

            //service control
            CustomerImpl customerImpl = loginService.loginCheck(getUsername(), getPassword());


            if (customerImpl != null) {
                this.setCustomerId(customerImpl.getCustomerId());
                this.setDisplayName(customerImpl.getDisplayName());
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


    public boolean isLogin() {
        return login;
    }

    public void setLogin(boolean login) {
        this.login = login;
    }
}
