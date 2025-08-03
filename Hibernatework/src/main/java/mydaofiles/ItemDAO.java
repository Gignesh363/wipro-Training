package mydaofiles;

import mypojos.Item;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ItemDAO {
    private SessionFactory factory;

    public ItemDAO() {
        factory = new Configuration().configure("wiprohibernate.cfg.xml").buildSessionFactory();
    }

    public void addItem(String name, double price) {
        Item item = new Item(name, price);
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(item);
        tx.commit();
        session.close();
        System.out.println("Item added.");
    }

    public List<Item> getAllItems() {
        Session session = factory.openSession();
        List<Item> items = session.createQuery("from Item", Item.class).list();
        session.close();
        return items;
    }

    public Item getItemById(int id) {
        Session session = factory.openSession();
        Item item = session.get(Item.class, id);
        session.close();
        return item;
    }

    public void updateItem(int id, String newName, double newPrice) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        Item item = session.get(Item.class, id);
        if (item != null) {
            item.setName(newName);
            item.setPrice(newPrice);
            session.update(item);
            tx.commit();
            System.out.println("Item updated.");
        } else {
            System.out.println("Item not found.");
        }
        session.close();
    }

    public void deleteItem(int id) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        Item item = session.get(Item.class, id);
        if (item != null) {
            session.delete(item);
            tx.commit();
            System.out.println("Item deleted.");
        } else {
            System.out.println("Item not found.");
        }
        session.close();
    }

    public void close() {
        factory.close();
    }
}
