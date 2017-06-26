package com.exapot.service;

import com.exapot.mudel.Customer;
import org.springframework.stereotype.Service;

/**
 * Created by Ehsaniara
 * From https://www.exapot.com
 */
@Service
public interface LoginService {
    Customer loginCheck() throws Exception;
}
