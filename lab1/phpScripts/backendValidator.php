<?php

function validate($x, $y, $r){
    if (!(is_numeric($x) && is_numeric($y) && is_numeric($r))) {
        return false;
    }
    if ($x <= -5 || $x >= 3) {
        return false;
    }
    if ($y <= -5 || $y >= 3) {
        return false;
    }
    if (!(($r == 1) || ($r == 2) || ($r == 3) || ($r == 4) || ($r == 5))) {
        return false;
    }
    return true;
}