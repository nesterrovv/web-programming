let y;
let r;
let x;
let coordinatesX;
let coordinatesY;
drawAll();
document.getElementById("area_svg").addEventListener("mousedown", function (e){
    console.log("CLICK");
    if (!checkR()){
        alert("You forgot to choose R parameter. Do this.");
        return;
    }
    coordinatesX = (e.offsetX -150) / 120 * r ;
    coordinatesY = (150 - e.offsetY) / 120 * r;
    // TODO get x and y from image and put it from form, after that submit -> draw points
    console.log("drawing...")
    //drawPoint(coordinatesX, coordinatesY, r, checkAnswer(coordinatesX, coordinatesY, r), checkR());
    document.getElementById("hidden-f:coord-xx").value = coordinatesX.toString().substr(0, 4);
    document.getElementById("hidden-f:coord-yy").value = coordinatesY.toString().substr(0, 4);
    document.getElementById("hidden-f:coord-rr").value = $("#input-f").find("input:checked")[1].value;
    document.getElementById("hidden-f:submitBtn2").click();

    console.log("ротебалблятьэтойхуйни");
    console.log("to hidden form: ", coordinatesX.toString().substr(0, 4), coordinatesY.toString().substr(0, 4), $("#input-f").find("input:checked")[1].value);
    setTimeout(function () {
        //drawPoint(coordinatesX, coordinatesY, r, checkAnswer(coordinatesX, coordinatesY, r), checkR());
    }, 300);
    console.log("drawing done")
});

$("#input-f").find("input[type=radio]").click(function() {
    deletePoints();
    drawAll();
});

document.getElementById("hidden-f:submitBtn2").addEventListener('click', function (e) {
    xxxx = document.getElementById("hidden-f:coord-xx").value;
    yyyy = document.getElementById("hidden-f:coord-yy").value;
    rrrr = document.getElementById("hidden-f:coord-rr").value;
    console.log("in hidden form:", xxxx, yyyy, rrrr);
    let ok1 = checkX(xxxx, -2, 1.5);
    let ok2 = checkY(yyyy, -5, 5);
    if (ok1 && ok2 && checkR()){
        setTimeout(function () {
            drawPoint(xxxx, yyyy, rrrr, checkAnswer(xxxx, yyyy, rrrr), true);
        }, 300);
    }
    return false;
});

document.getElementById("input-f:submitBtn").addEventListener('click', function (e) {
    xxx = $("#input-f").find("input:checked")[0].value;
    yyy = document.getElementById("input-f:coord-y").value;
    rrr = $("#input-f").find("input:checked")[1].value;
    let ok1 = checkX(xxx, -2, 1.5);
    let ok2 = checkY(yyy, -5, 5);
    if (ok1 && ok2 && checkR()){
        setTimeout(function () {
            drawPoint(xxx, yyy, rrr, checkAnswer(xxx, yyy, rrr), true);
        }, 300);
    }
    return false;
});

function checkX(el, min, max){
    let check = false;
    try {
        check = el >= min && el <= max;
    }catch (e){
        check = false;
    }
    if (!check){
        alert("Incorrect X value. It must be from [-2; 1.5]");
    }
    return check;
}

function checkY(el, min, max){
    let check = false;
    try {
        check = el > min && el < max;
    }catch (e){
        check = false;
    }
    if (!check){
        alert("Incorrect Y value. It must be from (-5; 5).");
    }
    return check;
}

function checkR() {
    let check = $("#input-f").find("input:checked").length;
    if (check == 2) {
        x = $("#input-f").find("input:checked")[0].value;
        r = $("#input-f").find("input:checked")[1].value;
        return true
    } else{
        return false;
    }
}

function drawAll() {
    $(".outputTable tbody tr").each(function () {
        let xP = parseFloat($(this).find("td:nth-child(1)").text());
        let yP = parseFloat($(this).find("td:nth-child(2)").text());
        //let rP = parseFloat($(this).find("td:nth-child(3)").text());
        console.log(xP, yP);
        let rP;
        console.log($("#input-f").find("input:checked").length);
        if (typeof $("#input-f").find("input:checked")[1] == "undefined") {
            rP = 1;
            console.log("yeah");
        } else rP = $("#input-f").find("input:checked")[1].value;
        //let rP = $("#input-f").find("input:checked")[1].value;
        let ansP = $(this).find("td:nth-child(6)").text().toString().trim().toLowerCase();
        let flagR;
        let flagColor;
        if (!isNaN(xP) && !isNaN(yP)) {
            flagColor = !(ansP.length == 2);
            if (r) {
                flagR = (r == rP);
                drawPoint(xP, yP, rP, flagColor, flagR);
            } else {
                flagR = false;
                drawPoint(xP, yP, rP, flagColor, flagR);
            }
        }
    });
}

function drawPoint(x, y, r, color, flagR) {
    let point = document.createElementNS("http://www.w3.org/2000/svg", 'circle');
    point.setAttribute('cx', (120 * x / r + 150).toString());
    point.setAttribute('cy', (-120 * y / r + 150).toString());
    point.setAttribute('r', 3 .toString());
    point.setAttribute('data-x', x);
    point.setAttribute('data-y', y);
    point.classList.add("circle");
    if (!flagR) {
        point.style.fill = "blue";
    }
    else if (color){
        point.style.fill = "green";
    }
    else {
        point.style.fill = "red";
    }
    document.getElementsByTagName("svg")[0].appendChild(point);
    console.log("adding to table");

}


function deletePoints() {
    var svg = document.getElementsByTagName("svg")[0].getElementsByClassName("circle");
    $(svg).remove();
}

document.getElementById("input-f:clearBtn").addEventListener('click', function (e) {
    deletePoints();
});


function checkAnswer(xx, yy, rr) {
    return (xx >= 0 && yy >= 0 && xx * xx + yy * yy <= rr * rr) ||
        (xx <= 0 && yy <= 0 && xx >= -rr && yy >= -rr) ||
        (xx >= 0 && yy <= 0 && yy >= (xx - rr));
}