package by.ninjas.gymuniverse.gymms.persistence.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import static jakarta.persistence.CascadeType.MERGE;
import static jakarta.persistence.CascadeType.PERSIST;
import static jakarta.persistence.FetchType.LAZY;
import static jakarta.persistence.GenerationType.SEQUENCE;

/**
 * Entity for table <b>muscle_group</b>.
 *
 * @author Artyom Drobysh (artyom.drobysh96@gmail.com)
 * @version 0.2.0
 * @since 0.2.0
 */
@Getter
@Setter
@Entity
@ToString(exclude = "parent")
public class MuscleGroup {

    @Id
    @SequenceGenerator(name = "seq_muscle_group", sequenceName = "seq_muscle_group", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "seq_muscle_group")
    private Short id;
    @Column(nullable = false, length = 50)
    private String name;
    @ManyToOne(fetch = LAZY, cascade = {PERSIST, MERGE})
    @JoinColumn(name = "parent_id", referencedColumnName = "id")
    private MuscleGroup parent;
}
