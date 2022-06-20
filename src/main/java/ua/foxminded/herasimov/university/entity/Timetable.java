package ua.foxminded.herasimov.university.entity;

import java.time.LocalTime;
import java.util.Objects;

public class Timetable {

    private Integer id;
    private Integer lessonId;
    private Integer teacherId;
    private Integer groupId;
    private Integer day;
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

        public Builder withLessonId(Integer lessonId) {
            newTimetable.lessonId = lessonId;
            return this;
        }

        public Builder withTeacherId(Integer teacherId) {
            newTimetable.teacherId = teacherId;
            return this;
        }

        public Builder withGroupId(Integer groupId) {
            newTimetable.groupId = groupId;
            return this;
        }

        public Builder withDay(Integer day) {
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

    public Integer getLessonId() {
        return lessonId;
    }

    public void setLessonId(Integer lessonId) {
        this.lessonId = lessonId;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
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
        return Objects.equals(id, timetable.id) && Objects.equals(lessonId, timetable.lessonId) &&
               Objects.equals(teacherId, timetable.teacherId) &&
               Objects.equals(groupId, timetable.groupId) && Objects.equals(day, timetable.day) &&
               Objects.equals(time, timetable.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lessonId, teacherId, groupId, day, time);
    }

    @Override
    public String toString() {
        return "Timetable{" +
               "Id=" + id +
               ", lessonId=" + lessonId +
               ", teacherId=" + teacherId +
               ", groupId=" + groupId +
               ", day=" + day +
               ", time=" + time +
               '}';
    }
}
