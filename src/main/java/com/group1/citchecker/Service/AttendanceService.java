package com.group1.citchecker.Service;


import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.group1.citchecker.Entity.AttendanceEntity;
import com.group1.citchecker.Repository.AttendanceRepository;

@Service
public class AttendanceService {
	
	    @Autowired
	    private AttendanceRepository arepo;
	    
	    @Autowired
	    public AttendanceService(AttendanceRepository arepo) {
	        this.arepo = arepo;
	       
	    }
	
	  public AttendanceEntity insertAttendance(AttendanceEntity attendanceEntity) {
	        return arepo.save(attendanceEntity);
	    }

	    // Get all classes
	    public List<AttendanceEntity> getAllAttendance() {
	        return arepo.findAll();
	    }
	    

	    // Delete a class record
	    public String deleteAttendance(int id) {
	        if (arepo.existsById(id)) {
	            arepo.deleteById(id);
	            return "Attendance " + id + " is successfully deleted!";
	        } else {
	            return "Attendance " + id + " does not exist";
	        }
	    }
	    
	   

	    public AttendanceEntity getAttendanceById(int id) {
	        return arepo.findById(id).orElse(null);
	    }

	    //Mark the Attendance
	    public void markAttendance(AttendanceEntity attendance) {
	    	 try {
	    	        arepo.save(attendance);
	    	        System.out.println("Attendance marked successfully!");
	    	    } catch (NoSuchElementException e) {
	    	        System.out.println("Error marking attendance: Foreign key constraint violation. Check if the associated class or student exists.");
	    	        throw e; 
	    	    } catch (Exception e) {
	    	        System.out.println("Error marking attendance");
	    	        throw e;
	    	    }
	    }
	    //Update attendance records
		public AttendanceEntity updateAttendance(int id, AttendanceEntity newAttendanceDetails) {
			 AttendanceEntity attendanceEntity = arepo.findById(id)
		                .orElseThrow(() -> new NoSuchElementException("Attendance with ID " + id + " does not exist"));

		        // Update the record
			 attendanceEntity.setDate(newAttendanceDetails.getDate());
			 attendanceEntity.setPresent(newAttendanceDetails.isPresent());
		        
		        // Update other fields as needed

		        return arepo.save(attendanceEntity);
		}
		
		//Retrieve a list of attendance record based on student ID
		public List<AttendanceEntity> getAttendanceByStudentId(int sid) {
		    return arepo.findByStudents_Sid(sid);
		}
	    
}