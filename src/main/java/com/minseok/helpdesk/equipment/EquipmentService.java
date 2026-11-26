package com.minseok.helpdesk.equipment;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipmentService {

    private final EquipmentRepository equipmentRepository;

    public EquipmentService(EquipmentRepository equipmentRepository) {
        this.equipmentRepository = equipmentRepository;
    }

    public List<Equipment> findAll() {
        return equipmentRepository.findAll();
    }

    public long countReplaceTargets() {
        // TODO: 교체 대상 장비 수를 세서 돌려주기
        //       힌트: 3일차 Stream! findAll()로 목록을 받아서 filter → count
        return findAll().stream().filter(e -> e.isReplaceTarget()).count();
    }
}