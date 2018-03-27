package db;

import models.*;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

import static org.eclipse.jetty.util.LazyList.getList;

public class DBHelper {


    private static Transaction transaction;
    private static Session session;

    public static void save(Object object) {
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.saveOrUpdate(object);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static void delete(Object object) {
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.delete(object);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static <T> void deleteAll(Class classType){
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            Criteria cr = session.createCriteria(classType);
            List<T> results = cr.list();
            for (T result : results){
                session.delete(result);
            }
        } catch (HibernateException e){
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static <T> List<T> getList(Criteria criteria) {
        List<T> results = null;
        try {
            transaction = session.beginTransaction();
            results = criteria.list();
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }

    public static <T> T getUnique(Criteria criteria) {
        T result = null;
        try {
            transaction = session.beginTransaction();
            result = (T) criteria.uniqueResult();
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return result;
    }

    public static <T> List<T> getAll(Class classType) {
        session = HibernateUtil.getSessionFactory().openSession();
        List<T> results = null;
        Criteria cr = session.createCriteria(classType);
        cr.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        results = getList(cr);
        return results;
    }

    public static <T> T find(Class classType, int id) {
        session = HibernateUtil.getSessionFactory().openSession();
        T result = null;
        Criteria cr = session.createCriteria(classType);
        cr.add(Restrictions.eq("id", id));
        result = getUnique(cr);
        return result;
    }

    public static List<Product> findProductsBySubCategory(SubCategory subCategory) {
        session = HibernateUtil.getSessionFactory().openSession();
        List<Product> result = null;
        Criteria cr = session.createCriteria(Product.class);
        cr.add(Restrictions.eq("subCategory", subCategory));
        cr.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        result = getList(cr);
        return result;
    }



    public static List<SubCategory> findSubCatsByCategory(Category category) {
        session = HibernateUtil.getSessionFactory().openSession();
        List<SubCategory> result = null;
        Criteria cr = session.createCriteria(SubCategory.class);
        cr.add(Restrictions.eq("category", category));
        cr.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        result = getList(cr);
        return result;
    }

    public static void createUser (String name, String username) {
        Basket basket = new Basket();
        User user = new User(name, username, basket);
        DBHelper.save(user);
        basket.setUser(user);
        DBHelper.save(basket);
    }


    public static void createOrder (int userId, Product product, int quantity) {
        User currentUser = DBHelper.find(User.class, userId);
        Order order = new Order(product, quantity);
        order.setBasket(currentUser.getBasket());
        DBHelper.save(order);
        currentUser.getBasket().addOrder(order);
        currentUser.getBasket().adjustTotalItems();
        currentUser.getBasket().adjustTotalCost();
        DBHelper.save(currentUser);
    }

}
