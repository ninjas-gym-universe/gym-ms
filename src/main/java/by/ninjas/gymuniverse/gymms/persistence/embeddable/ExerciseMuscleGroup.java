package by.ninjas.gymuniverse.gymms.persistence.embeddable;

import jakarta.persistence.Embeddable;

/**
 * Embeddable representation of <b>exercise_muscle_group</b> table part: all muscle groups for exercise.
 *
 * @param muscleGroupId muscle group id
 * @param percentage    percentage
 * @author Artyom Drobysh (artyom.drobysh96@gmail.com)
 * @version 0.2.0
 * @since 0.2.0
 */
@Embeddable
public record ExerciseMuscleGroup(short muscleGroupId,
                                  Short percentage) {
}
