package fr.humanbooster.harrypotter.controller;

import com.fasterxml.jackson.annotation.JsonView;
import fr.humanbooster.harrypotter.dto.SubjectDto;
import fr.humanbooster.harrypotter.dto.TeacherDto;
import fr.humanbooster.harrypotter.entity.Subject;
import fr.humanbooster.harrypotter.entity.Teacher;
import fr.humanbooster.harrypotter.jsonviews.TeacherJsonview;
import fr.humanbooster.harrypotter.service.TeacherService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static fr.humanbooster.harrypotter.util.UrlPath.*;

@RestController
@RequestMapping(TEACHER_URL)
@AllArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;


    @GetMapping
    @JsonView(TeacherJsonview.showTeacherSimple.class)
    public List<Teacher> getAllSubject() {
        return teacherService.list();
    }

    @GetMapping("/{id}")
    @JsonView(TeacherJsonview.showTeacherDetailed.class)
    public Teacher getSubjectById(@PathVariable Integer id) {
        return teacherService.findById(id);
    }

    @PostMapping(CREATE)
    public Teacher createSubject(@Valid  @RequestBody TeacherDto teacherDto) {
        return teacherService.create(teacherDto);
    }

    @PutMapping(UPDATE + "/{id}")
    public Teacher updateSubject(@PathVariable Integer id,@Valid  @RequestBody TeacherDto teacherDto) {
        return teacherService.update(teacherDto, id);
    }

    @DeleteMapping(DELETE + "/{id}")
    public void deleteSubject(@PathVariable Integer id) {
        teacherService.delete(id);
    }

}
