window.onload = function() {
  document.getElementById("btnDelete").addEventListener("click", deleteEmploy);
};

function deleteEmploy() {
    if(document.getElementById("empno").value.length == 0) {
        document.getElementById("empnoDiv").classList.add("has-error");
        document.getElementById("msg").textContent = "Employee number can't be empty";
        document.getElementById("msg").style.color = 'red';
    } else {

     fetch("/Employees/" + document.getElementById("empno").value, {
       method: "DELETE"
      })
       .then(response => {
        if (!response.ok) {
          throw Error(response);
        }
            document.getElementById("empnoDiv").classList.remove("has-error");
            document.getElementById("empno").value = "";
            document.getElementById("msg").textContent = response;
            document.getElementById("msg").style.color = 'green';
            alert("Success");
          })
          .catch(error => {
            // fix
            document.getElementById("empnoDiv").classList.add("has-error");
            document.getElementById("msg").textContent = error.responseText;
            document.getElementById("msg").style.color = 'red';
          });
    }

}