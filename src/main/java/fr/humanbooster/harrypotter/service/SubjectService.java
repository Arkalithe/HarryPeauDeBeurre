package fr.humanbooster.harrypotter.service;

import fr.humanbooster.harrypotter.repository.SubjectRepository;
import fr.humanbooster.harrypotter.entity.Subject;
import fr.humanbooster.harrypotter.dto.SubjectDto;
import fr.humanbooster.harrypotter.service.interfaces.ServiceListInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SubjectService implements ServiceListInterface<Subject, Integer, SubjectDto, SubjectDto>{
   
    private final SubjectRepository subjectRepository;
    
    @Override
    public Subject create(SubjectDto subjectDto) {
    return subjectRepository.saveAndFlush(objectFromDto(new Subject(),subjectDto));
    }
    
    @Override
    public Subject update(SubjectDto subjectDto, Integer id) {
    Subject subject = objectFromDto(findById(id), subjectDto);
    subject.setId(id);
    subjectRepository.flush();
    return subject;
    }

    @Override
    public void delete(Integer id) {
    subjectRepository.deleteById(id);
    }
    
    @Override
    public Subject findById(Integer id) {
    return subjectRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
    
    @Override
    public List<Subject> list() {
    return subjectRepository.findAll();
    }
    
    private Subject objectFromDto(Subject subject,SubjectDto subjectDto) {
        subject.setSubjectName(subjectDto.getSubjectName());
    return subject;
    }
}
