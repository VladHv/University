package ua.foxminded.herasimov.university.entity;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Objects;

@Entity
@Table(name = "timetables")
public class Timetable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL)
    private Lesson lesson;

    @OneToOne(cascade = CascadeType.ALL)
    private Teacher teacher;

    @OneToOne(cascade = CascadeType.ALL)
    private Group group;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "day")
    private DayOfWeek day;

    @Column(name = "time")
    private LocalTime time;

    public static class Builder {
        private Timetable newTimetable;

        public Builder() {
            newTimetable = new Timetable();
        }

        public Builder withId(Integer id) {
            newTimetable.id = id;
            return this;
        }

        public Builder withTime(LocalTime time) {
            newTimetable.time = time;
            return this;
        }

        public Builder withLesson(Lesson lesson) {
            newTimetable.lesson = lesson;
            return this;
        }

        public Builder withTeacher(Teacher teacher) {
            newTimetable.teacher = teacher;
            return this;
        }

        public Builder withGroup(Group group) {
            newTimetable.group = group;
            return this;
        }

        public Builder withDay(DayOfWeek day) {
            newTimetable.day = day;
            return this;
        }

        public Timetable build() {
            return newTimetable;
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public DayOfWeek getDay() {
        return day;
    }

    public void setDay(DayOfWeek day) {
        this.day = day;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Timetable timetable = (Timetable) o;
        return Objects.equals(id, timetable.id) && Objects.equals(lesson, timetable.lesson) &&
               Objects.equals(teacher, timetable.teacher) && Objects.equals(group, timetable.group) &&
               day == timetable.day && Objects.equals(time, timetable.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lesson, teacher, group, day, time);
    }

    @Override
    public String toString() {
        return "Timetable{" +
               "id=" + id +
               ", lesson=" + lesson +
               ", teacher=" + teacher +
               ", group=" + group +
               ", day=" + day +
               ", time=" + time +
               '}';
    }
}
