package com.jovioakz;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.jovioakz.model.BookingData;

public class DataController {
    public static List<BookingData> getBookings() {
        Session session = HibernateUtil
                .getSessionFactory()
                .getCurrentSession();

        Transaction transaction = session.beginTransaction();


        Query query = session.createQuery("from BookingData");

        List<BookingData> values = query.list();

        transaction.commit();

        return values;
    }


    public static void removeData(BookingData data) {
        Session session = HibernateUtil
                .getSessionFactory()
                .getCurrentSession();

        Transaction transaction = session.beginTransaction();

        session.delete(data);

        transaction.commit();
    }


    public static void insertData(BookingData data) {
        Session session = HibernateUtil
                .getSessionFactory()
                .getCurrentSession();

        Transaction transaction = session.beginTransaction();

        session.save(data);
        transaction.commit();
    }
}
