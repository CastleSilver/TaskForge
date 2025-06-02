package com.taskforge.service;

import com.taskforge.domain.Issue;
import com.taskforge.domain.IssueStatus;
import com.taskforge.repository.IssueRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class IssueServiceImplTest {

    private IssueRepository issueRepository;
    private IssueService issueService;

    @BeforeEach
    void setUp() {
        issueRepository = Mockito.mock(IssueRepository.class);
        issueService = new IssueServiceImpl(issueRepository);
    }

    @Test
    void createIssue() {
        Issue issue = new Issue(null, "Bug in login", "Fix the null error", IssueStatus.OPEN, null, null);
        when(issueRepository.save(any())).thenReturn(issue);

        Issue saved = issueService.createIssue(issue);

        assertThat(saved.getTitle()).isEqualTo("Bug in login");
        assertThat(saved.getStatus()).isEqualTo(IssueStatus.OPEN);
    }

    @Test
    void getIssue() {
    }

    @Test
    void getAllIssues() {
    }

    @Test
    void updateIssue() {
    }

    @Test
    void deleteIssue() {
    }
}