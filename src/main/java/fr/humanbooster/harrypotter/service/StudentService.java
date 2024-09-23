package fr.humanbooster.harrypotter.service;

import fr.humanbooster.harrypotter.repository.StudentRepository;
import fr.humanbooster.harrypotter.entity.Student;
import fr.humanbooster.harrypotter.dto.StudentDto;
import fr.humanbooster.harrypotter.service.interfaces.ServiceListInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StudentService implements ServiceListInterface<Student, Integer, StudentDto, StudentDto>{
   
    private final StudentRepository studentRepository;
    
    @Override
    public Student create(StudentDto studentDto) {
    return studentRepository.saveAndFlush(objectFromDto(new Student(),studentDto));
    }
    
    @Override
    public Student update(StudentDto studentDto, Integer id) {
    Student student = objectFromDto(findById(id), studentDto);
    student.setId(id);
    studentRepository.saveAndFlush(student);
    return student;
    }

    @Override
    public void delete(Integer id) {
        studentRepository.deleteById(id);;
    }
    
    @Override
    public Student findById(Integer id) {
    return studentRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
    
    @Override
    public List<Student> list() {
    return studentRepository.findAll();
    }
    
    private Student objectFromDto(Student student,StudentDto studentDto) {
        student.setAlive(studentDto.isAlive());
        student.setHouse(studentDto.getHouse());
        student.setName(studentDto.getName());
        student.setYearOfBirth(studentDto.getYearOfBirth());
        student.setTypeOfClasses(studentDto.getTypeOfClasses());
        student.setOffenseList(studentDto.getOffenseList());
    return student;
    }
}
