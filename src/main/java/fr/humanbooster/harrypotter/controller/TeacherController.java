package fr.humanbooster.harrypotter.controller;

import fr.humanbooster.harrypotter.dto.SubjectDto;
import fr.humanbooster.harrypotter.dto.TeacherDto;
import fr.humanbooster.harrypotter.entity.Subject;
import fr.humanbooster.harrypotter.entity.Teacher;
import fr.humanbooster.harrypotter.service.TeacherService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teachers")
@AllArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;


    @GetMapping
    public List<Teacher> getAllSubject() {
        return teacherService.list();
    }

    @GetMapping("/{id}")
    public Teacher getSubjectById(@PathVariable Integer id) {
        return teacherService.findById(id);
    }

    @PostMapping
    public Teacher createSubject(@RequestBody TeacherDto teacherDto) {
        return teacherService.create(teacherDto);
    }

    @PutMapping("/{id}")
    public Teacher updateSubject(@PathVariable Integer id, @RequestBody TeacherDto teacherDto) {
        return teacherService.update(teacherDto, id);
    }

    @DeleteMapping("/{id}")
    public void deleteSubject(@PathVariable Integer id) {
        teacherService.delete(id);
    }

}
