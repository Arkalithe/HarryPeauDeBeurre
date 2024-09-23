package fr.humanbooster.harrypotter.service;

import fr.humanbooster.harrypotter.repository.OffenseListRepository;
import fr.humanbooster.harrypotter.entity.OffenseList;
import fr.humanbooster.harrypotter.dto.OffenseListDto;
import fr.humanbooster.harrypotter.service.interfaces.ServiceListInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OffenseListService implements ServiceListInterface<OffenseList, Integer, OffenseListDto, OffenseListDto>{
   
    private final OffenseListRepository offenselistRepository;
    
    @Override
    public OffenseList create(OffenseListDto offenselistDto) {
    return offenselistRepository.saveAndFlush(objectFromDto(new OffenseList(),offenselistDto));
    }
    
    @Override
    public OffenseList update(OffenseListDto offenselistDto, Integer id) {
    OffenseList offenselist = objectFromDto(findById(id), offenselistDto);
    offenselist.setId(id);
    offenselistRepository.flush();
    return offenselist;
    }

    @Override
    public void delete(Integer id) {
        offenselistRepository.deleteById(id);;
    }
    
    @Override
    public OffenseList findById(Integer id) {
    return offenselistRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
    
    @Override
    public List<OffenseList> list() {
    return offenselistRepository.findAll();
    }
    
    private OffenseList objectFromDto(OffenseList offenselist,OffenseListDto offenselistDto) {
        offenselist.setCreatedAt(offenselistDto.getCreatedAt());
        offenselist.setOffenseSeriousness(offenselistDto.getOffenseSeriousness());
    return offenselist;
    }
}
