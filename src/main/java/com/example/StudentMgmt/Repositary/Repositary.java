package com.example.StudentMgmt.Repositary;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.StudentMgmt.PathModel.PathModel;

public interface Repositary extends JpaRepository <PathModel,Integer> {
  List<PathModel> findByName(String name);
}