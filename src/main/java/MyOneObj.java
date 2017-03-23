import javax.persistence.*;

/**
 * Created by Andrey on 23.03.2017.
 */

@Entity
@Table(name = "user")
public class MyOneObj {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column (name = "name")
    private String name;
    @Column (name = "age")
    private int age;
    @Column (name = "email")
    private String email;

    public MyOneObj(){

    }

    public MyOneObj(String name, int age,String email){
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User:\n" +
                "id: " + id +
                "\nName: " + name + "\n" +
                "Age: " + age + "\n" +
                "Email: " + email + "\n";
    }
}
