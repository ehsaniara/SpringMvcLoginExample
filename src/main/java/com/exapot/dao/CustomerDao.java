package com.exapot.dao;

import com.exapot.mudel.Customer;
import org.springframework.stereotype.Component;

/**
 * Created by Ehsaniara
 * From https://www.exapot.com
 */
@Component
public interface CustomerDao {
    Customer getCustomerLogin(String username, String password) throws Exception;
}
