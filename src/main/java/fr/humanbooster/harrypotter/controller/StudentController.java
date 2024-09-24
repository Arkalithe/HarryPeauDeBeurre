package fr.humanbooster.harrypotter.controller;

import com.fasterxml.jackson.annotation.JsonView;
import fr.humanbooster.harrypotter.dto.StudentDto;
import fr.humanbooster.harrypotter.entity.Student;
import fr.humanbooster.harrypotter.jsonviews.HouseJsonview;
import fr.humanbooster.harrypotter.jsonviews.StudentJsonview;
import fr.humanbooster.harrypotter.service.StudentService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static fr.humanbooster.harrypotter.util.UrlPath.*;

@RestController
@RequestMapping(STUDENT_URL)
@AllArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    @JsonView(StudentJsonview.showStudentSimple.class)
    public List<Student> getAllStudent() {
        return studentService.list();
    }

    @GetMapping("/{id}")
    @JsonView(StudentJsonview.showStudentDetailed.class)
    public Student getStudentById(@PathVariable Integer id) {
        return studentService.findById(id);
    }

    @PostMapping(CREATE)
    public Student createStudent(@Valid  @RequestBody StudentDto studentDto) {
        return studentService.create(studentDto);
    }

    @PutMapping(UPDATE + "/{id}")
    public Student updateStudent(@PathVariable Integer id,@Valid @RequestBody StudentDto studentDto) {
        return studentService.update(studentDto, id);
    }

    @DeleteMapping(DELETE + "/{id}")
    @JsonView(HouseJsonview.showHouseSimple.class)
    public void deleteStudent(@PathVariable Integer id) {
        studentService.delete(id);
    }
}
