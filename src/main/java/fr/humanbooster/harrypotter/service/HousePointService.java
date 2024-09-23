package fr.humanbooster.harrypotter.service;

import fr.humanbooster.harrypotter.repository.HousePointRepository;
import fr.humanbooster.harrypotter.entity.HousePoint;
import fr.humanbooster.harrypotter.dto.HousePointDto;
import fr.humanbooster.harrypotter.service.interfaces.ServiceListInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class HousePointService implements ServiceListInterface<HousePoint, Integer, HousePointDto, HousePointDto>{
   
    private final HousePointRepository housepointRepository;
    
    @Override
    public HousePoint create(HousePointDto housepointDto) {
    return housepointRepository.saveAndFlush(objectFromDto(new HousePoint(), housepointDto));
    }


    @Override
    public HousePoint update(HousePointDto housepointDto, Integer id) {
    HousePoint housepoint = objectFromDto(findById(id), housepointDto);
    housepoint.setId(id);
    housepointRepository.flush();
    return housepoint;
    }

    @Override
    public void delete(Integer id) {
        housepointRepository.deleteById(id);
    }

    @Override
    public HousePoint findById(Integer id) {
    return housepointRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
    
    @Override
    public List<HousePoint> list() {
    return housepointRepository.findAll();
    }
    
    private HousePoint objectFromDto(HousePoint housepoint,HousePointDto housepointDto) {
    housepoint.setHouse(housepointDto.getHouse());
    housepoint.setTotalPoint(housepointDto.getTotalPoint());
    housepoint.setYear(housepointDto.getYear());
    return housepoint;
    }
}
