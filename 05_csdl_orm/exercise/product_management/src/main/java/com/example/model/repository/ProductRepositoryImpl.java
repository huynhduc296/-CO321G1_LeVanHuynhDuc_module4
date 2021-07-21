package com.example.model.repository;

import com.example.model.bean.Product;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository {


    @Override
    public List<Product> findAll() {
        String queryStr = "SELECT c FROM Product AS c";
        TypedQuery<Product> query = BaseRepository.entityManager.createQuery(queryStr, Product.class);
        return query.getResultList();
        }

    @Override
    public void save(Product product) {
        EntityTransaction transaction = BaseRepository.entityManager.getTransaction();
        transaction.begin();
        BaseRepository.entityManager.persist(product);
        transaction.commit();
    }

    @Override
    public Product findById(int id) {
         TypedQuery<Product> typedQuery =  BaseRepository.entityManager.createQuery(
                "select c " + "from Product c " +"where c.id = ?1", Product.class);
         typedQuery.setParameter(1, id);

         return typedQuery.getSingleResult();
    }

    @Override
    public void update(int id, Product product) {
        EntityTransaction transaction =BaseRepository.entityManager.getTransaction();
        transaction.begin();
        BaseRepository.entityManager.merge(product);
        transaction.commit();
    }

    @Override
    public void remove(int id) {
        EntityTransaction transaction=BaseRepository.entityManager.getTransaction();
        transaction.begin();
        BaseRepository.entityManager.remove(this.findById(id));
        transaction.commit();
    }

    @Override
    public List<Product> searchByName(String name) {
        return null;
      }
}
