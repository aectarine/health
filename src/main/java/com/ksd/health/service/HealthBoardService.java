package com.ksd.health.service;

import com.ksd.health.model.HealthBoard;
import com.ksd.health.repository.HealthBoardRepository;
import com.ksd.health.vo.member.HealthBoardForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Transactional
@Service
public class HealthBoardService {
    private final HealthBoardRepository healthBoardRepository;

    @Autowired
    public HealthBoardService(HealthBoardRepository healthBoardRepository) {
        this.healthBoardRepository = healthBoardRepository;
    }

    public Long create(HealthBoardForm healthBoardForm) {
        HealthBoard healthBoard = settingHealthBoard(healthBoardForm);
        healthBoardRepository.save(healthBoard);
        return healthBoard.getSeq();
    }

    HealthBoard settingHealthBoard(HealthBoardForm healthBoardForm) {
        HealthBoard healthBoard = new HealthBoard();
        healthBoard.setTitle(healthBoardForm.getTitle());
        healthBoard.setVideo(healthBoardForm.getVideo());
        healthBoard.setViews(healthBoardForm.getViews());
        healthBoard.setRecommend(healthBoardForm.getRecommend());
        healthBoard.setMember(healthBoardForm.getMember());
        return healthBoard;
    }

    public List<HealthBoard> list() {
        List<HealthBoard> list = healthBoardRepository.findAll();
        return list;
    }
}
