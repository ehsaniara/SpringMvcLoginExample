package com.exapot.service;

import com.exapot.dao.CustomerDao;
import com.exapot.mudel.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Ehsaniara
 * From http://www.ehsaniara.com
 */
@Service
public class LoginServiceImpl implements LoginService {


    @Autowired
    private CustomerDao customerDao;

    /**
     * @param username
     * @param password
     * @return
     * @throws Exception
     */
    @Override
    public Customer loginCheck(String username, String password) throws Exception {

        try {
            return customerDao.getCustomerLogin(username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}
