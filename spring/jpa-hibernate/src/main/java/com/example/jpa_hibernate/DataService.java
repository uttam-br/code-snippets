package com.example.jpa_hibernate;

import com.example.jpa_hibernate.models.Course;
import com.example.jpa_hibernate.models.Student;
import com.example.jpa_hibernate.models.StudentCourse;
import com.example.jpa_hibernate.repository.CourseRepository;
import com.example.jpa_hibernate.repository.StudentCourseRepository;
import com.example.jpa_hibernate.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DataService {

    StudentRepository studentRepository;

    CourseRepository courseRepository;

    StudentCourseRepository studentCourseRepository;

    public String test() throws Exception {
//        Student student = new Student();
//        student.setName("Uttam Rabari");
//        student.setAge(27);
//        System.out.println("ID before save : " + student.getId());
//        studentRepository.save(student);
//        System.out.println("ID after save : " + student.getId());


//        Optional<Student> studentOptional = studentRepository.findById(1L);
//
//        if (studentOptional.isEmpty()) {
//            throw new Exception("Student does not exists");
//        }
//
//        Student student = studentOptional.get();
//        student.setId(2L);
//        studentRepository.save(student);

        Student uttam = new Student();
        uttam.setName("Uttam");
        studentRepository.save(uttam);

        Student vidhi = new Student();
        vidhi.setName("Vidhi");
        studentRepository.save(vidhi);

        Student aditya = new Student();
        aditya.setName("Aditya");
        studentRepository.save(aditya);

        Student dhritesh = new Student();
        dhritesh.setName("Dhritesh");
        studentRepository.save(dhritesh);

        Student dhruv = new Student();
        dhruv.setName("Dhruv");
        studentRepository.save(dhruv);


        Course science = new Course();
        science.setCourseName("Science");
        science.setCredits(2);
        courseRepository.save(science);

        Course maths = new Course();
        maths.setCourseName("Maths");
        maths.setCredits(3);
        courseRepository.save(maths);

        StudentCourse vidhiScience = new StudentCourse();
        vidhiScience.setCourse(science);
        vidhiScience.setStudent(vidhi);
        vidhiScience.setCourseStartingDate(LocalDateTime.now());
        studentCourseRepository.save(vidhiScience);

        StudentCourse uttamMaths = new StudentCourse();
        uttamMaths.setStudent(uttam);
        uttamMaths.setCourse(maths);
        uttamMaths.setCourseStartingDate(LocalDateTime.now());
        studentCourseRepository.save(uttamMaths);

        StudentCourse uttamScience = new StudentCourse();
        uttamScience.setStudent(uttam);
        uttamScience.setCourse(science);
        uttamScience.setCourseStartingDate(LocalDateTime.now());
        studentCourseRepository.save(uttamScience);

        // repeating, just to check if it works or not.
        // we had to add unique constraint to make sure that this fails.
        StudentCourse uttamScience2 = new StudentCourse();
        uttamScience2.setStudent(uttam);
        uttamScience2.setCourse(science);
        uttamScience2.setCourseStartingDate(LocalDateTime.now());
        studentCourseRepository.save(uttamScience2);

        System.out.println("Hello from Data Service");
        return "Test";
    }

}
