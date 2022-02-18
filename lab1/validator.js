document.getElementById('form').addEventListener("submit", validateData);

function receiveDataFromForm() {
    var x = document.getElementById('x').value;
    var y = document.getElementById('y').value;
    var r = document.querySelector('input[name="r"]:checked').value;
    return [x, y, r];
}

function validateData() {
    // TODO: validation logic
}