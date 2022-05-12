package com.company.repository;

import com.company.model.Card;
import com.company.model.User;
import com.company.utils.JPAUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class UserRepository {

    public static  void create(User userToSave){
        //create a manager to do all the CRUD operations with student object
        //i can create manager cause I created JPAUtils
        EntityManager manager = JPAUtils.getEntityManger();
        //manager call Transaction, that is, it is a state to persist
        EntityTransaction transaction = manager.getTransaction();
        //let s start with begin the operations, thanks to transaction object
        transaction.begin();
        //prepares the operation to be done
        manager.persist(userToSave);
        //this operation WRITES the object on the actual table
        transaction.commit();
        manager.close();
    }
}
