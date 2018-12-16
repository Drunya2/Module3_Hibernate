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
@Table(name = "Skill")
@Getter
@Setter
@ToString(exclude = "developers")
@EqualsAndHashCode(exclude = "developers")
public class Skill {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "Skill")
    private String skill;

    @Column(name = "Level")
    @Enumerated(EnumType.STRING)
    private SkillLevel skillLevel;

    @ManyToMany
    @JoinTable(name = "developer_skills", joinColumns = @JoinColumn(name = "skill_id"),
            inverseJoinColumns = @JoinColumn(name = "developer_id"))
    @Fetch(FetchMode.SELECT)
    @LazyCollection(LazyCollectionOption.FALSE)
    Set<Developer> developers;
}
