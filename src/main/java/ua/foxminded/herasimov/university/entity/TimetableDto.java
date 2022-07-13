package ua.foxminded.herasimov.university.entity;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Objects;

public class TimetableDto {

    private Integer id;
    private Lesson lesson;
    private Teacher teacher;
    private Group group;
    private DayOfWeek day;
    private LocalTime time;

    public static class Builder {
        private TimetableDto newDto;

        public Builder() {
            newDto = new TimetableDto();
        }

        public Builder withId(Integer id) {
            newDto.id = id;
            return this;
        }

        public Builder withTime(LocalTime time) {
            newDto.time = time;
            return this;
        }

        public Builder withLesson(Lesson lesson) {
            newDto.lesson = lesson;
            return this;
        }

        public Builder withTeacher(Teacher teacher) {
            newDto.teacher = teacher;
            return this;
        }

        public Builder withGroup(Group group) {
            newDto.group = group;
            return this;
        }

        public Builder withDay(DayOfWeek day) {
            newDto.day = day;
            return this;
        }

        public TimetableDto build() {
            return newDto;
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
        TimetableDto that = (TimetableDto) o;
        return Objects.equals(id, that.id) && Objects.equals(lesson, that.lesson) &&
               Objects.equals(teacher, that.teacher) && Objects.equals(group, that.group) &&
               day == that.day && Objects.equals(time, that.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lesson, teacher, group, day, time);
    }

    @Override
    public String toString() {
        return "TimetableDto{" +
               "id=" + id +
               ", lesson=" + lesson +
               ", teacher=" + teacher +
               ", group=" + group +
               ", day=" + day +
               ", time=" + time +
               '}';
    }
}
