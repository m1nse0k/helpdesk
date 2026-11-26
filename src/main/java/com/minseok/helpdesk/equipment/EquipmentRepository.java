package com.minseok.helpdesk.equipment;

import java.util.List;

public interface EquipmentRepository {
    void save(Equipment equipment);
    List<Equipment> findAll();
}
