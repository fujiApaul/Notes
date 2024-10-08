const currentLocationInput = document.getElementById('current-location');
const destinationSelect = document.getElementById('destination');
const calculateButton = document.getElementById('calculate');
const resultDiv = document.getElementById('result');

const distances = {
  // Replace with your actual distances from the image
  A: 15,
  B: 5,
  C: 24,
  D: 50,
  E: 35
};

calculateButton.addEventListener('click', () => {
  const currentLocation = parseInt(currentLocationInput.value);
  const destination = destinationSelect.value;

  if (isNaN(currentLocation)) {
    resultDiv.textContent = "Please enter a valid number for your current location.";
    return;
  }

  const distance = distances[destination];
  const totalDistance = currentLocation + distance;

  resultDiv.textContent = `Nearest: ${destination}
  No. of km from your location: ${totalDistance} km`;
});