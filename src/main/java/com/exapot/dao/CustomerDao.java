package com.exapot.dao;

import com.exapot.mudel.CustomerImpl;
import org.springframework.stereotype.Component;

/**
 * Created by moe on 6/26/17.
 * From https://www.exapot.com
 */
@Component
public interface CustomerDao {
    CustomerImpl getCustomerLogin(String username, String password) throws Exception;
}
