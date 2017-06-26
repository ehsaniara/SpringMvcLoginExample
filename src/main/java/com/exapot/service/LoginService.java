package com.exapot.service;

import com.exapot.mudel.CustomerImpl;
import org.springframework.stereotype.Service;

/**
 * Created by Ehsaniara
 * From http://www.ehsaniara.com
 */
@Service
public interface LoginService {
    /**
     * @param username
     * @param password
     * @return
     * @throws Exception
     */
    CustomerImpl loginCheck(String username, String password) throws Exception;
}
