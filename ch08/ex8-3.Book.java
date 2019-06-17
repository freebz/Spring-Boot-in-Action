// 코드 8-3 Book.java

...
import javax.persistence.ManyToOne;

@Entity
public class Book {

    ...

    @ManyToOne
    private Reader reader;

    ...

}
