package com.peddi.webserv;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.HashSet;
import java.util.Set;


public class App{
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Categories categories1 = new Categories();
        categories1.setCatId(121);
        categories1.setCategoryName("ABCD");

        Categories categories2 = new Categories();
        categories2.setCatId(131);
        categories2.setCategoryName("EFGH");

        Items items1 = new Items();
        items1.setItemId(1);
        items1.setItemName("Item1");

        Items items2 = new Items();
        items2.setItemId(2);
        items2.setItemName("Item2");

        Set setItems = new HashSet();
        setItems.add(items1);
        setItems.add(items2);

        categories1.setItems(setItems);

        categories2.setItems(setItems);

        session.save(categories1);
        session.save(categories2);

        transaction.commit();

        session.clear();
        session.close();
        System.out.println("Many to many with annotations is done..!!!!");
        sessionFactory.close();
    }
}
