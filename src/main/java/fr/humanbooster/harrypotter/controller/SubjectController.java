package fr.humanbooster.harrypotter.controller;

import com.fasterxml.jackson.annotation.JsonView;
import fr.humanbooster.harrypotter.dto.HouseDto;
import fr.humanbooster.harrypotter.dto.SubjectDto;
import fr.humanbooster.harrypotter.entity.House;
import fr.humanbooster.harrypotter.entity.Subject;
import fr.humanbooster.harrypotter.jsonviews.HouseJsonview;
import fr.humanbooster.harrypotter.service.SubjectService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static fr.humanbooster.harrypotter.util.UrlPath.*;

@RestController
@RequestMapping(SUBJECT_URL)
@AllArgsConstructor
public class SubjectController {
    private final SubjectService subjectService;

    @GetMapping
    public List<Subject> getAllSubject() {
        return subjectService.list();
    }

    @GetMapping("/{id}")
    public Subject getSubjectById(@PathVariable Integer id) {
        return subjectService.findById(id);
    }

    @PostMapping(CREATE)
    public Subject createSubject(@Valid  @RequestBody SubjectDto subjectDto) {
        return subjectService.create(subjectDto);
    }

    @PutMapping(UPDATE + "/{id}")
    public Subject updateSubject(@PathVariable Integer id,@Valid @RequestBody SubjectDto subjectDto) {
        return subjectService.update(subjectDto, id);
    }

    @DeleteMapping(DELETE + "/{id}")
    public void deleteSubject(@PathVariable Integer id) {
        subjectService.delete(id);
    }

}
