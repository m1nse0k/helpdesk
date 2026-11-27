package com.minseok.helpdesk.equipment;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EquipmentController {

    private final EquipmentService equipmentService;

    public EquipmentController(EquipmentService equipmentService) {
        this.equipmentService = equipmentService;
    }

    @GetMapping("/equipments")
    public List<Equipment> list() {
        return equipmentService.findAll();
    }

    // TODO: "/equipments/replace-count" 주소로 교체 대상 수를 돌려주는 메서드 만들기
    @GetMapping("/equipments/replace-count")
    public long replaceCount() {
        return equipmentService.countReplaceTargets();
    }

    @PostMapping("/equipments")
    public Equipment register(@RequestBody EquipmentCreateRequest request) {
        // TODO: Service에 등록을 맡기고, 결과를 돌려주기
        return equipmentService.register(request);
    }
}