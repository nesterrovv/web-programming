<?php

require_once "backendValidator.php";
require_once "areaChecker.php";

date_default_timezone_set('Europe/Moscow');

$start = microtime(true);
$current_time = date("H:i:s");

if (isset($_POST["x"]) && isset($_POST["y"]) && isset($_POST["r"])) {
    $x = $_POST["x"];
    $y = $_POST["y"];
    $r = $_POST["r"];
    //console.log($x);
    if (validate($x, $y, $r)) {
        $hit_result = pointInArea($x, $y, $r) ? "<span style='color: #0fc40f'>TRUE</span>" : "<span style='color: red'>FALSE</span>";
        $execution_time = number_format(microtime(true) - $start, 8, ".", "") * 1000000;
        die(<<<_END
        <tr>
            <th style="max-width: 300px; word-wrap: break-word">$x</th>
            <th>$y</th>
            <th>$r</th>
            <th>$current_time</th>
            <th>$execution_time</th>
            <th>$hit_result</th>
        </tr>
_END
        );
    }
    die("Data is incorrect! Try again!");
}
die("Data is incorrect! Try again!");

?>