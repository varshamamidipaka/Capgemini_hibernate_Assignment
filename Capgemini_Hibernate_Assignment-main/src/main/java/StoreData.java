import Entity.Catalog;
import Entity.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StoreData {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

        Session session = factory.getCurrentSession();

        Transaction t = session.beginTransaction();

        Category category = new Category();
        category.setCategoryName("Gift Card");

        Catalog catalog = new Catalog();
        catalog.setCatalog_Name("Amazon Gift Card");
        catalog.setStatus("Active");

        Catalog catalog1 = new Catalog();
        catalog1.setCatalog_Name("Flipkart Gift Card");
        catalog1.setStatus("Inactive");

        category.getCatalogList().add(catalog);
        category.getCatalogList().add(catalog1);

        catalog.setCategory(category);
        catalog1.setCategory(category);

//        session.save(category);
//        session.save(catalog);
//        session.save(catalog1);

        session.persist(category);

        t.commit();
        System.out.println("Successfully Done");
        session.close();
        factory.close();
    }
}
