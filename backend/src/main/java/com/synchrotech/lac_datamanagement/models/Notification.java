package com.synchrotech.lac_datamanagement.models;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "notification")
public class Notification {
    @Id
    private String notification_id;
    @NotNull(message = "notification message cannot be null")
    private String message;
    @CreatedDate
    private LocalDateTime sentAt;
    @NotNull(message = "recipient id cannot be null")
    private String recipientId;
}