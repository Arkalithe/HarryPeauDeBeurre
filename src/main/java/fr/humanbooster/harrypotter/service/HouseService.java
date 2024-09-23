package fr.humanbooster.harrypotter.service;

import fr.humanbooster.harrypotter.repository.HouseRepository;
import fr.humanbooster.harrypotter.entity.House;
import fr.humanbooster.harrypotter.dto.HouseDto;
import fr.humanbooster.harrypotter.service.interfaces.ServiceListInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;


@Service
@AllArgsConstructor
public class HouseService implements ServiceListInterface<House, Integer, HouseDto, HouseDto> {

    private final HouseRepository houseRepository;

    @Override
    public House create(HouseDto houseDto) {
        return houseRepository.saveAndFlush(
                objectFromDto(new House(), houseDto));
    }

    @Override
    public House update(HouseDto houseDto, Integer id) {
        House house = objectFromDto(findById(id), houseDto);
        house.setId(id);
        houseRepository.flush();
        return house;
    }

    @Override
    public void delete(Integer id) {
        houseRepository.deleteById(id);
    }

    @Override
    public House findById(Integer id) {
        return houseRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<House> list() {
        return houseRepository.findAll();
    }

    private House objectFromDto(House house, HouseDto houseDto) {
        house.setFounderFirstName(houseDto.getFounderFirstName());
        house.setFounderLastName(houseDto.getFounderLastName());
        house.setHouseName(houseDto.getHouseName());
        return house;
    }
}
