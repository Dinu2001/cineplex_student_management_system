package cineplex_accademy.service;

import cineplex_accademy.dto.StudentDto;
import cineplex_accademy.entity.Student;
import cineplex_accademy.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepo studentRepo;

    public ResponseEntity<String> saveStudent(StudentDto studentDto) {
        Student student = new Student(
                studentDto.getId(),studentDto.getFname(),studentDto.getLname(),studentDto.getAddress(),
                studentDto.getNumber(),studentDto.getAge(),studentDto.getGrade(),studentDto.getEmail(),
                studentDto.getDepartment(),studentDto.getPosition()
        );
        studentRepo.save(student);
        return new ResponseEntity<>("Student save successfully..", HttpStatus.CREATED);
    }

    public ResponseEntity<List<StudentDto>> getAllStudent() {
        List<StudentDto> studentDtoList = new ArrayList<>();
        List<Student> students = studentRepo.findAll();
        for(Student student:students){
            StudentDto dto = new StudentDto(
                    student.getId(),student.getFname(),student.getLname(),student.getAddress(),
                    student.getNumber(),student.getAge(),student.getGrade(),student.getEmail(),student.getDepartment(),student.getPosition()
            );
            studentDtoList.add(dto);
        }
        if(!studentDtoList.isEmpty()){
            return new ResponseEntity<>(studentDtoList,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
        }
    }

    public ResponseEntity<StudentDto> getDetailsById(int id) {
       Optional<Student> student= studentRepo.findById(id);
       if (student.isPresent()){
           StudentDto studentDto = new StudentDto(
                   student.get().getId(),student.get().getFname(),student.get().getLname(),student.get().getAddress(),
                   student.get().getNumber(),student.get().getAge(),student.get().getGrade(),student.get().getEmail(),student.get().getDepartment(),student.get().getPosition()
           );
           return new ResponseEntity<>(studentDto,HttpStatus.OK);
       }

        return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
    }

    public ResponseEntity<String> updateStudent(StudentDto studentDto) {
        Optional<Student> student= studentRepo.findById(studentDto.getId());
        if(student.isPresent()){
            Student updateStudent = new Student(
                    studentDto.getId(),studentDto.getFname(),studentDto.getLname(),studentDto.getAddress(),
                    studentDto.getNumber(),studentDto.getAge(), studentDto.getGrade(), studentDto.getEmail(),
                    studentDto.getDepartment(),studentDto.getPosition()
            );
            studentRepo.save(updateStudent);
        }

        return new ResponseEntity<>("Update successful..",HttpStatus.CREATED);
    }

    public ResponseEntity<String> deleteById(int id) {
        Optional<Student> student= studentRepo.findById(id);
        if (student.isPresent()){
            studentRepo.deleteById(id);
            return new ResponseEntity<>("delete successful",HttpStatus.OK);
        }else{
            return new ResponseEntity<>("No user found",HttpStatus.NO_CONTENT);
        }
    }
}
