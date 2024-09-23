package fr.humanbooster.harrypotter.service;

import fr.humanbooster.harrypotter.repository.OffenseRepository;
import fr.humanbooster.harrypotter.entity.Offense;
import fr.humanbooster.harrypotter.dto.OffenseDto;
import fr.humanbooster.harrypotter.service.interfaces.ServiceListInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;

@Service
@AllArgsConstructor
public class OffenseService implements ServiceListInterface<Offense, Integer, OffenseDto, OffenseDto> {

    private final OffenseRepository offenseRepository;

    @Override
    public Offense create(OffenseDto offenseDto) {
        return offenseRepository.saveAndFlush(objectFromDto(new Offense(), offenseDto));
    }

    @Override
    public Offense update(OffenseDto offenseDto, Integer id) {
        Offense offense = objectFromDto(findById(id), offenseDto);
        offense.setId(id);
        offenseRepository.flush();
        return offense;
    }

    @Override
    public void delete(Integer id) {
        offenseRepository.deleteById(id);;
    }

    @Override
    public Offense findById(Integer id) {
        return offenseRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<Offense> list() {
        return offenseRepository.findAll();
    }

    private Offense objectFromDto(Offense offense, OffenseDto offenseDto) {
        offense.setLabel(offenseDto.getLabel());
        return offense;
    }
}
