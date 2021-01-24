const showPeopleTable = (data) => {
	document.getElementById("PeopleTable").innerHTML = "";

	let toAdd = document.createElement("tr"); 
	toAdd.innerHTML = "<th> ID </th> <th> שם פרטי</th> <th> שם משפחה </th>";
	document.getElementById("PeopleTable").appendChild(toAdd);
		
	data.forEach((person) => {
		toAdd = document.createElement("tr"); 
		toAdd.innerHTML = 	"<td> " + person.id + "</td>" +
							"<td> " + person.firstname + "</td>" +
							"<td> " + person.lastname + "</td>";
		document.getElementById("PeopleTable").appendChild(toAdd);
	});
};


document.addEventListener("DOMContentLoaded", () => {

	// EXAMPLE 1
    document.getElementById("GetButton").addEventListener("click", () => {

        // TODO: Fetch get request`

    }, false);

	// EXAMPLE 2
    document.getElementById("CatchButton").addEventListener("click", () => {

		// TODO: Fetch get request with catch
		
	}, false);
	
	// EXAMPLE 3
    document.getElementById("PostButton").addEventListener("click", () => {

		const personToAdd = {
			id: document.getElementById("idInput").value,
			firstname: document.getElementById("firstNameInput").value,
			lastname: document.getElementById("lastNameInput").value
		};

		// TODO: Fetch post request

    }, false);
	
	// EXAMPLE 4
    document.getElementById("AsyncButton").addEventListener("click", () => {

		// Fetch get request
		fetch("/people", {})
		.then((response) => {
			return (response.json());
		}).then(showPeopleTable)
		.catch((error) => {
			alert("There was an error with getting the data");
		});

		alert("ASYNC!");
		
    }, false);
	
	// EXAMPLE 5
	document.getElementById("NotWorkingButton").addEventListener("click", () => {
		let people;
		
		fetch("/people", {})
		.then((response) => {
			return (response.json());
		}).then((data) => {
			people = data;
		})
		.catch((error) => {
			alert("There was an error with getting the data");
		});
		
		console.log(people);
		for (var index = 0; index < people.length; index++) {
			console.log(people[index]);
			// Do some more stuff with current person
		}
    }, false);
});