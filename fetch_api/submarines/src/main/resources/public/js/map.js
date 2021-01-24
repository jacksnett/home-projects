let img = new Image();
let submarineImage = new Image();

let canvas;
let ctx;
let canvasOffset;
let offsetX;
let offsetY;
let canvasWidth;
let canvasHeight;
let isDragging;

function Submarine(x, y, id) {
    this.x = x;
    this.y = y;
    this.id = id;
    this.size = 30;
    this.isClicked = false;
}

let dotSize = 30;

let submarineDots = [];

let startX = 0;
let startY = 0;
let currX = 0;
let currY = 0;
let imageOffsetX = 0;
let imageOffsetY = 0;
let zoomOffset = 1;
let isMapLoaded = false;

function loadMapPage() {
    startX = 0;
    startY = 0;
    currX = 0;
    currY = 0;
    imageOffsetX = 0;
    imageOffsetY = 0;
    zoomOffset = 1;

    canvas = document.getElementById("canvas");
    ctx = canvas.getContext("2d");
    canvasOffset = $("#canvas").offset();
    offsetX = canvasOffset.left;
    offsetY = canvasOffset.top;
    isDragging = false;

    img.src = "..\\images\\map.jpg";
    submarineImage.src = "..\\images\\submarine.png";

    img.onload = function() {
        img.width *= 0.7;
        img.height *= 0.7;
    
        canvas.onmouseup = function (e) {
            const positionInCanvas = getMousePos(canvas, e);
            clickedSubmarine = submarineDots.find(dot => {
                const submarineCenter = new Submarine(dot.x + dotSize / 2, dot.y + dotSize / 2);
                return Math.sqrt(Math.pow(positionInCanvas.x - submarineCenter.x, 2) + Math.pow(positionInCanvas.y - submarineCenter.y, 2)) <= dotSize / 2;
            });
    
            if (clickedSubmarine) {
                clickedSubmarine.isClicked = !clickedSubmarine.isClicked;
                drawMap();
            }
        }
    
        canvas.width = img.width;
        canvas.height = img.height;
        canvasWidth = canvas.width;
        canvasHeight = canvas.height;
        drawMap();
        drawSubmarines();
        isMapLoaded = true;
    }
}

function getMousePos(canvas, evt) {
    let rect = canvas.getBoundingClientRect();
    return {
        x: evt.clientX - rect.left,
        y: evt.clientY - rect.top
    };
}

function drawMap() {
    let canvasX = currX - startX + imageOffsetX;
    let canvasY = currY - startY + imageOffsetY;

    ctx.clearRect(0, 0, canvasWidth * zoomOffset, canvasHeight * zoomOffset);
    ctx.drawImage(img, canvasX, canvasY, img.width, img.height);
    drawSubmarines();
}

async function drawSubmarines() {
    if (submarineDots.length === 0) {
        submarineDots = await getSubmarines();
    }
    
    // Go over all the submarineDots
    for (let nDocIndex = 0; nDocIndex < submarineDots.length; nDocIndex++) {
        let dot = submarineDots[nDocIndex];
        let submarineSize = dot.size;
        if (dot.isClicked) {
            submarineSize += dot.size / 2
        }
        ctx.drawImage(submarineImage,
            dot.x + imageOffsetX + currX - startX,
            dot.y + imageOffsetY + currY - startY,
            submarineSize,
            submarineSize);
    }
}

function showLoader() {
    $('#loading-modal').modal("show");  
}

function hideLoader() {
    $('#loading-modal').modal('hide'); 
}

function showImageFromSubmarineModal(src) {
    $('#submarine-picture-modal').modal("show");  
    document.querySelector('#submarine-picture').src = src;
}

loadMapPage();