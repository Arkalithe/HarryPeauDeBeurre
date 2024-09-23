package fr.humanbooster.harrypotter.service;

import fr.humanbooster.harrypotter.repository.HouseHistoryRepository;
import fr.humanbooster.harrypotter.entity.HouseHistory;
import fr.humanbooster.harrypotter.dto.HouseHistoryDto;
import fr.humanbooster.harrypotter.service.interfaces.ServiceListInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;


@Service
@AllArgsConstructor
public class HouseHistoryService implements ServiceListInterface<HouseHistory, Integer, HouseHistoryDto, HouseHistoryDto> {
   
    private final HouseHistoryRepository househistoryRepository;
    
    @Override
    public HouseHistory create(HouseHistoryDto houseHistoryDto) {
    return househistoryRepository.saveAndFlush(objectFromDto(new HouseHistory(), houseHistoryDto));
    }

    @Override
    public HouseHistory update(HouseHistoryDto houseHistory, Integer id) {
    HouseHistory househistory = objectFromDto(findById(id), houseHistory);
    househistory.setId(id);
    househistoryRepository.flush();
    return househistory;
    }

    @Override
    public void delete(Integer id) {
        househistoryRepository.deleteById(id);;
    }

    @Override
    public HouseHistory findById(Integer id) {
    return househistoryRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<HouseHistory> list() {
        return househistoryRepository.findAll();
    }
    
    private HouseHistory objectFromDto(HouseHistory houseHistory,HouseHistoryDto househistoryDto) {
    houseHistory.setOldFounderFirstName(househistoryDto.getSetOldFounderFirstName());
    houseHistory.setOldFounderLastName(househistoryDto.getSetOldFounderFirstName());
    houseHistory.setOldHouseName(househistoryDto.getOldHouseName());
    return houseHistory;
    }


}
