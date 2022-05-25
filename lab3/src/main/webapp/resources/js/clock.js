function clock() {
    let date = new Date(),
        months = ["January","February","March","April","May","June","July","August","September","October","November","December"],
        days = (date.getDate() < 10) ? '0' + date.getDate() : date.getDate(),
        hours = (date.getHours() < 10) ? '0' + date.getHours() : date.getHours(),
        minutes = (date.getMinutes() < 10) ? '0' + date.getMinutes() : date.getMinutes(),
        seconds = (date.getSeconds() < 10) ? '0' + date.getSeconds() : date.getSeconds();
    document.getElementById("date").innerText = days + ' ' +  months[date.getMonth()]  + ' ' + date.getFullYear();
    document.getElementById("clock").innerText = hours + ':' + minutes + ':' + seconds;
}
setTimeout(clock,0);
setInterval(clock, 11000);