document.getElementById('form').addEventListener("submit", validateData);

function receiveDataFromForm() {
    var x = document.getElementById('x').value;
    var y = document.getElementById('y').value;
    var r = document.querySelector('input[name="r"]:checked').value;
    return [x, y, r];
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

function validateData() {
    // TODO: validation logic
}