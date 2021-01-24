window.onload = function() {
  document
    .getElementById("btnSubmit")
    .addEventListener("click", addNewEmployee);
};

const addNewEmployee = async function(event) {
  const form = document.getElementById("addForm");
  event.preventDefault();
  if (await isValidateForm()) {
    fetch("/Employees", {
      method: "POST",
      headers: {
        "Content-Type": "application/json"
      },
      body: JSON.stringify(formToJSON(form.elements))
    })
      .then(response => {
        if (!response.ok) {
          throw Error(response.status);
        }
        swal(
          {
            title: "Success!",
            text: "new Worker added successfully",
            type: "success"
          },
          function() {
            window.location.assign("viewEmployees.html");
          }
        );
      })
      .catch(error => {
        sweetAlert("Error!", error.responseText, "error");
      });
  }
};

const isValidateForm = async function() {
  let isValidForm = false;

  if (validateNoEmptyFiels()) {
    sweetAlert("Error!", "At least one of the fields was not filled", "error");
  } else if (
    document.getElementById("empno").value.length != 6 ||
    isNaN(document.getElementById("empno").value)
  ) {
    sweetAlert(
      "Error!",
      "Employee number must be 6 numbers(only numbers)",
      "error"
    );
  } else if (await checkEmpno() === false) {
    sweetAlert("Error!", "Employee number already exists", "error");
  } else if (
    document.getElementById("firstname").value.length < 4 ||
    document.getElementById("firstname").value.match("[A-Za-z]+")[0].length !=
      document.getElementById("firstname").value.length
  ) {
    sweetAlert(
      "Error!",
      "First name must be bigger than 3 letters(only letters)",
      "error"
    );
  } else if (
    document.getElementById("lastname").value.length < 4 ||
    document.getElementById("lastname").value.match("[A-Za-z]+")[0].length !=
    document.getElementById("lastname").value.length
  ) {
    sweetAlert(
      "Error!",
      "Last name must be bigger than 3 letters(only letters)",
      "error"
    );
  } else if (!(await checkDeptno())) {
    sweetAlert("Error!", "Department number does not exist", "error");
  } else if (
    document.getElementById("sex").value != "M" &&
    document.getElementById("sex").value != "F"
  ) {
    sweetAlert("Error!", "Gender must be 'M' or 'F'", "error");
  } else {
    isValidForm = true;
  }

  return isValidForm;
};

const validateNoEmptyFiels = () => {
  if (
    document.getElementById("empno").value == "" ||
    document.getElementById("firstname").value == "" ||
    document.getElementById("lastname").value == "" ||
    document.getElementById("deptno").value == "" ||
    document.getElementById("hiredate").value == "" ||
    document.getElementById("job").value == "" ||
    document.getElementById("edlevel").value == "" ||
    document.getElementById("sex").value == "" ||
    document.getElementById("birthdate").value == "" ||
    document.getElementById("salary").value == "" ||
    document.getElementById("bonus").value == "" ||
    document.getElementById("comm").value == "" ||
    document.getElementById("salary").value == ""
  ) {
    return true;
  }

  return false;
};

async function checkDeptno() {
  let bIsExist;

  await fetch("/Departments/" + document.getElementById("deptno").value, {})
    .then(response => {
      if (!response.ok) {
        throw Error(response.status);
      }

      bIsExist = true;
    })
    .catch(error => {
      bIsExist = false;
    });

  return bIsExist;
}

async function checkEmpno() {
  let bIsExist;

  await fetch("/Employees/" + document.getElementById("empno").value, {})
    .then(response => {
      if (!response.ok) {
        throw Error(response.status);
      }

      bIsExist = true;
    })
    .catch(error => {
      bIsExist = false;
    });

  return bIsExist;
}

const formToJSON = elements =>
  [].reduce.call(
    elements,
    (data, element) => {
      data[element.name] = element.value;
      return data;
    },
    {}
  );
