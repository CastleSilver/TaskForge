# 🚀 TaskForge - AI-Powered Issue Tracker

Welcome to **TaskForge**, a smart and developer-friendly issue tracker designed to streamline project management using modern technologies, test-driven development, and AI-enhanced productivity features.

---

## 🧠 Features

* 📌 **Issue & Project Management**: Create, update, and organize issues by project.
* 💬 **Comments System**: Collaborate with threaded discussions on issues.
* 🧾 **Audit Logging**: Track every action with full issue history.
* 🤖 **AI Assistant** (WIP):

  * Suggest issue titles/descriptions
  * Summarize long comment threads
  * Auto-prioritize tasks
* 🗂️ **Kanban View**: Interactive drag-and-drop board for agile workflows.

---

## 💻 Tech Stack

| Layer        | Tech                                            |
| ------------ | ----------------------------------------------- |
| **Backend**  | Java 21, Spring Boot, JPA, TDD (JUnit, Mockito) |
| **Frontend** | React, TypeScript, Tailwind CSS                 |
| **AI**       | OpenAI API / Hugging Face Transformers          |
| **Database** | PostgreSQL / MongoDB                            |
| **Infra**    | Docker, GitHub Actions, AWS (EC2/RDS)           |

---

## 📘 Backend – Function Definition Document

### 🧱 Architecture Overview

```
com.taskforge
├── domain
│   ├── model         (Entities, Value Objects)
│   ├── repository    (Interfaces)
├── application
│   ├── service       (Use cases, Business logic)
├── infrastructure
│   ├── repository    (JPA/DB implementations)
├── web
│   ├── controller    (REST endpoints)
├── config            (Spring configuration)
└── common            (Exceptions, DTOs, Utils)
```

### 🗂️ Modules & Functions

#### 1. **Issue Management**

| Function                                           | Description                             |
| -------------------------------------------------- | --------------------------------------- |
| `createIssue(ProjectId, title, description)`       | Create a new issue in a project         |
| `updateIssue(IssueId, title, description, status)` | Update issue details                    |
| `assignUser(IssueId, UserId)`                      | Assign a user to an issue               |
| `changeStatus(IssueId, Status)`                    | Change issue status (TODO, DOING, DONE) |
| `getIssueById(IssueId)`                            | Fetch issue detail                      |
| `listIssuesByProject(ProjectId)`                   | List all issues in a project            |
| `deleteIssue(IssueId)`                             | Soft delete an issue                    |

#### 2. **Comment System**

| Function                                     | Description                    |
| -------------------------------------------- | ------------------------------ |
| `addComment(IssueId, UserId, content)`       | Add a comment to an issue      |
| `replyToComment(CommentId, UserId, content)` | Nested comment (thread)        |
| `listComments(IssueId)`                      | Fetch comments for an issue    |
| `editComment(CommentId, content)`            | Edit comment content           |
| `deleteComment(CommentId)`                   | Delete a comment (soft delete) |

#### 3. **Project Management**

| Function                                      | Description                |
| --------------------------------------------- | -------------------------- |
| `createProject(name, description)`            | Create a new project       |
| `getProject(ProjectId)`                       | Fetch project details      |
| `listProjects(UserId)`                        | List all projects for user |
| `updateProject(ProjectId, name, description)` | Edit project info          |
| `deleteProject(ProjectId)`                    | Archive/delete a project   |

#### 4. **User Management**

| Function                        | Description              |
| ------------------------------- | ------------------------ |
| `registerUser(email, name)`     | Create new user          |
| `getUserProfile(UserId)`        | Fetch profile            |
| `updateUserProfile(UserId, ..)` | Edit user info           |
| `listAssignedIssues(UserId)`    | View user-specific tasks |

#### 5. **Audit Logging**

| Function                                              | Description                   |
| ----------------------------------------------------- | ----------------------------- |
| `logAction(EntityType, EntityId, ActionType, UserId)` | Save every significant action |
| `getIssueHistory(IssueId)`                            | Get full history of an issue  |
| `getUserActivity(UserId)`                             | Show recent actions by user   |

#### 6. **Kanban View (Service-Level API)**

| Function                       | Description                       |
| ------------------------------ | --------------------------------- |
| `getBoardByProject(ProjectId)` | Get all issues grouped by status  |
| `moveIssue(IssueId, Status)`   | Change issue status via drag-drop |

#### 7. **AI Assistant** (Pluggable Layer)

| Function                             | Description                          |
| ------------------------------------ | ------------------------------------ |
| `suggestTitleAndDescription(prompt)` | AI-generated issue title/description |
| `summarizeComments(IssueId)`         | Summarize long comment threads       |
| `suggestPrioritization(ProjectId)`   | Auto-tagging or prioritization       |

#### 8. **Test-Driven Setup**

Every service interface should follow:

* Interface-first design
* Unit tests with JUnit + Mockito
* Integration tests via `@SpringBootTest`

**Naming Convention:**

* Tests: `*ServiceTest`, `*ControllerTest`
* Use `@DisplayName` and nested tests for readability

### 📦 Suggested Package Layout (Java)

```
src/main/java/com/taskforge
│
├── domain
│   ├── issue (Issue, Status, IssueRepository)
│   ├── project
│   ├── comment
│   ├── audit
│   └── user
│
├── application
│   ├── issue
│   │   ├── IssueService
│   │   └── dto
│   ├── comment
│   ├── project
│   └── ai
│
├── infrastructure
│   └── persistence
│       ├── JpaIssueRepository
│       └── entities
│
├── web
│   └── IssueController, ProjectController ...
└── config
```

---

## 🛠️ Getting Started (Backend)

```bash
./gradlew build
./gradlew bootRun
```

Visit: `http://localhost:8080/api/issues`

---

## 🤝 Contributing

We welcome contributors! Please fork, create a feature branch, and open a PR with clear commit messages. Tests required.

---

## 📄 License

[MIT](LICENSE)
