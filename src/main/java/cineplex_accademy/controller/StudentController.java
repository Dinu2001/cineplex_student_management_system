package cineplex_accademy.controller;

import cineplex_accademy.dto.StudentDto;
import cineplex_accademy.dto.UserDto;
import cineplex_accademy.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
@CrossOrigin
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/save")
    public ResponseEntity<String> saveStudent(@RequestBody StudentDto studentDto){
        return studentService.saveStudent(studentDto);
    }

    @GetMapping("/all")
    public ResponseEntity<List<StudentDto>> getAllStudent(){
        return studentService.getAllStudent();
    }

    @GetMapping("/get-by-id/{id}")
    public ResponseEntity<StudentDto> getById(@PathVariable int id){
        return studentService.getDetailsById(id);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateStudent(@RequestBody  StudentDto studentDto){
        return studentService.updateStudent(studentDto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable int id){
        return studentService.deleteById(id);
    }


}
