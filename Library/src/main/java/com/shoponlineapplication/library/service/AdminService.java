package com.shoponlineapplication.library.service;

import com.shoponlineapplication.library.dto.AdminDto;
import com.shoponlineapplication.library.model.Admin;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;

public interface AdminService {
    Admin findByUsername(String username);
    Admin save(AdminDto dto);
}
