package com.hibernate.dao;

import com.hibernate.entity.Product;
import com.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;
import java.util.List;

public class ProductDAO {

    // Insert product
    public void insertProduct(Product product) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.save(product);
            session.getTransaction().commit();
        } finally {
            session.close();
        }
    }

    // Task 3a: Sort by price ascending
    public List<Product> sortByPriceAscending() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Query<Product> query = session.createQuery("FROM Product ORDER BY price ASC", Product.class);
            return query.getResultList();
        } finally {
            session.close();
        }
    }

    // Task 3b: Sort by price descending
    public List<Product> sortByPriceDescending() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Query<Product> query = session.createQuery("FROM Product ORDER BY price DESC", Product.class);
            return query.getResultList();
        } finally {
            session.close();
        }
    }

    // Task 4: Sort by quantity highest first
    public List<Product> sortByQuantityHighestFirst() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Query<Product> query = session.createQuery("FROM Product ORDER BY quantity DESC", Product.class);
            return query.getResultList();
        } finally {
            session.close();
        }
    }

    // Task 5a: Pagination - First 3 products
    public List<Product> getFirstThreeProducts() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Query<Product> query = session.createQuery("FROM Product ORDER BY id", Product.class);
            query.setFirstResult(0);
            query.setMaxResults(3);
            return query.getResultList();
        } finally {
            session.close();
        }
    }

    // Task 5b: Pagination - Next 3 products
    public List<Product> getNextThreeProducts() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Query<Product> query = session.createQuery("FROM Product ORDER BY id", Product.class);
            query.setFirstResult(3);
            query.setMaxResults(3);
            return query.getResultList();
        } finally {
            session.close();
        }
    }

    // Task 6a: Count total products
    public long countTotalProducts() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Query<Long> query = session.createQuery("SELECT COUNT(*) FROM Product", Long.class);
            return query.uniqueResult();
        } finally {
            session.close();
        }
    }

    // Task 6b: Count products where quantity > 0
    public long countProductsWithQuantity() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Query<Long> query = session.createQuery("SELECT COUNT(*) FROM Product WHERE quantity > 0", Long.class);
            return query.uniqueResult();
        } finally {
            session.close();
        }
    }

    // Task 6c: Count products grouped by description
    public List<Object[]> countProductsGroupedByDescription() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Query<Object[]> query = session.createQuery(
                "SELECT description, COUNT(*) FROM Product GROUP BY description", Object[].class);
            return query.getResultList();
        } finally {
            session.close();
        }
    }

    // Task 6d: Find minimum and maximum price
    public Object[] findMinMaxPrice() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Query<Object[]> query = session.createQuery(
                "SELECT MIN(price), MAX(price) FROM Product", Object[].class);
            return query.uniqueResult();
        } finally {
            session.close();
        }
    }

    // Task 7: Group by description
    public List<Object[]> groupByDescription() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Query<Object[]> query = session.createQuery(
                "SELECT description, COUNT(*) as count FROM Product GROUP BY description", Object[].class);
            return query.getResultList();
        } finally {
            session.close();
        }
    }

    // Task 8: Filter by price range
    public List<Product> filterByPriceRange(double minPrice, double maxPrice) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Query<Product> query = session.createQuery(
                "FROM Product WHERE price BETWEEN :minPrice AND :maxPrice", Product.class);
            query.setParameter("minPrice", minPrice);
            query.setParameter("maxPrice", maxPrice);
            return query.getResultList();
        } finally {
            session.close();
        }
    }

    // Task 9a: Names starting with certain letters
    public List<Product> findProductsStartingWith(String prefix) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Query<Product> query = session.createQuery(
                "FROM Product WHERE name LIKE :prefix", Product.class);
            query.setParameter("prefix", prefix + "%");
            return query.getResultList();
        } finally {
            session.close();
        }
    }

    // Task 9b: Names ending with certain letters
    public List<Product> findProductsEndingWith(String suffix) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Query<Product> query = session.createQuery(
                "FROM Product WHERE name LIKE :suffix", Product.class);
            query.setParameter("suffix", "%" + suffix);
            return query.getResultList();
        } finally {
            session.close();
        }
    }

    // Task 9c: Names containing a pattern
    public List<Product> findProductsContaining(String pattern) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Query<Product> query = session.createQuery(
                "FROM Product WHERE name LIKE :pattern", Product.class);
            query.setParameter("pattern", "%" + pattern + "%");
            return query.getResultList();
        } finally {
            session.close();
        }
    }

    // Task 9d: Names with exact character length
    public List<Product> findProductsByNameLength(int length) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Query<Product> query = session.createQuery(
                "FROM Product WHERE LENGTH(name) = :length", Product.class);
            query.setParameter("length", length);
            return query.getResultList();
        } finally {
            session.close();
        }
    }
}
