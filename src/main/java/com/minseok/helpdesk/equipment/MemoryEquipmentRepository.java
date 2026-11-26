package com.minseok.helpdesk.equipment;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MemoryEquipmentRepository implements EquipmentRepository {

    // TODO 1: 장비를 담을 List 필드 (private final로)
    private final List<Equipment> equipments;

    public MemoryEquipmentRepository() {
        // TODO 2: 테스트용 장비 5~6대를 미리 save()로 넣어두기
        //         (서버를 켤 때마다 기본 데이터가 들어가도록)
        this.equipments = new ArrayList<>();
        save(new Equipment("노트북-A", "노트북", 3));
        save(new Equipment("서버-A", "서버", 7));
        save(new Equipment("프린터-A", "프린터", 5));
        save(new Equipment("노트북-B", "노트북", 7));
        save(new Equipment("마우스-A", "마우스", 1));
    }

    @Override
    public void save(Equipment equipment) {
        // TODO 3: 리스트에 추가
        equipments.add(equipment);
    }

    @Override
    public List<Equipment> findAll() {
        // TODO 4: 리스트 돌려주기
        return  equipments;
    }
}