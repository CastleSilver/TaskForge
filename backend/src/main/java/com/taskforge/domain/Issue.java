package com.taskforge.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Issue {
    private Long Id;
    private String title;
    private String description;
    private IssueStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
