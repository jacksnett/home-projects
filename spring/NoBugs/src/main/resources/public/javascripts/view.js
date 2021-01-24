window.onload = function() {
  fetch("/Employees", {
    method: "GET"
  })
    .then(response => {
      if (!response.ok) {
        throw Error(response.status);
      }

      return response.json();
    })
    .then(data => {
      var employeesDiv =
        "<table class='table table-hover'>" +
        "<thead><tr><th>Employee number</th>" +
        "<th>First name</th>" +
        "<th>Last name</th>" +
        "<th>Department number</th>" +
        "<th>Hire date</th>" +
        "<th>Job</th>" +
        "<th>Education level</th>" +
        "<th>Gender</th>" +
        "<th>Birth date</th>" +
        "<th>Salary</th>" +
        "<th>Bonus</th>" +
        "<th>Comm</th>" +
        "</tr></thead><tbody>";
      for (var i = 0; i < data.length; i++) {
        employeesDiv +=
          "<tr>" +
          "<td>" +
          data[i].empno +
          "</td>" +
          "<td>" +
          data[i].firstname +
          "</td>" +
          "<td>" +
          data[i].lastname +
          "</td>" +
          "<td>" +
          data[i].deptno +
          "</td>" +
          "<td>" +
          data[i].hiredate +
          "</td>" +
          "<td>" +
          data[i].job +
          "</td>" +
          "<td>" +
          data[i].edlevel +
          "</td>" +
          "<td>" +
          data[i].sex +
          "</td>" +
          "<td>" +
          data[i].birthdate +
          "</td>" +
          "<td>" +
          data[i].salary +
          "</td>" +
          "<td>" +
          data[i].bonus +
          "</td>" +
          "<td>" +
          data[i].comm +
          "</td>";
      }

      employeesDiv += "</tbody></table>";

      document.getElementById("tableDiv").innerHTML = employeesDiv;
    })
    .catch(error => sweetAlert("Error!", error.responseText, "error"));
};
