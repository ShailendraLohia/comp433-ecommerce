package com.example.ecommerce.dal.products;

import com.example.ecommerce.model.product.Inventory;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class ProductDAOImpl {

    @Autowired
    private SessionFactory sessionFactory;

    public String saveProucts(List<Inventory> products) {
        Session session=sessionFactory.getCurrentSession();
        for(Inventory item:products) {
            session.save(item);
        }

        return "products added successfully";
    }

    public Inventory lookProduct(long productId) {
        Session session=sessionFactory.getCurrentSession();

        Criteria criteria=session.createCriteria(Inventory.class)
                .add(Restrictions.eq("item_id",productId));

        List<Inventory> items;
        items = (List<Inventory>)criteria.list();

        return items.get(0);
    }
}
