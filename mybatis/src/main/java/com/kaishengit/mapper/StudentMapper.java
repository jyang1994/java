package com.kaishengit.mapper;

import com.kaishengit.entity.Student;

import java.util.List;

public interface StudentMapper {

    Student findById(int id);
    List<Student> findAll();

}
