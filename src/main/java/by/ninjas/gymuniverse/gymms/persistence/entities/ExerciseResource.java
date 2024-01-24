package by.ninjas.gymuniverse.gymms.persistence.entities;

import by.ninjas.gymuniverse.gymms.persistence.enums.FileExtension;
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

import static jakarta.persistence.FetchType.LAZY;
import static jakarta.persistence.GenerationType.SEQUENCE;

/**
 * Entity for table <b>exercise_resource</b>.
 *
 * @author dziomin
 * @version 0.2.0
 * @since 0.2.0
 */
@Getter
@Setter
@ToString(exclude = "exercise")
@Entity
public class ExerciseResource {

    @Id
    @SequenceGenerator(name = "seq_muscle_group", sequenceName = "seq_muscle_group", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "seq_muscle_group")
    private Short id;
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "exercise_id", referencedColumnName = "id")
    private Exercise exercise;
    @Column(nullable = false)
    private byte[] content;
    @Column(nullable = false, length = 50)
    private String fileName;
    @Column(nullable = false)
    private FileExtension fileExtension;
}
