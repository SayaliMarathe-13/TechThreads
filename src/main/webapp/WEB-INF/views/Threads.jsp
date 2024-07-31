<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="Model.Threads" %>
<%
    List<Threads> threads = (List<Threads>) request.getAttribute("threads");
    String courseName = (String) request.getAttribute("courseName");
    String userRole = (String) session.getAttribute("userRole");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Discussion Threads</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            background-color: #f5f7f9;
            padding-top: 20px;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        }
        .container {
            background: #ffffff;
            padding: 40px;
            border-radius: 12px;
            box-shadow: 0 4px 10px rgba(0,0,0,0.1);
            max-width: 900px;
            margin: 20px auto;
            display: flex;
            flex-direction: column;
            align-items: center;
        }
        .course-header {
            margin-bottom: 40px;
            text-align: center;
            width: 100%;
        }
        .course-header h1 {
            margin: 0;
            font-size: 2.5rem;
            color: #333;
        }
        .btn-post {
            margin-top: 10px;
            background-color: #007bff;
            border-color: #007bff;
            transition: background-color 0.3s, border-color 0.3s;
        }
        .btn-post:hover {
            background-color: #0056b3;
            border-color: #00408d;
        }
        .btn-home {
            background-color: #28a745;
            border-color: #28a745;
            color: #fff;
            transition: background-color 0.3s, border-color 0.3s;
        }
        .btn-home:hover {
            background-color: #218838;
            border-color: #1e7e34;
        }
        .thread-item {
            margin-bottom: 30px;
            border: 1px solid #dee2e6;
            border-radius: 12px;
            background-color: #ffffff;
            padding: 20px;
            transition: background-color 0.3s;
            box-shadow: 0 2px 5px rgba(0,0,0,0.1);
            position: relative;
        }
        .thread-item:hover {
            background-color: #f1f3f5;
        }
        .thread-title {
            color: #007bff;
            font-weight: 600;
            text-decoration: none;
        }
        .thread-title:hover {
            text-decoration: underline;
        }
        .thread-item p {
            margin: 10px 0;
        }
        .reply-form {
            margin-top: 40px;
        }
        .modal-backdrop {
            backdrop-filter: blur(8px);
        }
        pre {
            background: #e9ecef;
            padding: 15px;
            border-radius: 8px;
            overflow: auto;
            white-space: pre-wrap;
            border: 1px solid #dee2e6;
        }
        .modal-content {
            border-radius: 12px;
        }
        .form-group label {
            font-weight: 600;
            color: #333;
        }
        .form-control {
            border-radius: 8px;
        }
        .modal-header .close {
            margin: -1rem -1rem -1rem auto;
        }
        .modal-header {
            border-bottom: 1px solid #dee2e6;
        }
        .modal-footer {
            border-top: 1px solid #dee2e6;
        }
    </style>
</head>
<body>
<%
    // Determine home button URL based on user role
    String homeUrl = "/userDashboard"; // Default URL for users
    if ("Admin".equals(userRole)) {
        homeUrl = "/dashboard"; // URL for admin
    }
%>
<a href="<%=request.getContextPath()%><%= homeUrl %>" class="btn btn-home">Home</a>
<div class="container">
    <!-- Header with Home and Post Button -->
    <div class="course-header">
        <div class="d-flex justify-content-between align-items-center">
            <h1>Subject: <%= courseName %></h1>
        </div>
        <button type="button" class="btn btn-primary btn-post" data-toggle="modal" data-target="#postThreadModal">
            Post New Thread
        </button>
    </div>

    <!-- Threads List -->
    <div class="thread-list">
        <h2>Discussion Threads</h2>
        <% 
            for (Threads thread : threads) {
                String escapedDescription = org.apache.commons.text.StringEscapeUtils.escapeHtml4(thread.getDescription());
                
        %>
            <div class="thread-item" style="position: relative; margin-bottom: 20px;">
                <a href="<%= request.getContextPath() %>/thread/<%= thread.getId() %>" class="thread-title">
                    <%= thread.getTitle() %>
                </a>
                <p><strong>Description:</strong></p>
                <pre><%= escapedDescription %></pre>
                <small>Posted by user <b><%= thread.getName() %></b> on <%= thread.getCreationDate() %></small>

                <!-- Trash Icon -->
                <% if ("Admin".equals(userRole)) { %>
                <div class="delete-icon" style="
                    position: absolute;
                    bottom: 5px; /* Adjust as needed */
                    right: 5px;  /* Adjust as needed */
                    cursor: pointer;
                    padding: 5px; /* Space between icon and card border */
                    color: red;
                "> 
                    <a href="<%= request.getContextPath() %>/deleteThread/<%= thread.getId() %>">
                        <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="none" stroke="red" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-trash" width="24" height="24">
                            <path d="M3 6h18M6 6V4a1 1 0 0 1 1-1h10a1 1 0 0 1 1 1v2M6 6l1 14h10l1-14M10 11v6M14 11v6"/>
                        </svg>
                    </a>
                </div>
                <% } %>
            </div>
        <% 
            } 
        %>
    </div>
</div>

<!-- Modal for Posting New Thread -->
<div class="modal fade" id="postThreadModal" tabindex="-1" role="dialog" aria-labelledby="postThreadModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="postThreadModalLabel">Post New Thread</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <form id="postThreadForm" action="<%=request.getContextPath()%>/threads/threadPost" method="post">
        <div class="modal-body">
          <!-- Hidden fields -->
          <input type="hidden" name="courseName" value="<%= courseName %>">
          <input type="hidden" name="name" value="<%= session.getAttribute("name") %>">
          <input type="hidden" name="userId" value="<%= session.getAttribute("loggedInContact") %>">
          <!-- Title field -->
          <div class="form-group">
            <label for="threadTitle">Title</label>
            <input type="text" class="form-control" id="threadTitle" name="title" required>
          </div>
          <!-- Description field -->
          <div class="form-group">
            <label for="threadDescription">Description</label>
            <textarea class="form-control" id="threadDescription" name="description" rows="6" required></textarea>
          </div>
          <!-- Date picker for creation date -->
          <div class="form-group">
            <label for="creationDate">Creation Date</label>
            <input type="date" class="form-control" id="creationDate" name="creationDate" required>
          </div>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
          <button type="submit" class="btn btn-primary">Submit</button>
        </div>
      </form>
    </div>
  </div>
</div>
<style>
    .btn-home {
        position: absolute;
        top: 20px;
        right: 60px;
    }
</style>
<!-- Include Bootstrap JS and dependencies -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
