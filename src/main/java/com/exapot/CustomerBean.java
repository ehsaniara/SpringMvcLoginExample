package com.exapot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.jsf.FacesContextUtils;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;

/**
 * Created by Ehsaniara
 * From https://www.exapot.com
 */
@ManagedBean
@SessionScoped
public class CustomerBean implements Serializable {

    private static final Logger LOG = LoggerFactory.getLogger(CustomerBean.class);

    @PostConstruct
    private void init() {
        FacesContextUtils
                .getRequiredWebApplicationContext(FacesContext.getCurrentInstance())
                .getAutowireCapableBeanFactory().autowireBean(this);
    }

    public String loginCheck() {
        return null;
    }
}
