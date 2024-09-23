package fr.humanbooster.harrypotter.controller;

import fr.humanbooster.harrypotter.dto.HouseHistoryDto;
import fr.humanbooster.harrypotter.dto.SubjectDto;
import fr.humanbooster.harrypotter.entity.HouseHistory;
import fr.humanbooster.harrypotter.entity.Subject;
import fr.humanbooster.harrypotter.service.HouseHistoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/househistorys")
@AllArgsConstructor
public class HouseHistoryController {
    private final HouseHistoryService househistoryService;

    @GetMapping
    public List<HouseHistory> getAllSubject() {
        return househistoryService.list();
    }

    @GetMapping("/{id}")
    public HouseHistory getHouseHistoryById(@PathVariable Integer id) {
        return househistoryService.findById(id);
    }

    @PostMapping
    public HouseHistory createHouseHistory(@RequestBody HouseHistoryDto houseHistoryDto) {
        return househistoryService.create(houseHistoryDto);
    }

    @PutMapping("/{id}")
    public HouseHistory updateHouseHistory(@PathVariable Integer id, @RequestBody HouseHistoryDto houseHistoryDto) {
        return househistoryService.update(houseHistoryDto, id);
    }

    @DeleteMapping("/{id}")
    public void deleteHouseHistory(@PathVariable Integer id) {
        househistoryService.delete(id);
    }

}
