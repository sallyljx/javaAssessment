package com.generation.model;

import java.util.*;


public class Student
    extends Person
    implements Evaluation
{
    private List<Course> enrolledCourses;
    private final Map<Course, Double> courseGrade = new HashMap<>();

    float PASS_MIN_GRADE = 3.0f;

    public Student( String id, String name, String email, Date birthDate )
    {
        super( id, name, email, birthDate );
        this.enrolledCourses = new ArrayList<>();

    }

    public void enrollToCourse( Course course )
    {
        //TODO
        this.enrolledCourses.add(course);
    }

    @Override
    public List<Course> findPassedCourses()
    {
        //TODO
        List<Course> passedCourses = new ArrayList<>();
        for (Course course : this.courseGrade.keySet()) {
            if (courseGrade.get(course) >= PASS_MIN_GRADE) {
                passedCourses.add(course);
            }
        }
        return passedCourses;
    }

    public Course findCourseById(String courseId)
    {
        //TODO
        for (Course course : this.enrolledCourses) {
            if (course.getCode().equals(courseId)) {
                return course;
            }
        }
        return null;
    }

    public void setGrade (Course course, double grade) {
        this.courseGrade.put(course, grade);
    }

    public double getGrade (Course course) {
        if (this.courseGrade.get(course) == null) {
            return 0.0;
        }
        return this.courseGrade.get(course);
    }

    @Override
    public List<Course> getEnrolledCourses()
    {
        //TODO
        return this.enrolledCourses;
    }

    @Override
    public String toString()
    {
        return "Student {" + super.toString() + "}";
    }

}
