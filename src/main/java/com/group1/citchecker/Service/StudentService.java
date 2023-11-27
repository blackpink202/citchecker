package com.group1.citchecker.Service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group1.citchecker.Entity.StudentEntity;
import com.group1.citchecker.Repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    StudentRepository srepo;

    // create or insert student record in tblstudent
    public StudentEntity insertStudent(StudentEntity student) {
        return srepo.save(student);
    }

    // GET ALL STUDENTS
    public List<StudentEntity> getAllStudents() {
        return srepo.findAll();
    }

    // Update a student record
    @SuppressWarnings("finally")
    public StudentEntity updateStudent(int sid, StudentEntity newStudentDetails) {
        StudentEntity student = new StudentEntity();
        try {
            // search the id number of the student that will be updated
            student = srepo.findById(sid).get();

            // update the record
            student.setFname(newStudentDetails.getFname());
            student.setLname(newStudentDetails.getLname());
            student.setEmail(newStudentDetails.getEmail());
            student.setPassword(newStudentDetails.getPassword());
            student.setProgram(newStudentDetails.getProgram());
        } catch (NoSuchElementException ex) {
            throw new NoSuchElementException("Student " + sid + " does not exist!");
        } finally {
            return srepo.save(student);
        }
    }

    // Delete a student
    public String deleteStudent(int sid) {
        String msg = "";

        if (srepo.findById(sid).isPresent()) {
            srepo.deleteById(sid);
            msg = "Student " + sid + " is successfully deleted!";
        } else
            msg = "Student " + sid + " does not exist";
        return msg;
    }

	public StudentEntity getStudentById(int sid) {
		// TODO Auto-generated method stub
		return null;
	}
}