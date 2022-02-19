<?php
/**
 * The module of checking whether a point with given x & y
 * coordinates belongs to the area specified in the variant
 * @param $x - value of x variable from html-form
 * @param $y - value of y variable from html-form
 * @param $r - value of R parameter from html-form
 * @return bool - result of checking
 */

function pointInFirstQuarter($x, $y, $r) {
    return ($x * $x + $y * $y <= $r * $r) && ($x >= 0 && $y >= 0);
}

function pointInThirdQuarter($x, $y, $r) {
    return ($x >= $r * (-1)) && ($y >= $r * (-1)) && ($x <= 0 && $y <= 0);
}

function pointInFourthQuarter($x, $y, $r) {
    return ($y >= $x - $r/2) && ($x >= 0 && $y <= 0);
}

function pointInArea($x, $y, $r) {
    return pointInFirstQuarter($x, $y, $r) || pointInThirdQuarter($x, $y, $r)
        || pointInFourthQuarter($x, $y, $r);
}

