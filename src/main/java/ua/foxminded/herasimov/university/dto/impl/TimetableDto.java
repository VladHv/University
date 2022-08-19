package ua.foxminded.herasimov.university.dto.impl;

import ua.foxminded.herasimov.university.dto.Dto;

import java.time.LocalTime;

public class TimetableDto implements Dto {

    private Integer id;
    private Integer lessonId;
    private Integer teacherId;
    private Integer groupId;
    private Integer day;
    private LocalTime time;

    public TimetableDto() {
    }

    public TimetableDto(Integer id, Integer lessonId, Integer teacherId, Integer groupId, Integer day,
                        LocalTime time) {
        this.id = id;
        this.lessonId = lessonId;
        this.teacherId = teacherId;
        this.groupId = groupId;
        this.day = day;
        this.time = time;
    }

    public static class Builder {
        private TimetableDto newDto;

        public Builder() {
            newDto = new TimetableDto();
        }

        public Builder withId(Integer id) {
            newDto.id = id;
            return this;
        }

        public Builder withLessonId(Integer lessonId) {
            newDto.lessonId = lessonId;
            return this;
        }

        public Builder withTeacherId(Integer teacherId) {
            newDto.teacherId = teacherId;
            return this;
        }

        public Builder withGroupId(Integer groupId) {
            newDto.groupId = groupId;
            return this;
        }

        public Builder withDay(Integer day) {
            newDto.day = day;
            return this;
        }

        public Builder withTime(LocalTime time) {
            newDto.time = time;
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
    public String toString() {
        return "TimetableDto{" +
               "id=" + id +
               ", lessonId=" + lessonId +
               ", teacherId=" + teacherId +
               ", groupId=" + groupId +
               ", day=" + day +
               ", time=" + time +
               '}';
    }
}
