package com.exapot.dao;

import com.exapot.mudel.CustomerImpl;
import org.springframework.stereotype.Component;

/**
 * Created by Ehsaniara
 * From https://www.exapot.com
 */
@Component
public interface CustomerDao {
    CustomerImpl getCustomerLogin(String username, String password) throws Exception;
}
