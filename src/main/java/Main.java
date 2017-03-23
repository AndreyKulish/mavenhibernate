import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 * Created by Andrey on 23.03.2017.
 */
public class Main {

    private static SessionFactory sessionFactory;


    public static void main(String[] args) {

        sessionFactory = new Configuration().configure().buildSessionFactory();

        Main mainMy = new Main();

        System.out.println("Добавляем обьекты в БД");

        Integer myObjOne = mainMy.addMyOneObj("Oleg",22,"sbeb");
        Integer myObjTwo = mainMy.addMyOneObj("Vasia",33,"ebeb");
        Integer myObjTree = mainMy.addMyOneObj("Petia",44,"ebebewttb");

        System.out.println("Лист моих Обьектов");
        mainMy.listOfMyObj();
        System.out.println("Конец листа");

        System.out.println("Removing \'Some Developer\' and updating \'Proselyte Developer\''s experience:");
        mainMy.removeMyOneObj(myObjTwo);
        mainMy.updateMyOneObj(myObjTree,"lolka", 99,"gdetu");

        System.out.println("Лист после удаления и апдейта:");
        mainMy.listOfMyObj();
        sessionFactory.close();
    }

    public Integer addMyOneObj(String name,int age, String email) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        Integer developerId = null;

        transaction = session.beginTransaction();
        MyOneObj developer = new MyOneObj(name, age, email);
        developerId = (Integer) session.save(developer);
        transaction.commit();
        session.close();
        return developerId;
    }

    public void listOfMyObj() {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        List myList = session.createQuery("from MyOneObj").list();
        for (Object rrt : myList) {
            System.out.println(rrt);
            System.out.println("\n================\n");
        }
        session.close();
    }

    public void updateMyOneObj(int Id,String name, int age, String email) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        MyOneObj myOneObj = (MyOneObj) session.get(MyOneObj.class, Id);
        myOneObj.setName(name);
        myOneObj.setAge(age);
        myOneObj.setEmail(email);
        session.update(myOneObj);
        transaction.commit();
        session.close();
    }

    public void removeMyOneObj(int Id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        MyOneObj myOneObj = (MyOneObj) session.get(MyOneObj.class, Id);
        session.delete(myOneObj);
        transaction.commit();
        session.close();
    }
}
