package com.synchrotech.lac_datamanagement.service;

import java.time.LocalDateTime;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.synchrotech.lac_datamanagement.models.AuditLog;
import com.synchrotech.lac_datamanagement.models.Enums.Action;

public class AuditLogService {
    private ObjectMapper objectMapper = new ObjectMapper();

    public void logChange(String userId, String entityType, String entityId, int ActionIndex,
            Object oldValue, Object newValue) throws JsonProcessingException {
        String oldValueJson = oldValue != null ? objectMapper.writeValueAsString(oldValue) : null;
        String newValueJson = newValue != null ? objectMapper.writeValueAsString(newValue) : null;

        AuditLog auditLog = new AuditLog();
        auditLog.setUser_id(userId);
        auditLog.setEntity_id(entityId);
        auditLog.setTimestamp(LocalDateTime.now());
        auditLog.setOld_value(oldValueJson);
        auditLog.setNew_value(newValueJson);
        switch (ActionIndex) {
            case 0:
                auditLog.setAction(Action.POST);
                break;
            case 1:
                auditLog.setAction(Action.UPDATE);
                break;
            case 2:
                auditLog.setAction(Action.DELETE);
                break;
        }

        try {
            // auditLogRepository.save(auditLog);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public <T> T deserializeOldValue(String oldValueJson, Class<T> valueType)
            throws JsonProcessingException {
        return objectMapper.readValue(oldValueJson, valueType);
    }

    public <T> T deserializeNewValue(String newValueJson, Class<T> valueType)
            throws JsonProcessingException {
        return objectMapper.readValue(newValueJson, valueType);
    }
}
