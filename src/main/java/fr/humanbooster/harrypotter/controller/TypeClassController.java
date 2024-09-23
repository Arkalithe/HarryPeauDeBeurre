package fr.humanbooster.harrypotter.controller;

import fr.humanbooster.harrypotter.dto.TeacherDto;
import fr.humanbooster.harrypotter.dto.TypeClassDto;
import fr.humanbooster.harrypotter.entity.Teacher;
import fr.humanbooster.harrypotter.entity.TypeOfClass;
import fr.humanbooster.harrypotter.service.TypeClassService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/typeclasss")
@AllArgsConstructor
public class TypeClassController {

    private final TypeClassService typeclassService;



    @GetMapping
    public List<TypeOfClass> getAllSubject() {
        return typeclassService.list();
    }

    @GetMapping("/{id}")
    public TypeOfClass getSubjectById(@PathVariable Integer id) {
        return typeclassService.findById(id);
    }

    @PostMapping
    public TypeOfClass createSubject(@RequestBody TypeClassDto typeclassDto) {
        return typeclassService.create(typeclassDto);
    }

    @PutMapping("/{id}")
    public TypeOfClass updateSubject(@PathVariable Integer id, @RequestBody TypeClassDto typeclassDto) {

        return typeclassService.update(typeclassDto, id);
    }

    @DeleteMapping("/{id}")
    public void deleteSubject(@PathVariable Integer id) {
        typeclassService.delete(id);
    }


}
