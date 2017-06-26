package com.exapot.dao;

import com.exapot.mudel.Customer;
import com.exapot.mudel.CustomerImpl;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.Locale;

/**
 * Created by Ehsaniara
 * From https://www.exapot.com
 */
@Component
public class CustomerDaoImpl implements CustomerDao {

    private JdbcTemplate jdbcTemplate;
    private PlatformTransactionManager transactionManager;

    public CustomerDaoImpl(DataSource dataSource, PlatformTransactionManager transactionManager) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.transactionManager = transactionManager;
    }

    @Override
    public Customer getCustomerLogin(String username, String password) throws Exception {
        return getJdbcTemplate().queryForObject(
                "SELECT * FROM customers c WHERE c.username = ? " +
                        " AND c.password = ? ;",
                new Object[]{username, password}, (rs, rowNum) -> {
                    CustomerImpl customerImpl = new CustomerImpl();
                    customerImpl.setCustomerId(rs.getLong("customer_id"));
                    customerImpl.setLocale(Locale.US);
                    customerImpl.setDisplayName(rs.getString("name"));

                    return customerImpl;
                });
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }


    public PlatformTransactionManager getTransactionManager() {
        return transactionManager;
    }

}
