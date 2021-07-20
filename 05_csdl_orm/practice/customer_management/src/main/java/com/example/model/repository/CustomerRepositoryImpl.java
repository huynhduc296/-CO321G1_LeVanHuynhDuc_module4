package com.example.model.repository;

import com.example.model.bean.Customer;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.Collections;
import java.util.List;
@Repository
public class CustomerRepositoryImpl implements CustomerRepository{
    @Override
    public List<Customer> findAll() {
        String queryStr = "SELECT c FROM Customer AS c";
        TypedQuery<Customer> query = BaseRepository.entityManager.createQuery(queryStr, Customer.class);
        return query.getResultList();
    }

    @Override
    public void save(Customer customer) {
        EntityTransaction transaction = BaseRepository.entityManager.getTransaction();
        transaction.begin();
        BaseRepository.entityManager.persist(customer);
        transaction.commit();
    }

    @Override
    public void update(int id, Customer customer) {
        EntityTransaction transaction=BaseRepository.entityManager.getTransaction();
        transaction.commit();
    }

    @Override
    public Customer findOne(int id) {
//                 TypedQuery<Customer> typedQuery =  BaseRepository.entityManager.createQuery(
//                "select c " + "from Customer c " +"where c.id = ?1", Customer.class);
//         typedQuery.setParameter(1, id);
//
//         return typedQuery.getSingleResult();
        return BaseRepository.entityManager.find(Customer.class, id);
    }

    @Override
    public void remove(int id) {

    }
}
