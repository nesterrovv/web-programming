function receive(){
    if (validateData(event)){
        let xValue = parseFloat($("#x").val());
        let yValue = parseFloat($("#y").val());
        var rValue = parseInt($(".radio:checked").val());
        console.log("x = ", xValue, "type: ", typeof xValue);
        console.log("y = ", yValue, "type: ", typeof yValue);
        console.log("r = ", rValue, "type: ", typeof rValue);
        var path = 'phpScripts/main.php';
        $.ajax({
            type: 'POST',
            url: path,
            data: {'x': xValue, 'y': yValue, 'r': rValue},
            success: function (data) {
                console.log(data);
                if (data === "Data is incorrect! Try again!") alert("Error: " + data);
                else $('#request-history tr:last').after(data);
            },
            error: function (data) {
                console.log('x = ' + xValue);
                console.log('y = ' + yValue);
                console.log('r = ' + rValue);
                console.log("data = " + data);
                alert("Error: " + data);
            }
        })
    }
}