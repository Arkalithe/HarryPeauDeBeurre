package fr.humanbooster.harrypotter.service;

import fr.humanbooster.harrypotter.repository.TypeClassRepository;
import fr.humanbooster.harrypotter.entity.TypeOfClass;
import fr.humanbooster.harrypotter.dto.TypeClassDto;
import fr.humanbooster.harrypotter.service.interfaces.ServiceListInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TypeClassService implements ServiceListInterface<TypeOfClass, Integer, TypeClassDto, TypeClassDto>{
   
    private final TypeClassRepository typeclassRepository;
    
    @Override
    public TypeOfClass create(TypeClassDto typeclassDto) {
    return typeclassRepository.saveAndFlush(objectFromDto(new TypeOfClass(),typeclassDto));
    }
    
    @Override
    public TypeOfClass update(TypeClassDto typeclassDto, Integer id) {
        TypeOfClass typeclass = objectFromDto(findById(id), typeclassDto);
    typeclass.setId(id);
    typeclassRepository.flush();
    return typeclass;
    }

    @Override
    public void delete(Integer id) {
    typeclassRepository.deleteById(id);
    }
    
    @Override
    public TypeOfClass findById(Integer id) {
    return typeclassRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
    
    @Override
    public List<TypeOfClass> list() {
    return typeclassRepository.findAll();
    }
    
    private TypeOfClass objectFromDto(TypeOfClass typeclass,TypeClassDto typeclassDto) {
        typeclass.setYearTaught(typeclassDto.getYearTaught());
        typeclass.setStudent(typeclassDto.getStudent());
        typeclass.setSubject(typeclassDto.getSubject());
        typeclass.setTeacher(typeclassDto.getTeacher());
    return typeclass;
    }
}
