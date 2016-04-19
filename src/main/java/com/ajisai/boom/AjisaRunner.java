package com.ajisai.boom;

import com.ajisai.boom.domain.Address;
import com.ajisai.boom.domain.Customer;
import com.ajisai.boom.domain.Order;
import com.ajisai.boom.repository.CustomerRepository;
import com.ajisai.boom.repository.OrderRepository;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

import static java.lang.String.format;

@SpringBootApplication()
public class AjisaRunner {

    static Logger logger = LoggerFactory.getLogger(AjisaRunner.class);


    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    OrderRepository orderRepository;

    public void cleanup() {

        try {
            customerRepository.deleteAll();
        }
        catch (Exception e) {
            logger.info("ERROR: " + e.getLocalizedMessage());
        }

    }

    public void createCustomer() {
//        Address address = Address
//                .builder()
//                .country("VN")
//                .city("HN")
//                .build();
        Customer customer = Customer
                .builder()
                .name("NGHIEM DAO")
                //.address(address)
                .build();
        customerRepository.save(customer);
    }

    public void createOrder() {
        Order order1 = Order
                .builder()
                .orderDate("2016-04-15")
                .build();
        Order order2 = Order
                .builder()
                .orderDate("2016-05-12")
                .build();
        List<Order> orders = new LinkedList<>();
        orders.add(order1);
        orders.add(order2);
        Customer customer = customerRepository.findOne(1L);

        if (customer != null) {
            orders.forEach(order -> {
               order.setCustomer(customer);
           });
            customer.setOrders(orders);
            customerRepository.save(customer);
        }
    }

    public void fetchAllCustomer() {
        logger.info("======== start fetch customer =============");
        customerRepository
                .findAll()
                .forEach(customer -> {
                    logger.info(format("customer: id -> %s, name -> %s", customer.getId(), customer.getName()));
                });
    }

    @Transactional
    public void fetchAllOrder() {
        logger.info("======== start fetch order =============");
        customerRepository
                .findAll()
                .forEach(customer -> {
                    customer.getOrders().stream().forEach(order -> {
                        logger.info(format("customer: %s -> order id: %s", customer.getName(), order.getId()));
                    });
                });
    }

    @Transactional
    public void fetchOrdersByCustomerId() {
        logger.info("======= start fetch order by customer id ======");
        orderRepository.findByPk(1L)
                .forEach(order ->
                logger.info(format("order: id -> %s, date -> %s", order.getId(), order.getOrderDate())));
    }

    public static void main(String... args) {
        try (ConfigurableApplicationContext ctx = SpringApplication.run(AjisaRunner.class, args)) {
            AjisaRunner runner = ctx.getBean(AjisaRunner.class);
            //runner.cleanup();
            // runner.createCustomer();
            // runner.createOrder();
            runner.fetchAllCustomer();
            runner.fetchAllOrder();
            runner.fetchOrdersByCustomerId();
        }
    }
}
