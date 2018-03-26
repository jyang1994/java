package com.kaishengit.mapper;

import com.kaishengit.entity.Student;

import java.util.List;

public interface StudentBakMapper {

    Student findById(int id);
    Student findByIdWithTag(int id);
    List<Student> findAll();


}
