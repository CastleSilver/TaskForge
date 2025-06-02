package com.taskforge.service;

import com.taskforge.domain.Issue;

import java.util.List;
import java.util.Optional;

public interface IssueService {
    Issue createIssue(Issue issue);
    Optional<Issue> getIssue(Long id);
    List<Issue> getAllIssues();
    Issue updateIssue(Long id, Issue issue);
    void deleteIssue(Long id);
}
