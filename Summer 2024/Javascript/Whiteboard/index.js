function findNearestLocation(locations, currentLocation, destination) {
    let nearestLocation = null;
    let nearestDistance = Infinity;
  
    locations.forEach(location => {
      if (location.name === destination) {
        const distance = Math.abs(location.distance - currentLocation);
  
        if (distance < nearestDistance) {
          nearestLocation = location;
          nearestDistance = distance;
        } else if (distance === nearestDistance) {
          if (!Array.isArray(nearestLocation)) {
            nearestLocation = [nearestLocation];
          }
          nearestLocation.push(location);
        }
      }
    });
  
    return nearestLocation;
  }
  
  // Example usage:
  const locations = [
    { name: "Fast Food 1", distance: 5 },
    { name: "Police Station 1", distance: 15 },
    { name: "Mall 1", distance: 24 },
    { name: "Bank 1", distance: 35 },
    { name: "Fast Food 2", distance: 46 },
    { name: "Church", distance: 50 },
    { name: "Police Station 2", distance: 57 },
    { name: "Mall 2", distance: 72 },
    { name: "Fast Food 3", distance: 85 },
    { name: "Bank 2", distance: 85 },
    { name: "Fast Food 4", distance: 95 }
  ];
  
  function findNearestLocationAndDisplay() {
    const currentLocation = parseInt(document.getElementById("currentLocation").value);
    const destination = document.getElementById("destination").value;
  
    const nearestLocation = findNearestLocation(locations, currentLocation, destination);
  
    const resultDiv = document.getElementById("result");
  
    if (Array.isArray(nearestLocation)) {
      resultDiv.textContent = "Multiple locations have the same distance:";
      nearestLocation.forEach(location => {
        resultDiv.textContent += `\n${location.name}`;
      });
    } else {
      resultDiv.textContent = `Nearest ${destination}: ${nearestLocation.name}`;
    }
  }
