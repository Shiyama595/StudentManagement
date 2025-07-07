package com.example.StudentMgmt;

import com.example.StudentMgmt.PathModel.PathModel;
import com.example.StudentMgmt.Repositary.Repositary;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

@SpringBootTest
public class StudentTest {

    @Autowired
    private Repositary repo;

    @Test
    public void Test1() {
        
        PathModel newStudent = new PathModel("Shiyama", "A+");
        repo.save(newStudent);

        
        List<PathModel> students = repo.findByName("Shiyama");

        
        assertFalse(students.isEmpty(), "Student list should not be empty");

        PathModel found = students.get(0); 
        System.out.println(found);

        assertNotNull(found);
        assertEquals("Shiyama", found.getName());
        assertEquals("A+", found.getGrade());
    }

    @Test
    public void Test2() {
        PathModel student = new PathModel("Priya", "B");
        PathModel saved = repo.save(student);

        assertTrue(saved.getId() > 0);
    }
}
