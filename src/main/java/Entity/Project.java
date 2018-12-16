package Hibernate.Entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Project")
@Getter
@Setter
@ToString(exclude = {"developers"})
@EqualsAndHashCode(exclude = {"developers", "company", "customer"})
public class Project {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "Name")
    private String projectName;

    @Column(name = "Description")
    private String description;

    @ManyToMany
    @JoinTable(name = "developer_projects", joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "developer_id"))
    @Fetch(FetchMode.SELECT)
    @LazyCollection(LazyCollectionOption.FALSE)
    Set<Developer> developers;

    @ManyToOne
    @JoinColumn(name = "company_id")
    @Fetch(FetchMode.SELECT)
    private Company company;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    @Fetch(FetchMode.SELECT)
    private Customer customer;
}
