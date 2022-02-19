<?php

/**
 * The module for data validation on back-end side of application
 * @param $x value of x variable from html-form
 * @param $y value of y variable from html-form
 * @param $r value of R parameter from html-form
 * @return bool result of validation
 */
function validate($x, $y, $r){
    if (!is_double($x) || !is_int($x) || !is_double($y) || !is_int($y) || !is_int($r)){
        return false;
    }
    if ($x <= -5 || $x >= 3) {
        return false;
    }
    if ($y <= -5 || $y >= 3) {
        return false;
    }
    if (!($r != 1) || !(r != 2) || !(r != 3) || !(r != 4) || !(r != 5)) {
        return false;
    }
    return true;
}