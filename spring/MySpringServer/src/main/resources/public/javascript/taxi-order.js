const taxies = [
  {name: "ריק פוץ", image: "https://thumbs.dreamstime.com/b/yellow-taxi-new-york-city-usa-115345108.jpg"},
  {name: "סרחיו רגילון", image: "https://thumbs.dreamstime.com/b/yellow-taxi-new-york-city-usa-115345108.jpg"},
  {name: "סרחיו בוסקטס", image: "https://thumbs.dreamstime.com/b/yellow-taxi-new-york-city-usa-115345108.jpg"},
  {name: "קלמנט לנגלה", image: "https://thumbs.dreamstime.com/b/yellow-taxi-new-york-city-usa-115345108.jpg"},
  {name: "סרחיו ראמוס", image: "https://thumbs.dreamstime.com/b/yellow-taxi-new-york-city-usa-115345108.jpg"},
  {name: "דני אבדיה", image: "https://thumbs.dreamstime.com/b/yellow-taxi-new-york-city-usa-115345108.jpg"},
];

const getPrice = () => {
  const totalPrice = Math.floor(Math.random()*(50)+1);
  const peopleOnTaxi = localStorage.getItem('people-amount');
  const pricePerPassenger = Math.floor(totalPrice / peopleOnTaxi);

  const priceStr = `מחיר עבור אדם ${pricePerPassenger} שקלים <br> מחיר כולל: ${totalPrice} שקלים`;

  return priceStr;
};

const loadCards = () => {
  taxies.forEach((taxi) => {
    const container = document.createElement('div');
    container.classList.add('mb-4');
    container.classList.add('col-4');
    container.classList.add('d-flex');
    container.classList.add('justify-content-around');
  
    const card = document.createElement('div');
    card.classList.add('card');
    card.classList.add('text-center');
    card.setAttribute('style', 'width: 14rem;');
  
    const cardImage = document.createElement('img');
    cardImage.classList.add('card-img-top');
    cardImage.setAttribute('src', taxi.image);
    card.appendChild(cardImage);
  
    const cardBody = document.createElement('div');
    cardBody.classList.add('card-body');

    const cardTitle = document.createElement('h5');
    cardTitle.classList.add('card-title');
    cardTitle.innerHTML = taxi.name;
    cardBody.appendChild(cardTitle);

    const cardText = document.createElement('p');
    cardText.innerHTML = getPrice();
    cardBody.appendChild(cardText);

    const orderBottun = document.createElement('button');
    orderBottun.classList.add('btn');
    orderBottun.classList.add('btn-primary');
    orderBottun.setAttribute('type', 'button');
    orderBottun.setAttribute('data-toggle', 'modal');
    orderBottun.setAttribute('data-target', '#exampleModalCenter');
    orderBottun.innerHTML = 'הזמן';
    cardBody.appendChild(orderBottun);

    card.appendChild(cardBody);
    container.appendChild(card);
    document.getElementById('card-deck').appendChild(container);
  });
};

const goBack = () => {
  window.location = './index.html';
};

const reload = () => {
  location.replace('./index.html');
};

const addModalBody = () => {
  const to = localStorage.getItem('to');
  const from = localStorage.getItem('from');
  const orderTime = localStorage.getItem('orderTime');
  const orderDate= localStorage.getItem('orderDate');

  const modelBody = 
  `${from} המונית מ<br>
  ${to} ל<br>
  ${orderTime} תגיע בשעה<br>
  ${orderDate} בתאריך`;

  document.getElementById('modal-body').innerHTML = modelBody;
};

window.onload = () => {
  loadCards();
  document.getElementById('back').addEventListener('click', goBack);
  addModalBody();
  document.getElementById('close').addEventListener('click', goBack);
};