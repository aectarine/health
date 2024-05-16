package com.ksd.health.service;

import com.ksd.health.model.HealthBoard;
import com.ksd.health.repository.HealthBoardRepository;
import com.ksd.health.vo.member.HealthBoardForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        healthBoard.setTitle(healthBoard.getTitle());
        healthBoard.setVideo(healthBoard.getVideo());
        healthBoard.setViews(healthBoard.getViews());
        healthBoard.setRecommend(healthBoardForm.getRecommend());
        return healthBoard;
    }
}
