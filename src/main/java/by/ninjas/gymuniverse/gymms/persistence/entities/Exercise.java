package by.ninjas.gymuniverse.gymms.persistence.entities;

import by.ninjas.gymuniverse.gymms.persistence.embeddable.ExerciseMuscleGroup;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

import static jakarta.persistence.GenerationType.SEQUENCE;

/**
 * Entity for table <b>exercise</b>.
 *
 * @author Artyom Drobysh (artyom.drobysh96@gmail.com)
 * @version 0.2.0
 * @since 0.2.0
 */
@Getter
@Setter
@Entity
public class Exercise {

    @Id
    @SequenceGenerator(name = "seq_exercise", sequenceName = "seq_exercise", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "seq_exercise")
    private Short id;
    @Column(nullable = false, length = 50, unique = true)
    private String name;
    @ElementCollection
    @CollectionTable(name = "exercise_muscle_group",
        joinColumns = @JoinColumn(name = "exercise_id", referencedColumnName = "id"))
    private Set<ExerciseMuscleGroup> muscleGroups;
}
