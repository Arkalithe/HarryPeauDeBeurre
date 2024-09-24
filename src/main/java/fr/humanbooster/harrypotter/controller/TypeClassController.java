package fr.humanbooster.harrypotter.controller;

import com.fasterxml.jackson.annotation.JsonView;
import fr.humanbooster.harrypotter.dto.TeacherDto;
import fr.humanbooster.harrypotter.dto.TypeClassDto;
import fr.humanbooster.harrypotter.entity.Teacher;
import fr.humanbooster.harrypotter.entity.TypeOfClass;
import fr.humanbooster.harrypotter.jsonviews.StudentJsonview;
import fr.humanbooster.harrypotter.jsonviews.TypeClassJsonview;
import fr.humanbooster.harrypotter.service.TypeClassService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static fr.humanbooster.harrypotter.util.UrlPath.*;

@RestController
@RequestMapping(TYPE_OF_CLASS_URL)
@AllArgsConstructor
public class TypeClassController {

    private final TypeClassService typeclassService;



    @GetMapping
    @JsonView(TypeClassJsonview.showTypeClassSimple.class)
    public List<TypeOfClass> getAllSubject() {
        return typeclassService.list();
    }

    @GetMapping("/{id}")
    @JsonView(TypeClassJsonview.showTypeClassDetailed.class)
    public TypeOfClass getSubjectById(@PathVariable Integer id) {
        return typeclassService.findById(id);
    }

    @PostMapping(CREATE)
    public TypeOfClass createSubject(@Valid  @RequestBody TypeClassDto typeclassDto) {
        return typeclassService.create(typeclassDto);
    }

    @PutMapping(UPDATE + "/{id}")
    public TypeOfClass updateSubject(@PathVariable Integer id,@Valid @RequestBody TypeClassDto typeclassDto) {

        return typeclassService.update(typeclassDto, id);
    }

    @DeleteMapping(DELETE + "/{id}")
    public void deleteSubject(@PathVariable Integer id) {
        typeclassService.delete(id);
    }


}
