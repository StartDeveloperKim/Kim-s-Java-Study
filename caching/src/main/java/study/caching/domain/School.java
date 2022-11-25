package study.caching.domain;

import lombok.Getter;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

@Getter
/*@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)*/
@Entity
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;


    private School(String name) {
        this.name = name;
    }

    protected School() {}

    public static School from(String name) {
        return new School(name);
    }

    public void updateName(String name) {
        this.name = name;
    }
}
