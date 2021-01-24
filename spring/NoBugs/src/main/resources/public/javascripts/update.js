window.onload = function() {
document.getElementById("btnSubmit").addEventListener("click", function() {

  fetch("/Employees/" + document.getElementById("empno").value, {
    method: "PUT"
   })
    .then(async (response) =>{
     if (!response.ok) {
       throw Error(response);
     }

    let data = await response.json();
     document.getElementById("firstname").value = data.firstname;
     document.getElementById("lastname").value = data.lastname;
     document.getElementById("deptno").value = data.deptno;
     document.getElementById("hiredate").value = data.hiredate.split("T")[0];
     document.getElementById("job").value = data.job;
     document.getElementById("edlevel").value = data.edlevel;
     document.getElementById("sex").value = data.sex;
     document.getElementById("birthdate").value = data.birthdate.split("T")[0];
     document.getElementById("salary").value = data.salary;
     document.getElementById("bonus").value = data.bonus;
     document.getElementById("comm").value = data.comm;

       }).then((resjason) => {
         return resjason;
       })
       .catch(error => {
          alert("employee number does not exist")
       });
      });

document.getElementById("form").addEventListener("submit", async function(event){
  event.preventDefault();
    const empnoValue = document.getElementById("empno").value;
    const firstNameValue = document.getElementById("firstname").value;
    const lastNameValue = document.getElementById("lastname").value;
    const sexValue = document.getElementById("sex").value;

    if(checkOneEmpty()) {
      sweetAlert("Error!", "At least one of the fields was not filled", "error");
    }
    else if(empnoValue.length != 6 || (isNaN(empnoValue))) {
      sweetAlert("Error!", "Employee number must be 6 numbers(only numbers)", "error");
    }
    else if(firstNameValue.length < 4 || firstNameValue.match("[A-Za-z]+")[0].length != firstNameValue.length) {
      sweetAlert("Error!", "First name must be bigger than 3 letters(only letters)", "error");
    }
    else if(lastNameValue.length < 4 || lastNameValue.match("[A-Za-z]+")[0].length != lastNameValue.length) {
      sweetAlert("Error!", "Last name must be bigger than 3 letters(only letters)", "error");
    }
    else if(! (await checkDeptno())) {
      sweetAlert("Error!", "Department number does not exist", "error");
    }
    else if(sexValue != "M" &&  sexValue != "F") {
      sweetAlert("Error!", "Gender must be 'M' or 'F'", "error");
    }
    else {

      const form = document.getElementById("form");
      await fetch("/Employees", {
        method: "PUT", 
        body: JSON.stringify(formToJSON(form.elements)),
        headers: {
          "Content-type": "application/json; charset=UTF-8"
        }
       })
        .then(response => {

          if (!response.ok) {
           throw Error(response);
            }
         swal({
            title: "Success!", 
            text: data, 
            type: "success"}, function() {
            window.location.assign("viewEmployees.html");
         });
           })
        .catch(error => {
            sweetAlert("Error!", error.message, "error");
           });
    }
    
    return false;
  });
};


function checkOneEmpty() {
  if(document.getElementById("empno").value == "" ||
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
     document.getElementById("comm").value == "") {
     return true;
  }

  return false;
}
  
async function checkDeptno() {
  let bIsExist;

  await fetch("/Departments/" + document.getElementById("deptno").value, { 
    method: "GET" })
    .then((response) => {
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
  
 