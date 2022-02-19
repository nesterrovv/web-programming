document.getElementById('form').addEventListener("submit", validateData);

function receiveDataFromForm() {
    var x = document.getElementById('x').value;
    var y = document.getElementById('y').value;
    var r = document.querySelector('input[name="r"]:checked').value;
    return [x, y, r];
}

function receiveErrors() {
    var xError = document.getElementById('xError');
    var yError = document.getElementById('yError');
    var rError = document.getElementById('rError');
}

function isNumber(number) {
    if (number != null && number != "") {
        if (/^(0$|-?[1-9]\d*(\.\d*[1-9]$)?|-?0\.\d*[1-9])$/.test(number)) {
            return true;
        }
    }
    return false;
}

function isCorrectNumber(number) {
    if (number > -5 && number < 3) {
        return true;
    }
    return false;
}

function validateData(event) {
    event.preventDefault();
    var data = receiveDataFromForm();
    var errors = receiveErrors();
    var x = data[0].trim();
    var y = data[1].trim();
    var r = data[2] .trim();
    var xError = errors[0];
    var yError = errors[1];
    var rError = errors[2];
    var xIsCorrect = false;
    var yIsCorrect = false;
    var rIsCorrect = false;
    if (isNumber(x)) {
        if (isCorrectNumber(x)) {
            xIsCorrect = true;
            xError.innerHTML = "";
        } else {
            xError.innerHTML = "X variable must take value in the range (-5;3)!";
        }
    } else {
        xError.innerHTML = "X value must be a number!";
    }
    if (isNumber(y)) {
        if (isCorrectNumber(y)) {
            yIsCorrect = true;
            yError.innerHTML = "";
        } else {
            yError.innerHTML = "Y variable must take value in the range (-5;3)!";
        }
    } else {
        yError.innerHTML = "Y value must be a number!";
    }
    if (isNumber(r)) {
        rIsCorrect = true;
        rError.innerHTML = "";
    } else {
        rError.innerHTML = "R parameter must take value from [1,2,3,4,5]!";
    }
    if (xIsCorrect && yIsCorrect && rIsCorrect) {
        return true;
    } else return false;
}