package fr.humanbooster.harrypotter.service;

import fr.humanbooster.harrypotter.repository.TeacherRepository;
import fr.humanbooster.harrypotter.entity.Teacher;
import fr.humanbooster.harrypotter.dto.TeacherDto;
import fr.humanbooster.harrypotter.service.interfaces.ServiceListInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TeacherService implements ServiceListInterface<Teacher, Integer, TeacherDto, TeacherDto>{
   
    private final TeacherRepository teacherRepository;
    
    @Override
    public Teacher create(TeacherDto teacherDto) {
    return teacherRepository.saveAndFlush(objectFromDto(new Teacher(),teacherDto));
    }
    
    @Override
    public Teacher update(TeacherDto teacherDto, Integer id) {
    Teacher teacher = objectFromDto(findById(id), teacherDto);
    teacher.setId(id);
    teacherRepository.flush();
    return teacher;
    }

    @Override
    public void delete(Integer id) {
    teacherRepository.deleteById(id);
    }
    
    @Override
    public Teacher findById(Integer id) {
    return teacherRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
    
    @Override
    public List<Teacher> list() {
    return teacherRepository.findAll();
    }
    
    private Teacher objectFromDto(Teacher teacher,TeacherDto teacherDto) {
        teacher.setName(teacherDto.getName());
    return teacher;
    }
}
