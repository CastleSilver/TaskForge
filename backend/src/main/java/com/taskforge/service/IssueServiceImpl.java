package com.taskforge.service;

import com.taskforge.domain.Issue;
import com.taskforge.repository.IssueRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class IssueServiceImpl implements IssueService {

    private final IssueRepository issueRepository;

    public IssueServiceImpl(IssueRepository issueRepository) {
        this.issueRepository = issueRepository;
    }

    @Override
    public Issue createIssue(Issue issue) {
        issue.setCreatedAt(LocalDateTime.now());
        return issueRepository.save(issue);
    }

    @Override
    public Optional<Issue> getIssue(Long id) {
        return issueRepository.findById(id);
    }

    @Override
    public List<Issue> getAllIssues() {
        return issueRepository.findAll();
    }

    @Override
    public Issue updateIssue(Long id, Issue updated) {
        Issue existing = issueRepository.findById(id).orElseThrow();
        existing.setTitle(updated.getTitle());
        existing.setDescription(updated.getDescription());
        existing.setStatus(updated.getStatus());
        existing.setUpdatedAt(LocalDateTime.now());
        return issueRepository.save(existing);
    }

    @Override
    public void deleteIssue(Long id) {
        issueRepository.deleteById(id);
    }
}
