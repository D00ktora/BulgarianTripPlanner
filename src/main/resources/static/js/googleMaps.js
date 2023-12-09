// let map;
// const biasInputElement = document.getElementById("use-location-bias");
// const strictBoundsInputElement = document.getElementById("use-strict-bounds");
//
// async function initMap() {
//     const { Map } = await google.maps.importLibrary("maps");
//     const directionsRenderer = new google.maps.DirectionsRenderer();
//     const directionsService = new google.maps.DirectionsService();
//     let myCoordinates = {
//         lat: 43.835571,
//         lng: 25.965654
//     }
//
//     map = new Map(document.getElementById("map"), {
//         center: { lat: 43.835571, lng: 25.965654 },
//         zoom: 13,
//     });
//
//     directionsRenderer.setMap(map);
//     calculateAndDisplayRoute(directionsRenderer, directionsService);
//     document.getElementById("submit").addEventListener("click", () => {
//         calculateAndDisplayRoute(directionsRenderer, directionsService)
//     })
//
// }
//
// function calculateAndDisplayRoute(directionsRenderer, directionsService) {
//     var start = document.getElementById('from').value;
//     var end = document.getElementById('to').value;
//     var request = {
//         origin: start,
//         destination: end,
//         travelMode: 'DRIVING'
//     };
//
//     directionsService.route(request, function(result, status) {
//         if (status == 'OK') {
//             directionsRenderer.setDirections(result);
//             //get distance and time.
//             const output = document.querySelector("#output");
//             output.innerHTML = "<div class='alert-info'> From: " + document.getElementById("from").value + ".<br/> To: " + document.getElementById("to").value + ". <br/> Driving distance <i class='bi bi-car-front-fill'></i>: " + result.routes[0].legs[0].distance.text + ". <br/> Duration <i class='bi bi-hourglass-split'></i>: " + result.routes[0].legs[0].duration.text + ". </div>";
//         }
//         else {
//             directionsRenderer.setDirections({routes : []});
//             map.setCenter(myCoordinates);
//             output.innerHTML = "<div class='alert-danger'><i class='bi bi-exclamation-octagon-fill'></i> Could not retrieve driving distance. </div>"
//         }
//     });
// }
//
//
//
//
// // initMap();
//
//
