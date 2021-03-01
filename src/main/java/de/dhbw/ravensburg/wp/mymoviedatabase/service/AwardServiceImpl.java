package de.dhbw.ravensburg.wp.mymoviedatabase.service;

import de.dhbw.ravensburg.wp.mymoviedatabase.model.Award;
import de.dhbw.ravensburg.wp.mymoviedatabase.repository.AwardRepository;
import de.dhbw.ravensburg.wp.mymoviedatabase.repository.MovieRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AwardServiceImpl implements AwardService {

    private AwardRepository awardRepository;

    public AwardServiceImpl (AwardRepository awardRepository, MovieRepository movieRepository){
        this.awardRepository = awardRepository;
    }

    @Override
    public Award addAward(Award award){
        return this.awardRepository.save(award);
    }
    @Override
    public Award getAwardById(long id){
        return this.awardRepository.findById(id).get();
    }
    @Override
    public List<Award> getAllAwards(){
        return this.awardRepository.findAll();
    }

    @Override
    @Transactional
    public Award updateAward(Award award){
        Award old_award = this.awardRepository.findById(award.getId()).get();
        old_award.setAcademy(award.getAcademy());
        old_award.setCategory(award.getCategory());
        old_award.setYear(award.getYear());
        return old_award;
    }
    @Override
    public void deleteAward(long id){
        this.awardRepository.deleteById(id);
    }


}
