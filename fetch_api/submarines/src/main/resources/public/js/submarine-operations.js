const changeSubmarinesLocationsRandomly = async () => {
    let clickedSubs = submarineDots.filter((submarine) => submarine.isClicked);

    if(clickedSubs.length === 0) {
        alert('choose submarines first. ');
    } else  {
        const updatedSubmarines = [];
        showLoader();
 
        clickedSubs.forEach(async (clickedSub) => {
            const result = await fetch(`/submarines/${clickedSub.id}/random-location`, {
                method: 'PATCH'
            });
            const updatedSub = result.json();
            updatedSubmarines.push(updatedSub);
        })

    // 4. Update Submarines on map: Already implemented
        updateSubmarinesInMap(updatedSubmarines);

   // 5. Hide Loader: Already implemented
        hideLoader();
    }
}

const getSubmarines = async () => {
    const result = await fetch("/submarines");
    const allSubs = await result.json();

    return allSubs.map(({x, y, id}) => new Submarine(x, y, id));
}

const getSubmarinePicture = async () => {
    let clickedSubs = submarineDots.filter((submarine) => submarine.isClicked);

    if(clickedSubs.length != 1) {
        alert('choose one submarine to continue. ');
    } else {
        const result = await (fetch(`/submarines/6/is-picture-available`));
        const answer = result.json();
        console.log(answer);
    }

    // 2. Check if picture is available for submarine

    // 3. Get picture id

    // 4. Get image from server and get array buffer from response

    // 5. Turn array buffer from response to base 64 string and apply to the picture: already implemented
    const base64Flag = 'data:image/jpeg;base64,';
    const imageStr = arrayBufferToBase64(buffer);
    showImageFromSubmarineModal(base64Flag + imageStr);
}

// ------------------------ HELP METHODS -----------------------------

// Turns fetch array buffer to 64 bit img string
const arrayBufferToBase64 = (buffer) => {
    let binary = '';
    const bytes = [].slice.call(new Uint8Array(buffer));
    bytes.forEach((b) => binary += String.fromCharCode(b));
    return window.btoa(binary);
}

// This methods receives an array of the updated submarines and renders them to the map
const updateSubmarinesInMap = (updatedSubmarines) => {
    updatedSubmarines.forEach(updatedSubmarine => {
        const submarineInMap = submarineDots.find(submarine => submarine.id === updatedSubmarine.id);
        submarineInMap.x = updatedSubmarine.x;
        submarineInMap.y = updatedSubmarine.y;
        submarineInMap.isClicked = false;
    });

    drawMap();
}


// ----------------------- DO NOT TOUCH --------------------------------
document.addEventListener('DOMContentLoaded', () => {
    document.getElementById('random-location').addEventListener('click', changeSubmarinesLocationsRandomly);
    document.getElementById('submarine-picture-button').addEventListener('click', getSubmarinePicture);
});