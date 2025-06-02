package com.taskforge.repository;

import com.taskforge.domain.Issue;

import java.util.List;
import java.util.Optional;

public interface IssueRepository {
    Issue save(Issue issue);
    Optional<Issue> findById(Long id);
    List<Issue> findAll();
    void deleteById(Long id);
}
