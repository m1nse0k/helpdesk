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

    public Equipment register(EquipmentCreateRequest request) {
        // TODO 1: request의 값으로 Equipment 객체 만들기
        //         힌트: record는 request.equipmentName() 처럼 꺼내요 (get 없음!)
        Equipment requestEquipment = new Equipment(request.equipmentName(), request.type(), request.useYear());
        // TODO 2: 문서고(equipmentRepository)에 저장하기
        equipmentRepository.save(requestEquipment);
        // TODO 3: 만든 Equipment 돌려주기
        return requestEquipment;
    }
}