package de.dhbw.ravensburg.wp.mymoviedatabase.controller;

import de.dhbw.ravensburg.wp.mymoviedatabase.model.Award;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface AwardController {
    @GetMapping
    List<Award> getAllAwards();

    @GetMapping("/{awardId}")
    Award getAwardById(@PathVariable(name = "awardId") long awardId);

    @PostMapping
    Award addNewAward(@RequestBody Award award);

    @DeleteMapping("/awardId")
    void deleteAward(@PathVariable(name = "awardId") Long awardId);

    @PutMapping("/{awardId}")
    Award updateAward(@PathVariable("awardId") Long awardId, @RequestBody Award award);
}
