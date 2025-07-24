package in.sp.main;


import in.sp.entities.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        
        User u3 = new User();
        u3.setEmail("aniket@gmail.com");
        u3.setName("Aniket");
        u3.setGender("female");

        Configuration config = new Configuration();                          //Configuration is the class that loads the hibernate configuration.
        config.configure("in.sp.config/hibernate.cfg.xml");         //it tells the hibernate to reads the xml file for DB connection,mapping,etc.


        SessionFactory sessionFactory = config.buildSessionFactory();       //it builds sessionFactory and reads all the...
                                                                            // metadata from hibernate.cfg.xml and prepare the app to talk with DB
        Session session = sessionFactory.openSession();                     //creating session
        Transaction transaction = session.beginTransaction();               //wrap the DB operation and help in commit() and rollback()


//-----------------------INSERTION------------------------------------------------------------------------------
        try {
            session.save(u3);
            transaction.commit();
            System.out.println("user added");
        } catch (Exception e) {
            transaction.rollback();
            System.out.println("user not added");
            e.printStackTrace();
        }


//---------------------SELECTION-----------------------------------------------------------

//        try {
//            User user = session.get(User.class, 1);
//            if (user != null) {
//                System.out.println(user.getId());
//                System.out.println(user.getName());
//                System.out.println(user.getEmail());
//                System.out.println(user.getGender());
//            } else {
//                System.out.println("user is not found");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//----------------------UPDATE---------------------------------------------------------------
//        try {
//            User user = session.get(User.class, 1);
//            user.setName("Akash Seth");
//
//            session.saveOrUpdate(user);
//            transaction.commit();
//            System.out.println("updated successfuly");
//        } catch (Exception e) {
//            transaction.rollback();
//            System.out.println("not updated");
//            e.printStackTrace();
//        }



//---------------------DELETE--------------------------------------------------------------------
//        try {
//            User user =new User();
//            user.setId(2);
//
//            session.delete(user);
//            transaction.commit();
//            System.out.println("deleted successfuly");
//        } catch (Exception e) {
//            transaction.rollback();
//            System.out.println("not deleted");
//            e.printStackTrace();
//        }


    }
}