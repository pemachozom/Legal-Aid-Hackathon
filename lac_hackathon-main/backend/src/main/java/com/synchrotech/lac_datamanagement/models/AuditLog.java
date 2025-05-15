package com.synchrotech.lac_datamanagement.models;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.synchrotech.lac_datamanagement.models.Enums.Action;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "audit_logs")
public class AuditLog {
    @Id
    private String log_id;
    @NotNull(message = "user id cannot be null")
    private String user_id; // who made the change
    @NotNull(message = "entity id cannot be null")
    private String entity_id; // what entity was changed
    @NotNull(message = "action cannot be null")
    private Action action; // what use did on the entity
    @CreatedDate
    private LocalDateTime timestamp;
    private String old_value; // The serialized JSON of the old value before the change
    private String new_value; // The serialized JSON of the new value after the change
}
