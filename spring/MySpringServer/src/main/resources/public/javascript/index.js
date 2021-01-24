const cities = ['Bat-Yam', 'Ramla', 'Pardesia', 'Jerusalem', 'Dimona', 'Shoham'];

const addCities = () => {
  cities.forEach((city) => {
    const to = document.createElement('option');
    to.innerHTML = city;
    document.getElementById('to').appendChild(to);
    const from = document.createElement('option');
    from.innerHTML = city;
    document.getElementById('from').appendChild(from);
  });
};

const confirmInput = () => {
  const choiceReg = /^(?!Choose...$).*$/;
  const amountReg = /^[1-4]$/;

  const to = document.getElementById('to');
  const toChosen = to.options[to.selectedIndex].value;

  const from = document.getElementById('from');
  const fromChosen = from.options[from.selectedIndex].value;

  const amountOfPeople = document.getElementById('people-amount').value;

  if(!(choiceReg.test(toChosen)) || !(choiceReg.test(fromChosen)) || !(amountReg.test(amountOfPeople))) {
    let alertMsg = 'אנא תקן את השדות הבאים.\n';

    if (!(choiceReg.test(toChosen))) {
      alertMsg += 'מקור היעד\n';
    }

    if (!(choiceReg.test(fromChosen))) {
      alertMsg += 'מקור המוצא\n';
    }

    if (!(amountReg.test(amountOfPeople))) {
      alertMsg += 'מספר האנשים\n';
    }

    alert(alertMsg);
  } else {
    const time = document.getElementById('time').value;
    const date = document.getElementById('date').value;
    localStorage.setItem('to', toChosen);
    localStorage.setItem('from', fromChosen);
    localStorage.setItem('orderTime', time);
    localStorage.setItem('orderDate', date);
    localStorage.setItem('people-amount', amountOfPeople);
    window.location = '/views/taxi-order.html';
  };
};

const returnPreiviusChoices = () => {
  if(localStorage.length != 0) {
    const to = localStorage.getItem('to');
    const from = localStorage.getItem('from');
    const orderTime = localStorage.getItem('orderTime');
    const orderDate= localStorage.getItem('orderDate');
    const peopleAmount = localStorage.getItem('people-amount');

    const toOptions = document.getElementById('to');
    toOptions.options[toOptions.selectedIndex].text = to;

    const fromOptions = document.getElementById('from');
    fromOptions.options[fromOptions.selectedIndex].text = from;

    document.getElementById('time').value = orderTime;
    document.getElementById('date').value = orderDate;
    document.getElementById('people-amount').value = peopleAmount;
  }
};

window.onload = () => {
  returnPreiviusChoices();
  addCities();
  document.getElementById('continue').addEventListener('click', confirmInput);
};